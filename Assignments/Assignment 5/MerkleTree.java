import Includes.*;
import java.util.*;

public class MerkleTree{

	// Check the TreeNode.java file for more details
	public TreeNode rootnode;
	public int numstudents;

	public String Build(List<Pair<String,Integer>> documents){
		numstudents = documents.size();
		CRF crf = new CRF(64);

		List<TreeNode> TempList = new LinkedList<TreeNode>();

		for (int i = 0; i < documents.size(); i++) {
			TreeNode TempNode = new TreeNode();
			Pair<String,Integer> fi = documents.get(i);
			TempNode.val = fi.get_first() + "_" + fi.get_second() ;
			TempNode.maxleafval = fi.get_second();
			TempNode.numberLeaves = 1;
			TempNode.isLeaf  = true;	
			TempList.add(TempNode);
		}

		while (TempList.size() > 1){
			TreeNode TempNode = new TreeNode();
			TempNode.left = TempList.get(0);
			TempNode.left.parent = TempNode;
			TempList.remove(0);
			TempNode.right = TempList.get(0);
			TempNode.right.parent = TempNode;
			TempList.remove(0);
			TempNode.val = 	crf.Fn(TempNode.left.val + "#" + TempNode.right.val);
			TempNode.isLeaf = false;
			TempNode.numberLeaves = TempNode.left.numberLeaves + TempNode.right.numberLeaves;
			TempNode.maxleafval = Math.max(TempNode.left.maxleafval, TempNode.right.maxleafval) ;
			TempList.add(TempNode);

		}

		rootnode = TempList.get(0);

		return rootnode.val;
	}

	/*
		Pair is a generic data structure defined in the Pair.java file
		It has two attributes - First and Second, that can be set either manually or
		using the constructor

		Edit: The constructor is added
	*/


	public String UpdateDocument(int student_id, int newScore){
		CRF crf = new CRF(64);


		TreeNode iter = rootnode;
		int DocLocator = numstudents;
		while(DocLocator > 1){
			DocLocator/=2;
			if(DocLocator <= student_id){
				student_id-= DocLocator;
				iter = iter.right;
			}else{
				iter = iter.left;
			}
		}
		String[] temp = iter.val.split("_");

		temp[temp.length-1] = "" +  newScore;


		iter.val = String.join("_", temp);
		iter.maxleafval = newScore;
		while(iter.parent != null){
			iter = iter.parent;
			iter.val = crf.Fn(iter.left.val + "#" + iter.right.val);
			iter.maxleafval = Math.max(iter.left.maxleafval,iter.right.maxleafval);
		}


		return rootnode.val;
	}
}
