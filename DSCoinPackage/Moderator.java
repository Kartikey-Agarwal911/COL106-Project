package DSCoinPackage;

import HelperClasses.Pair;

public class Moderator
 {

  public void initializeDSCoin(DSCoin_Honest DSObj, int coinCount) {
    Members mod = new Members();
    mod.UID = "Moderator";

    int StrtIndex = 100000;
    

    for (int i = 0; i < coinCount; i++) {
      Transaction t = new Transaction();
      t.Source = mod;
      t.coinID = Integer.toString(i+StrtIndex);
      t.coinsrc_block = null;
      t.Destination = DSObj.memberlist[i%DSObj.memberlist.length];
      DSObj.pendingTransactions.AddTransactions(t);
    }

    while(DSObj.pendingTransactions.size() >=  DSObj.bChain.tr_count){
      ModMine(DSObj);
    }

    DSObj.latestCoinID = Integer.toString(coinCount+StrtIndex-1);

  }

  public void ModMine(DSCoin_Honest DSObj ){
    int trc = DSObj.bChain.tr_count;
    Transaction[] mine = new Transaction[DSObj.bChain.tr_count];
    for (int i = 0; i < mine.length; i++) {
      try {
        mine[i] = DSObj.pendingTransactions.RemoveTransaction();
      } catch (Exception e) {
        //TODO: handle exception
      }
    }

    TransactionBlock minedBlock = new TransactionBlock(mine);

    DSObj.bChain.InsertBlock_Honest(minedBlock);

    for (int i = 0; i < mine.length; i++) {
      mine[i].Destination.mycoins.add(new Pair<String,TransactionBlock>(mine[i].coinID, minedBlock));
    }

  }
    
  public void initializeDSCoin(DSCoin_Malicious DSObj, int coinCount) {

    Members mod = new Members();
    mod.UID = "Moderator";

    int StrtIndex = 100000;
    

    for (int i = 0; i < coinCount; i++) {
      Transaction t = new Transaction();
      t.Source = mod;
      t.coinID = Integer.toString(i+StrtIndex);
      t.coinsrc_block = null;
      t.Destination = DSObj.memberlist[i%DSObj.memberlist.length];
      DSObj.pendingTransactions.AddTransactions(t);
    }

    while(DSObj.pendingTransactions.size() >=  DSObj.bChain.tr_count){
      ModMine(DSObj);
    }

    DSObj.latestCoinID = Integer.toString(coinCount+StrtIndex-1);

  }

  public void ModMine(DSCoin_Malicious DSObj ){
    int trc = DSObj.bChain.tr_count;
    Transaction[] mine = new Transaction[DSObj.bChain.tr_count];
    for (int i = 0; i < mine.length; i++) {
      try {
        mine[i] = DSObj.pendingTransactions.RemoveTransaction();
      } catch (Exception e) {
        //TODO: handle exception
      }
    }

    TransactionBlock minedBlock = new TransactionBlock(mine);


    DSObj.bChain.InsertBlock_Malicious(minedBlock);

    for (int i = 0; i < mine.length; i++) {
      mine[i].Destination.mycoins.add(new Pair<String,TransactionBlock>(mine[i].coinID, minedBlock));
    }

  }

  


}
