import Includes.*;
import java.util.*;
import java.lang.Math;

public class MerkleTree{
	//check TreeNode.java for more details
	public TreeNode rootnode;
	public int numdocs;


	private TreeNode getPrev(String doc){
		TreeNode iter = rootnode;

		while(iter.isLeaf == false){
			if(iter.right.minleafval.compareTo(doc) > 0 ){
				iter = iter.left;
			}else{
				iter = iter.right;
			}
		}
		return iter;
	}



	public String InsertDocument(String document){
		//Implement your code here
		CRF crfobj = new CRF(64);

		if(numdocs == 0){
			rootnode = new TreeNode(document,null);
			numdocs = 1;
		}else if(numdocs == 1){

			String docLeft = TreeNode.getMin(document, rootnode);
			String docRight = TreeNode.getMax(document, rootnode);

			rootnode.left = new TreeNode(docLeft,rootnode);
			rootnode.right = new TreeNode(docRight,rootnode);

			rootnode.val = crfobj.Fn(docLeft + "#" + docRight);
			rootnode.isLeaf = false;
			rootnode.numberLeaves = 2;
			rootnode.maxleafval = docLeft;
			rootnode.minleafval = docRight;
			rootnode.balanceFactor = 0;
			numdocs =2;
			rootnode.heightFix();

		}else{
				numdocs += 1;
				TreeNode loc = getPrev(document);

				String docLeft = TreeNode.getMin(document, loc);
				String docRight = TreeNode.getMax(document, loc);

				loc.left = new TreeNode(docLeft,loc); 
				loc.right = new TreeNode(docRight,loc);

				loc.val = crfobj.Fn(docLeft + "#" + docRight);
				loc.isLeaf = false;
				loc.numberLeaves = 2;
				loc.maxleafval = docLeft;
				loc.minleafval = docRight;
				loc.balanceFactor = 0;

				TreeNode iter = loc;
				// TreeNode par = iter.parent;


				while(iter!= null){
					iter.heightFix();

					iter.val = crfobj.Fn(iter.left.val + "#" + iter.right.val);
					iter.isLeaf = false;
					iter.numberLeaves = iter.left.numberLeaves + iter.right.numberLeaves;
					iter.minleafval = TreeNode.getMin(iter.left,iter.right);
					iter.maxleafval = TreeNode.getMax(iter.left,iter.right);

					iter = iter.parent;
				}

				iter = loc.parent;

				while(iter!=null){
					if(iter.balanceFactor == 2 ){

						if(iter.left.balanceFactor == 1){
									if(iter == rootnode){
										iter = iter.SingleRightRotation();
										rootnode = iter;
									}else{
										iter = iter.SingleRightRotation();
									}

									
								}else{

									if(iter == rootnode){
										iter = iter.DoubleLeftRightRotation();
										rootnode = iter;
									}else{
										iter = iter.DoubleLeftRightRotation();
									}
									
								}
						break;
					}else if (iter.balanceFactor == -2){
						if(iter.right.balanceFactor == -1){
								if(iter == rootnode){
									iter = iter.SingleLeftRotation();
									rootnode = iter;
								}else{
									
									iter = iter.SingleLeftRotation();
								}
							}else{
								if(iter == rootnode){
									iter = iter.DoubleRightLeftRotation();
									rootnode = iter;
								}else{
									iter = iter.DoubleRightLeftRotation();
								}

								
							}
							break;
					}
					iter = iter.parent;
				}

				while(iter!= null){
					iter.heightFix();

					iter.val = crfobj.Fn(iter.left.val + "#" + iter.right.val);
					iter.isLeaf = false;
					iter.numberLeaves = iter.left.numberLeaves + iter.right.numberLeaves;
					iter.minleafval = TreeNode.getMin(iter.left,iter.right);
					iter.maxleafval = TreeNode.getMax(iter.left,iter.right);


					iter = iter.parent;
				}
			}


		return rootnode.val;
	}
	
	public String DeleteDocument(String document){
		//Implement your code here
		return "";
	}
}


