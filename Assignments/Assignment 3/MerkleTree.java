import Includes.*;
import java.util.*;


public class MerkleTree{
	
	// Check the TreeNode.java file for more details
	public TreeNode rootnode;
	public int numdocs;

	public String Build(String[] documents){
		numdocs = documents.length;
		Queue<TreeNode> TempList = new LinkedList<TreeNode>();
		CRF crf = new CRF(64);



		for (int i = 0; i < documents.length; i++) {
			TreeNode TempNode = new TreeNode();
			TempNode.val = documents[i];
			TempList.add(TempNode);
		}

		while (TempList.size() > 1){
			TreeNode TempNode = new TreeNode();
			TempNode.left = TempList.element();
			TempNode.left.parent = TempNode;
			TempList.poll();
			TempNode.right = TempList.element();
			TempNode.right.parent = TempNode;
			TempList.poll();
			TempNode.val = 	crf.Fn(TempNode.left.val + "#" + TempNode.right.val);
			TempList.add(TempNode);
		}
		rootnode = TempList.element();
		TempList.poll();


		return rootnode.val;
	}

	/* 
		Pair is a generic data structure defined in the Pair.java file
		It has two attributes - First and Second, that can be set either manually or
		using the constructor

		Edit: The constructor is added
	*/
		
	public List<Pair<String,String>> QueryDocument(int doc_idx){
		// Implement Code here

		List<Pair<String,String>> retString = new ArrayList<>();

		TreeNode iter = rootnode;
		retString.add(0,new Pair<String,String>(iter.val,null));
		int DocLocator = numdocs;
		while(DocLocator > 1){
			retString.add(0,new Pair<String,String>(iter.left.val,iter.right.val));
			DocLocator/=2;
			if(DocLocator<doc_idx){
				doc_idx-= DocLocator; 
				iter = iter.right;
			}else{
				iter = iter.left;
			}

		}
		
		return retString;
	}

	public static boolean Authenticate(List<Pair<String,String>> path, String summary){
		CRF crf = new CRF(64);
		
		for (int i = 0; i < path.size()-1; i++) {
			Pair<String,String> iter = path.get(i);
			Pair<String,String> verify = path.get(i+1);
			String secHash = crf.Fn(iter.First + "#" + iter.Second);
			if(!secHash.equals(verify.First) && !secHash.equals(verify.Second)){
				return false;
			}
		}
		Pair<String,String> fin = path.get(path.size()-1);
		if(!fin.First.equals(summary))
			return false;


		return true;
	}

	public String UpdateDocument(int doc_idx, String new_document){		
		// Implement Code here
		CRF crf = new CRF(64);


		TreeNode iter = rootnode;
		int DocLocator = numdocs;
		while(DocLocator > 1){
			DocLocator/=2;
			if(DocLocator<doc_idx){
				doc_idx-= DocLocator;
				iter = iter.right;
			}else{
				iter = iter.left;
			}
		}
		iter.val = new_document;
		while(iter.parent != null){
			iter = iter.parent;
			iter.val = crf.Fn(iter.left.val + "#" + iter.right.val);
		}


		return iter.val;
	}
}