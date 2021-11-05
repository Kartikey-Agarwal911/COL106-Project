package DSCoinPackage;

import HelperClasses.MerkleTree;
import HelperClasses.CRF;

public class TransactionBlock {

  public Transaction[] trarray;
  public TransactionBlock previous;
  public MerkleTree Tree;
  public String trsummary;
  public String nonce;
  public String dgst;

  TransactionBlock(Transaction[] t) {

    int trsize = t.length;
    trarray = new Transaction[trsize];

    for (int i = 0; i < t.length; i++) {
      trarray[i] = new Transaction(t[i]);
    }

    this.previous = null;
    Tree = new MerkleTree();
    trsummary = Tree.Build(trarray);
    this.dgst = null;
    
  }

  public boolean checkTransaction (Transaction t) {

    TransactionBlock src = t.coinsrc_block;
    
    Boolean flag = false;

    if(src != null){
      for (int i = 0; i < src.trarray.length; i++) {
      
        if(src.trarray[i]!= null && src.trarray[i].coinID.equals(t.coinID)){
          if(src.trarray[i].Destination == t.Source){
            flag = true;
          }
        }
        
      }
  
      if(!flag)
        return false;
    }

    
    
    int totalCoinID = 0;
    for (int i = 0; i < trarray.length; i++) {
      if(trarray[i] != null && trarray[i].coinID.equals(t.coinID)){
        totalCoinID++;
      }
    }

    if(totalCoinID > 1){
      return false;
    }

    TransactionBlock current = this.previous;
    // TransactionBlock current = this;
    TransactionBlock dest = t.coinsrc_block;
    

    while(current != dest ){
      for (int i = 0; i < current.trarray.length; i++) {
        if(current.trarray[i]!= null  && current.trarray[i].coinID.equals(t.coinID)){
          return false;
        }
      }
      current = current.previous;
    }

    return true;
  }
}

