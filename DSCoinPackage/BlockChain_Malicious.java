package DSCoinPackage;

import HelperClasses.CRF;
import HelperClasses.MerkleTree;

public class BlockChain_Malicious {

  public int tr_count;
  public static final String start_string = "DSCoin";
  public TransactionBlock[] lastBlocksList;

  public static boolean checkTransactionBlock(TransactionBlock tB) {

    String tBPrevDgst = tB.previous == null ? start_string : tB.previous.dgst;
    CRF crfObj = new CRF(64);

    if (!tB.dgst.substring(0, 4).equals("0000"))
      return false;

    if (!crfObj.Fn(tBPrevDgst + "#" + tB.trsummary + "#" + tB.nonce).equals(tB.dgst))
      return false;

    MerkleTree verifyTree = new MerkleTree();
    String ver = verifyTree.Build(tB.trarray);
    if (!ver.equals(tB.trsummary))
      return false;

    for (int i = 0; i < tB.trarray.length; i++) {
      if (!tB.checkTransaction(tB.trarray[i]))
        return false;
    }

    return true;
  }

  public TransactionBlock FindLongestValidChain() {



    int max = 0;
    TransactionBlock max_block = null;

    for (int i = 0; i < lastBlocksList.length; i++) {
      int chainlength = 0;
      TransactionBlock iter = lastBlocksList[i];
      TransactionBlock chainMax = lastBlocksList[i];
      while (iter != null) {
        if (BlockChain_Malicious.checkTransactionBlock(iter)) {
          chainlength += 1;
        } else {
          chainlength = 0;
          chainMax = iter.previous;
        }

        iter = iter.previous;
      }

      if (chainlength > max) {
        max = chainlength;
        max_block = chainMax;
      }
    }

    return max_block;
  }

  public void InsertBlock_Malicious(TransactionBlock newBlock) {
    TransactionBlock lastBlock = FindLongestValidChain();
    CRF crfObj = new CRF(64);
    newBlock.previous = lastBlock;
    String lastBlockString = lastBlock == null ? start_string : lastBlock.dgst;
    String nonceComputed = GetNonce(lastBlockString, newBlock.trsummary);

    newBlock.nonce = nonceComputed;
    newBlock.dgst = crfObj.Fn(lastBlockString + "#" + newBlock.trsummary + "#" + newBlock.nonce);

    int locn = -1;
    for (int i = 0; i < lastBlocksList.length; i++) {
      if (lastBlocksList[i] == lastBlock) {
        locn = i;
        break;
      }
    }

    if (locn == -1) {

//      Boolean flag = false;
      for (int i = 0; i < lastBlocksList.length; i++) {
        if (lastBlocksList[i] == null) {
          lastBlocksList[i] = newBlock;
//          flag = true;
          break;
        }
      }

//      if (!flag) {
//        TransactionBlock[] pointer = lastBlocksList;
//        lastBlocksList = new TransactionBlock[pointer.length + 1];
//
//        for (int i = 0; i < pointer.length; i++) {
//          lastBlocksList[i] = pointer[i];
//        }
//        lastBlocksList[pointer.length] = newBlock;
//      }

    } else {
      lastBlocksList[locn] = newBlock;
    }

  }

  private String GetNonce(String a, String b) {
    CRF crfObj = new CRF(64);
    long i = 1000000000L;
    for (i = 1000000000L; i < 10000000000L; i++) {
      String non = String.valueOf(i);
      String crfComp = a.concat("#").concat(b).concat("#").concat(non);
      if (crfObj.Fn(crfComp).substring(0, 4).equals("0000")) {
        return non;
      }
    }
    return "";
  }
}