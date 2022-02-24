import Includes.*;

import java.util.ArrayList;
import java.util.List;

public class BlockChain{
	// PLEASE USE YOUR ENTRY NUMBER AS THE START STRING
	public static final String start_string = "LabModule5";
	public Block firstBlock;
	public Block lastBlock;

	/*
		Note that the Exceptions have already been defined for you in the includes file,
		you just have to raise them accordingly

	*/

	public String InsertBlock(List<Pair<String,Integer>> Documents, int inputyear){
		MerkleTree mtree = new MerkleTree();
		mtree.Build(Documents);

		Block temp = new Block();
		temp.mtree = mtree;
		temp.year = inputyear;
		temp.value = mtree.rootnode.val+ "_" + mtree.rootnode.maxleafval;

		String initial;
		CRF crf = new CRF(64);

		if(firstBlock == null){
			firstBlock = temp;
			lastBlock = temp;
			initial = start_string;
		}else{
			initial = lastBlock.dgst;
			lastBlock.next = temp;
			temp.previous = lastBlock;
			lastBlock = temp;
			
		}

		lastBlock.dgst = crf.Fn(initial + "#" + lastBlock.value);

		return lastBlock.dgst;
	}

	public Pair<List<Pair<String,String>>, List<Pair<String,String>>> ProofofScore(int student_id, int year){
		
		Block iter = firstBlock;

		while(iter!= null && iter.year != year) {
			iter = iter.next;
		}

		MerkleTree mtree  = iter.mtree;

		TreeNode mTreeRootNode = mtree.rootnode;


		List<Pair<String,String>> AuthList = new ArrayList<Pair<String,String>>();

		TreeNode NodeIter = mTreeRootNode;
		AuthList.add(0,new Pair<String,String>(NodeIter.val,null));

		int DocLocator = mtree.numstudents;
		
		
		while(DocLocator > 1){
			AuthList.add(0,new Pair<String,String>(NodeIter.left.val,NodeIter.right.val));
			DocLocator/=2;
			if(DocLocator<=student_id){
				student_id-= DocLocator; 
				NodeIter = NodeIter.right;
			}else{
				NodeIter = NodeIter.left;
			}

		}

		List<Pair<String,String>> YearList = new ArrayList<Pair<String,String>>();

		while(iter!= null){
			Pair<String,String> TempYearPair = new Pair<String,String>();
			TempYearPair.First = iter.value; 
			TempYearPair.Second = iter.dgst; 
			YearList.add(TempYearPair);
			iter = iter.next;
		}

		Pair<List<Pair<String,String>>, List<Pair<String,String>>> returnPair = new Pair<List<Pair<String,String>>, List<Pair<String,String>>>();
		returnPair.First = AuthList;
		returnPair.Second = YearList;

		return returnPair;
	}
}
