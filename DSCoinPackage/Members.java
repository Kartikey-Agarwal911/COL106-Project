package DSCoinPackage;

import java.util.*;

import HelperClasses.MerkleTree;
import HelperClasses.Pair;
import HelperClasses.TreeNode;

public class Members {

  public String UID;
  public List<Pair<String, TransactionBlock>> mycoins;
  public Transaction[] in_process_trans;

  public void initiateCoinsend(String destUID, DSCoin_Honest DSobj) {

    Pair<String, TransactionBlock> coin = mycoins.remove(0);

    Transaction tobj = new Transaction();
    tobj.coinID = coin.get_first();
    tobj.Source = this;

    for (int i = 0; i < DSobj.memberlist.length; i++) {
      if (DSobj.memberlist[i].UID.equals(destUID)) {
        tobj.Destination = DSobj.memberlist[i];
        break;
      }
    }

    tobj.coinsrc_block = coin.get_second();

    Boolean flag = false;

    if(in_process_trans == null)
      in_process_trans = new Transaction[100];

    for (int i = 0; i < in_process_trans.length; i++) {
      if (in_process_trans[i] == null) {
        in_process_trans[i] = tobj;
        flag = true;
        break;
      }
    }

    if (!flag) {
      Transaction[] pointer = in_process_trans;
      in_process_trans = new Transaction[pointer.length + 1];

      for (int i = 0; i < pointer.length; i++) {
        in_process_trans[i] = pointer[i];
      }
      in_process_trans[pointer.length] = tobj;

    }

    DSobj.pendingTransactions.AddTransactions(tobj);

  }

  public Pair<List<Pair<String, String>>, List<Pair<String, String>>> finalizeCoinsend(Transaction tobj,
      DSCoin_Honest DSObj) throws MissingTransactionException {


    TransactionBlock iter = DSObj.bChain.lastBlock;

    Boolean flag = false;
    int loc = 0;

    while (iter != null) {

      for (int i = 0; i < iter.trarray.length; i++) {
        if (iter.trarray[i].equals(tobj)) {
          loc = i;
          flag = true;
          break;
        }
      }
      if (flag)
        break;
      iter = iter.previous;
    }

    if (iter == null)
      throw new MissingTransactionException();

    MerkleTree t = iter.Tree;

    List<Pair<String, String>> sib_path = QueryDocument(loc, t);

    List<Pair<String, String>> block_chain_list = new ArrayList<>();

    TransactionBlock list_iter = DSObj.bChain.lastBlock;

    while (list_iter != iter) {
      block_chain_list.add(0, new Pair<String, String>(list_iter.dgst,
          list_iter.previous.dgst + "#" + list_iter.trsummary + "#" + list_iter.nonce));

      list_iter = list_iter.previous;
    }

    String init = iter.previous == null ? BlockChain_Malicious.start_string : iter.previous.dgst;

    block_chain_list.add(0, new Pair<String, String>(iter.dgst, init + "#" + iter.trsummary + "#" + iter.nonce));

    block_chain_list.add(0, new Pair<String, String>(init, null));

    int i = 0;
    for (i = 0; i < in_process_trans.length; i++) {
      if (in_process_trans[i].equals(tobj)) {
        break;
      }
    }


    for ( int j = i; j < in_process_trans.length -1; j++) {
      in_process_trans[i] = in_process_trans[i+1];
    }

    // Transaction[] pointer = in_process_trans;
    // in_process_trans = new Transaction[pointer.length - 1];
    // int k = 0;
    // for (int j = 0; j < in_process_trans.length; j++) {
    //   if (j != i) {
    //     in_process_trans[k] = pointer[j];
    //     k += 1;
    //   }
    // }

    Pair<List<Pair<String, String>>, List<Pair<String, String>>> toret = new Pair<>(sib_path, block_chain_list);
    tobj.Destination.append(tobj.coinID, iter);

    return toret;
  }

  public void MineCoin(DSCoin_Honest DSObj){

    Transaction[] mine = new Transaction[DSObj.bChain.tr_count];
    int i = 0;
    while (i < DSObj.bChain.tr_count - 1) {

      Transaction t = null;
      try {
        t = DSObj.pendingTransactions.RemoveTransaction();
      } catch (Exception e) {
        //TODO: handle exception
        e.printStackTrace();
      }

      if (TransactionValid(t, DSObj.bChain.lastBlock, mine, i)) {
        mine[i] = t;
        i += 1;
      }
    }
    Transaction mineReward = new Transaction();
    mineReward.coinID = Integer.toString(Integer.valueOf(DSObj.latestCoinID) + 1);
    mineReward.Source = null;
    mineReward.Destination = this;
    mineReward.coinsrc_block = null;

    mine[i] = mineReward;

    DSObj.latestCoinID = Integer.toString(Integer.valueOf(DSObj.latestCoinID) + 1);

    TransactionBlock minedBlock = new TransactionBlock(mine);

    DSObj.bChain.InsertBlock_Honest(minedBlock);

    this.mycoins.add(new Pair<String, TransactionBlock>(mineReward.coinID, minedBlock));

  }

  public void MineCoin(DSCoin_Malicious DSObj) {

    Transaction[] mine = new Transaction[DSObj.bChain.tr_count];
    int i = 0;

    TransactionBlock lastB = DSObj.bChain.FindLongestValidChain();

    while (i < DSObj.bChain.tr_count - 1) {
      Transaction t = null;
      try {
        t = DSObj.pendingTransactions.RemoveTransaction();
      } catch (Exception e) {
        //TODO: handle exception
      }
      

      if (TransactionValid(t, lastB, mine, i)) {
        mine[i] = t;
        i += 1;
      }
    }
    Transaction mineReward = new Transaction();
    mineReward.coinID =  Integer.toString(Integer.valueOf(DSObj.latestCoinID) + 1);
    mineReward.Source = null;
    mineReward.Destination = this;
    mineReward.coinsrc_block = null;

    mine[i] = mineReward;

    DSObj.latestCoinID = Integer.toString(Integer.valueOf(DSObj.latestCoinID) + 1);

    TransactionBlock minedBlock = new TransactionBlock(mine);

    DSObj.bChain.InsertBlock_Malicious(minedBlock);

    this.mycoins.add(new Pair<String, TransactionBlock>(mineReward.coinID, minedBlock));

  }



  // Function for checking transaction

  private Boolean TransactionValid(Transaction t, TransactionBlock lastBlock, Transaction[] mine, int index) {

    
    TransactionBlock src = t.coinsrc_block;
    Boolean flag = false;
    if (src != null) {
      for (int i = 0; i < src.trarray.length; i++) {

        if (src.trarray[i] != null && src.trarray[i].coinID.equals(t.coinID)) {
          if (src.trarray[i].Destination == t.Source) {
            flag = true;
          }
        }

      }

      if (!flag)
        return false;

      TransactionBlock iter = lastBlock;
      while (iter != src) {

        for (int i = 0; i < iter.trarray.length; i++) {
          if (iter.trarray[i] != null && iter.trarray[i].coinID.equals(t.coinID))
            return false;
        }

        iter = iter.previous;
      }
    } else {
      TransactionBlock iter = lastBlock;
      flag = false;
      while (iter != null) {
        for (int i = 0; i < iter.trarray.length; i++) {
          Transaction MinedCoin = iter.trarray[i];
          if(MinedCoin.Source == null && MinedCoin.Destination.UID.equals(t.Source.UID) && MinedCoin.coinsrc_block == null )
            flag = true;
        }
        iter = iter.previous;
        
      }

      if(!flag){
        iter = lastBlock;
        while (iter != null) {

          for (int i = 0; i < iter.trarray.length; i++) {
            Transaction ModCoin = iter.trarray[i];
            if (ModCoin.Source.UID.equals("Moderator") && ModCoin.Destination.UID.equals(t.Source.UID) && ModCoin.coinsrc_block == null){
              flag = true;
            }
          }

          iter = iter.previous;
        }
      }

      if(!flag)
        return false;
    }

    for (int i = 0; i < index; i++) {
      if (mine[i].coinID.equals(t.coinID))
        return false;
    }

    return true;
  }

  // Custom function for path
  public List<Pair<String, String>> QueryDocument(int doc_idx, MerkleTree t) {
    // Implement Code here

    List<Pair<String, String>> retString = new ArrayList<>();
    TreeNode rootnode = t.rootnode;
    int numdocs = t.numdocs;
    TreeNode iter = rootnode;
    retString.add(0, new Pair<String, String>(iter.val, null));
    int DocLocator = numdocs;
    while (DocLocator > 1) {
      retString.add(0, new Pair<String, String>(iter.left.val, iter.right.val));
      DocLocator /= 2;
      if (DocLocator <= doc_idx) {
        doc_idx -= DocLocator;
        iter = iter.right;
      } else {
        iter = iter.left;
      }

    }

    return retString;
  }

  public void append(String CoinId, TransactionBlock tB) {

    for (int i = 0; i < mycoins.size(); i++) {
      if (mycoins.get(i).first.compareTo(CoinId) > 0) {
        mycoins.add(i, new Pair<String, TransactionBlock>(CoinId, tB));
        break;
      }
    }
  }




  public void initiateCoinsend(String destUID, DSCoin_Malicious DSobj) {

    Pair<String, TransactionBlock> coin = mycoins.remove(0);

    Transaction tobj = new Transaction();
    tobj.coinID = coin.get_first();
    tobj.Source = this;

    for (int i = 0; i < DSobj.memberlist.length; i++) {
      if (DSobj.memberlist[i].UID.equals(destUID)) {
        tobj.Destination = DSobj.memberlist[i];
        break;
      }
    }

    tobj.coinsrc_block = coin.get_second();

    Boolean flag = false;

    if(in_process_trans == null)
      in_process_trans = new Transaction[100];

    for (int i = 0; i < in_process_trans.length; i++) {
      if (in_process_trans[i] == null) {
        in_process_trans[i] = tobj;
        flag = true;
        break;
      }
    }

    if (!flag) {
      Transaction[] pointer = in_process_trans;
      in_process_trans = new Transaction[pointer.length + 1];

      for (int i = 0; i < pointer.length; i++) {
        in_process_trans[i] = pointer[i];
      }
      in_process_trans[pointer.length] = tobj;

    }

    DSobj.pendingTransactions.AddTransactions(tobj);

  }











}
