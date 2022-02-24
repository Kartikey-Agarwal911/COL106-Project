import DSCoinPackage.*;
import HelperClasses.*;
import java.util.*;
public class DriverCode {

    public static void main(String args[]) {

        try {
            DSCoin_Malicious obj_mm = new DSCoin_Malicious();
            Moderator mod_mm = new Moderator();
            obj_mm.pendingTransactions = new TransactionQueue();
            obj_mm.bChain = new BlockChain_Malicious();
            obj_mm.bChain.lastBlocksList = new TransactionBlock[100];
            Boolean correct_mm = true;
            obj_mm.memberlist = new Members[10];
            for (int i = 0; i < 10; i ++){
            obj_mm.memberlist[i] = new Members();
            obj_mm.memberlist[i].UID = "Member " + Integer.toString(i);
            obj_mm.memberlist[i].mycoins = new ArrayList<Pair<String,TransactionBlock>>();
            obj_mm.memberlist[i].in_process_trans = new Transaction[100];
        }
        obj_mm.bChain.tr_count = 32;
        mod_mm.initializeDSCoin(obj_mm,128);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[4].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[9].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[9].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[4].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[2].MineCoin(obj_mm);
                    finalise(obj_mm, obj_mm.bChain.lastBlocksList[0]);
                        Transaction tr[] = new Transaction[32];
                        
                        Transaction tobj_mm = new Transaction();
                        tobj_mm.coinID = "100002";
                    tobj_mm.Source = obj_mm.memberlist[2];
                    tobj_mm.Destination = obj_mm.memberlist[7];
                    tobj_mm.coinsrc_block = obj_mm.bChain.lastBlocksList[0].previous.previous.previous.previous;
                    tr[0] = tobj_mm;
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[4].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[9].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[9].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[4].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    for(int i=1;i<32;i++){
                        tr[i] = obj_mm.pendingTransactions.RemoveTransaction();
                    }
                    TransactionBlock tB = new TransactionBlock(tr);
                    tB.previous = obj_mm.bChain.lastBlocksList[0];
                    obj_mm.bChain.InsertBlock_Malicious(tB);
                    returncoins(obj_mm,tB);
                        
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    Transaction t = obj_mm.pendingTransactions.RemoveTransaction();
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[4].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[4].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[9].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[8].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[8].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[9].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[7].MineCoin(obj_mm);
                    finalise(obj_mm, obj_mm.bChain.lastBlocksList[1]);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[8].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[4].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[4].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[9].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[9].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[6].MineCoin(obj_mm);
                    finalise(obj_mm, obj_mm.bChain.lastBlocksList[1]);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[9].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[0].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[7].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[4].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[8].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[4].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[8].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[2].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[6].initiateCoinsend(obj_mm.memberlist[9].UID,obj_mm);
                    obj_mm.memberlist[0].initiateCoinsend(obj_mm.memberlist[8].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[5].UID,obj_mm);
                    obj_mm.memberlist[2].initiateCoinsend(obj_mm.memberlist[1].UID,obj_mm);
                    obj_mm.memberlist[1].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[3].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[5].initiateCoinsend(obj_mm.memberlist[0]. UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[3].UID,obj_mm);
                    obj_mm.memberlist[7].initiateCoinsend(obj_mm.memberlist[6].UID,obj_mm);
                    obj_mm.memberlist[0].MineCoin(obj_mm);
                    finalise(obj_mm, obj_mm.bChain.lastBlocksList[1]);
                    for (int i = 0 ; i<10;i++){
                        System.out.println(printMember(obj_mm.memberlist[i]));
                    }
                    System.out.println(obj_mm.bChain.lastBlocksList[0].dgst);

                    System.out.println("----------- Mr.X -----------");
        } catch (Exception e) {
           e.printStackTrace();
        }


    }

    public static void finalise(DSCoin_Malicious DSObj,TransactionBlock tB){
        for(int j = 0; j<tB.trarray.length; j++) {
            Transaction tobj_mm = tB.trarray[j];
            for(int i = 0; i < DSObj.memberlist.length; i++){
                if(DSObj.memberlist[i].UID == tobj_mm.Destination.UID){
                    DSObj.memberlist[i].mycoins.add(new Pair<String,TransactionBlock>(tobj_mm.coinID, tB));
                    DSObj.memberlist[i].mycoins.sort(new Comparator<Pair<String,TransactionBlock>>() {
                        @Override public int compare(Pair<String,TransactionBlock> p1, Pair<String,TransactionBlock> p2) {
                            if(Integer.parseInt(p1.get_first()) > Integer.parseInt(p2.get_first())) {
                                return 1;
                            }
                            else{
                                return -1;
                            }
                        }
                    });
                    break;
                }
            }
        }        
     }

    public static void returncoins(DSCoin_Malicious DSObj, TransactionBlock tB){
        for(int j = 1; j<tB.trarray.length; j++) {
            Transaction tobj_mm = tB.trarray[j];
            for(int i = 0; i < DSObj.memberlist.length; i++){
                if(DSObj.memberlist[i].UID == tobj_mm.Source.UID){
                    DSObj.memberlist[i].mycoins.add(new Pair<String,TransactionBlock>(tobj_mm.coinID, tobj_mm.coinsrc_block));
                    DSObj.memberlist[i].mycoins.sort(new Comparator<Pair<String,TransactionBlock>>() {
                        @Override public int compare(Pair<String,TransactionBlock> p1, Pair<String,TransactionBlock> p2) {
                            if(Integer.parseInt(p1.get_first()) > Integer.parseInt(p2.get_first())) {
                                return 1;
                            }
                            else{
                                return -1;
                            }
                        }
                    });
                    break;
                }
            }
        }
    }

    
    public static DSCoin_Honest createObj (int numOfMembers, int trcount){
        DSCoin_Honest obj_7 = new DSCoin_Honest();
        obj_7.pendingTransactions = new TransactionQueue();
        obj_7.memberlist = new Members[numOfMembers];
        for (int i = 0; i < numOfMembers; i ++){
            obj_7.memberlist[i] = new Members();
            obj_7.memberlist[i].UID = Integer.toString(i+101);
            obj_7.memberlist[i].mycoins = new ArrayList<Pair<String,TransactionBlock>>();
        }
        obj_7.bChain = new BlockChain_Honest();
        obj_7.bChain.tr_count = trcount;
        return obj_7;
    }
    
    public static String printMember (Members m){
    	String s = "Member Name : ";
    	s += m.UID + "\n Member Coins \n";
    	for (Pair<String, TransactionBlock> p : m.mycoins){
    	    s += p.first + " ";
    	}
	s += "\n";
    	return s;
    }
    public static String printBlock (TransactionBlock b){
	String s = "Block Summary: ";
	s += b.trsummary + "\n Nonce ";
	if (b.nonce != null){
	    s += b.nonce + " \n dgst ";
	}
	else {
	    s += "null \n dgst ";
	}
	if (b.dgst != null){
	    s += b.dgst + "\n";
	}
	else {
	    s += "null \n";
	}
	return s;
    }
    public static String printBlockChain (BlockChain_Honest c){
	String s = "Block Chain Honest \n ";
	TransactionBlock b = c.lastBlock;
	for (; b != null; b = b.previous){
	    s += printBlock(b) + "\n";
	}
	return s;
    }
    public static String printBlockChain (BlockChain_Malicious c){
	String s = "Block Chain Malicious \n";
	List<TransactionBlock> l = new ArrayList<>();
	for (int i = 0; i < c.lastBlocksList.length; i ++){
	    if (c.lastBlocksList[i] != null){
		l.add(c.lastBlocksList[i]);
	    }
	}
	for (int i = 1; i < l.size(); i ++){
	    for (int j = i; j > 0 && l.get(j).trsummary.compareTo(l.get(j-1).trsummary) <= 0; j --){
		TransactionBlock temp = l.get(j);
		l.set(j, l.get(j-1));
		l.set(j-1, temp);
	    }
	}
	for (int i = 0; i < l.size(); i ++){
	    for (TransactionBlock b = l.get(i); b != null; b = b.previous){
		s += printBlock(b) + "\n";
	    }
	}
	return s;
    }
    public static String printDSObj (DSCoin_Honest o){
	String s = "Honest Obj latest coin : ";
	s += o.latestCoinID + " \n Block Chain : \n";
	s += printBlockChain(o.bChain) + "memberlist \n";
	for (int i = 0; i < o.memberlist.length; i ++){
	    s += printMember(o.memberlist[i]);
	}
	return s;
    }
    public static String printDSObj (DSCoin_Malicious o){
	String s = "Malicious Obj latest coin : ";
	s += o.latestCoinID + " \n Block Chain : \n";
	s += printBlockChain(o.bChain) + "memberlist \n";
	for (int i = 0; i < o.memberlist.length; i ++){
	    s += printMember(o.memberlist[i]);
	}
	return s;
    }

    public static String printLists (Pair<List<Pair<String, String>>, List<Pair<String, String>>> lists){
        String s = "Lists: \n";
        for (int i = 0; i < lists.first.size(); i ++){
            s += lists.first.get(i).first +  lists.first.get(i).second;
        }
        for (int i = 0; i < lists.second.size(); i ++){
            s += lists.second.get(i).first +  lists.second.get(i).second;
        }
        return s;
        }
    
        public static DSCoin_Honest makeHonestObj (int memnum, int trcount){
        DSCoin_Honest obj = new DSCoin_Honest();
        obj.pendingTransactions = new TransactionQueue();
        obj.memberlist = new Members[memnum];
        for (int i = 0; i < memnum; i ++){
            obj.memberlist[i] = new Members();
            obj.memberlist[i].UID = "Member " + Integer.toString(i);
            obj.memberlist[i].in_process_trans = new Transaction[100];
            obj.memberlist[i].mycoins = new ArrayList<>();

        }
        obj.bChain = new BlockChain_Honest();
        obj.bChain.tr_count = trcount;
        return obj;
        }
}



