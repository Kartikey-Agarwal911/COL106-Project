import Includes.*;
import java.util.*;
import java.lang.Math;

public class TreeNode{
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	public String val;
	public boolean isLeaf;
	public int numberLeaves;
	public String maxleafval;
	public String minleafval;
	public int balanceFactor;
	public int height;
	

	public TreeNode(){

	}

	public TreeNode(String doc,TreeNode par){
		parent = par;
		left = null;
		right = null;
		val = doc;
		isLeaf = true;
		numberLeaves = 1;
		minleafval = doc;
		maxleafval = doc;
		balanceFactor = 0;
		height = 0;
	}

	public static String getMin(TreeNode obj1,TreeNode obj2){
		if(obj1 == null){
			return obj2.minleafval;
		}else if(obj2 == null){
			return obj1.minleafval;
		}

		return obj1.minleafval.compareTo(obj2.minleafval) > 0 ? obj2.minleafval:obj1.minleafval;
	}

	public static String getMin(String obj1,TreeNode obj2){
		if(obj2 == null){
			return obj1;
		}
		return obj1.compareTo(obj2.val) > 0 ? obj2.val:obj1;
	}

	public static String getMax(TreeNode obj1,TreeNode obj2){
		if(obj1 == null){
			return obj2.maxleafval;
		}else if(obj2 == null){
			return obj1.maxleafval;
		}
		return obj1.maxleafval.compareTo(obj2.maxleafval) < 0 ? obj2.maxleafval:obj1.maxleafval;
	}
	public static String getMax(String obj1,TreeNode obj2){
		if(obj2 == null){
			return obj1;
		}
		return obj1.compareTo(obj2.val) < 0 ? obj2.val:obj1;
	}

	public TreeNode SingleLeftRotation(){
		//Implement your code here

		if (isLeaf){
			return this;
		}


		TreeNode x  = this;
		TreeNode z  = this.right;
		TreeNode y  = this.right.right;

		x.right = z.left;
		z.left = x;

		if(x.parent == null){
			
		}else if(x.parent.left == x){
			x.parent.left = z;
		}else{
			x.parent.right = z;
		}

		z.parent = x.parent;
		x.parent = z;

		if(x.right!=null){
			x.right.parent = x;
		}

		x.heightFix();
		z.heightFix();


		x.minleafval = getMin(x.left,x.right);
		z.minleafval =  getMin(z.left,z.right);

		x.maxleafval = getMax(x.left,x.right);
		z.maxleafval =  getMax(z.left,z.right);


		x.numberLeaves = x.left.numberLeaves + x.right.numberLeaves;
		z.numberLeaves = z.left.numberLeaves + z.right.numberLeaves;

		CRF crfobj = new CRF(64);

		x.val = crfobj.Fn(x.left.val + "#" + x.right.val);
		z.val = crfobj.Fn(z.left.val + "#" + z.right.val);

		return z;
	}
	
	public TreeNode SingleRightRotation(){
		//Implement your code here

		if (isLeaf){
			return this;
		}


		TreeNode x  = this;
		TreeNode z  = this.left;
		TreeNode y  = this.left.left;

		x.left = z.right;
		z.right = x;

		if(x.parent == null){
			
		}else if(x.parent.left == x){
			x.parent.left = z;
		}else{
			x.parent.right = z;
		}

		z.parent = x.parent;
		x.parent = z;

		if(x.left!=null){
			x.left.parent = x;
		}

		

		x.heightFix();
		z.heightFix();


		x.minleafval = getMin(x.left,x.right);
		z.minleafval =  getMin(z.left,z.right);

		x.maxleafval = getMax(x.left,x.right);
		z.maxleafval =  getMax(z.left,z.right);


		x.numberLeaves = x.left.numberLeaves + x.right.numberLeaves;
		z.numberLeaves = z.left.numberLeaves + z.right.numberLeaves;

		CRF crfobj = new CRF(64);

		x.val = crfobj.Fn(x.left.val + "#" + x.right.val);
		z.val = crfobj.Fn(z.left.val + "#" + z.right.val);

		return z;

	}
	
	public TreeNode DoubleLeftRightRotation(){



		//Implement your code here
		 if (isLeaf){
		 	return this;
		 }


		 TreeNode x  = this;
		 TreeNode y  = this.left;
		 TreeNode z  = this.left.right;

		 y.right = z.left;
		 x.left = z.right;
		 z.left = y;
		 z.right = x;

		 if(x.parent == null){
			
		 }else if( x.parent.left == x){
		 	x.parent.left = z;
		 }else{
		 	x.parent.right = z;
		 }

		 z.parent = x.parent;
		 x.parent = z;
		 y.parent = z;
		 if(y.right!=null){
		 	y.right.parent = y;
		 }
		 if(x.left!=null){
		 	x.left.parent = x;
		 }
		

		 x.heightFix();
		 y.heightFix();
		 z.heightFix();



		 x.minleafval = getMin(x.left,x.right);
		 y.minleafval = getMin(y.left,y.right);
		 z.minleafval =  getMin(z.left,z.right);

		 x.maxleafval = getMax(x.left,x.right);
		 y.maxleafval = getMax(y.left,y.right);
		 z.maxleafval =  getMax(z.left,z.right);


		 x.numberLeaves = x.left.numberLeaves + x.right.numberLeaves;
		 y.numberLeaves = y.left.numberLeaves + y.right.numberLeaves;
		 z.numberLeaves = z.left.numberLeaves + z.right.numberLeaves;

		 CRF crfobj = new CRF(64);

		 x.val = crfobj.Fn(x.left.val + "#" + x.right.val);
		 y.val = crfobj.Fn(y.left.val + "#" + y.right.val);
		 z.val = crfobj.Fn(z.left.val + "#" + z.right.val);

		 return z;
	}
	
	public TreeNode DoubleRightLeftRotation(){

//		return this.SingleLeftRotation().SingleRightRotation();
//
//		Implement your code here
//				Implement your code here
		 if (isLeaf){
		 	return this;
		 }


		 TreeNode x  = this;
		 TreeNode y  = this.right;
		 TreeNode z  = this.right.left;

		 y.left = z.right;
		 x.right = z.left;
		 z.right = y;
		 z.left = x;

		 if(x.parent == null){

		 }else if(x.parent.left == x){
		 	x.parent.left = z;
		 }else{
		 	x.parent.right = z;
		 }


		 z.parent = x.parent;
		 x.parent = z;
		 y.parent = z;

		 if(y.left!=null){
		 	y.left.parent = y;
		 }
		 if(x.right!=null){
		 	x.right.parent = x;
		 }


		 x.heightFix();
		 y.heightFix();
		 z.heightFix();



		 x.minleafval = getMin(x.left,x.right);
		 y.minleafval = getMin(y.left,y.right);
		 z.minleafval =  getMin(z.left,z.right);

		 x.maxleafval = getMax(x.left,x.right);
		 y.maxleafval = getMax(y.left,y.right);
		 z.maxleafval =  getMax(z.left,z.right);


		 x.numberLeaves = x.left.numberLeaves + x.right.numberLeaves;
		 y.numberLeaves = y.left.numberLeaves + y.right.numberLeaves;
		 z.numberLeaves = z.left.numberLeaves + z.right.numberLeaves;

		 CRF crfobj = new CRF(64);

		 x.val = crfobj.Fn(x.left.val + "#" + x.right.val);
		 y.val = crfobj.Fn(y.left.val + "#" + y.right.val);
		 z.val = crfobj.Fn(z.left.val + "#" + z.right.val);

		 return z;
	}


	@Override
	public boolean equals(Object obj) {
		TreeNode objT = (TreeNode) obj;

		if((obj == null) || (obj.getClass() != this.	getClass())) {
			return false;
		}
		if(obj == this){
			return true;
		}
		if(objT.val == this.val){
			return true;
		}

		
		return false;
	}
	
	
	public int compareTo(Object obj) {
		TreeNode objT = (TreeNode) obj;

		return objT.val.compareTo( this.val);
	}

	public void heightFix(){
		if(this.left == null && this.right != null){
			height = this.right.height+1;
			balanceFactor = -this.right.height;
		}else if(this.right == null && this.left != null){
			height = this.left.height+1;
			balanceFactor = this.left.height;

		}else if(this.right == null && this.left == null){
			height = 0;
			balanceFactor = 0;

		}else{
			height = 1 + Math.max(this.left.height, this.right.height);
			balanceFactor = this.left.height - this.right.height;
		
		}
	}


}

