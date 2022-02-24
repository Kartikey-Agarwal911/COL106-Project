import Includes.*;

public class AuthStack{
	// PLEASE USE YOUR ENTRY NUMBER AS THE START STRING
	private static final String start_string = "2020CS10342";
	private StackNode top;

	/*
		Note that the Exceptions have already been defined for you in the includes file,
		you just have to raise them accordingly

	*/

	/* 
	Notice that this function is static, the reason why this is static is that we don't want this to be tied with
	an object of the class. 	
	*/
	public static boolean CheckStack(AuthStack current, String proof) throws AuthenticationFailedException{
		/*
			Implement Code here
		*/
		if(current.top == null)
			return true;

		CRF crf_obj = new CRF(64);
		StackNode iterator = current.top;

		if(!proof.equals(iterator.dgst))
			throw new AuthenticationFailedException();

		while(iterator.previous != null){
			if(!iterator.dgst.equals(crf_obj.Fn(iterator.previous.dgst + "#" + iterator.data.value)))
				throw new AuthenticationFailedException();
			iterator = iterator.previous;	
		}

		if(!iterator.dgst.equals(crf_obj.Fn(start_string + "#" + iterator.data.value)))
			throw new AuthenticationFailedException();

		return true;
	}

	public String push(Data datainsert, String proof)throws AuthenticationFailedException{
		/*
			Implement Code here
		*/

		if(!CheckStack(this, proof))
			throw new AuthenticationFailedException();

		CRF crf_obj = new CRF(64);
		StackNode newNode  = new StackNode();
		newNode.data = datainsert;
		newNode.previous = this.top;
		if (this.top != null){
			newNode.dgst = crf_obj.Fn(this.top.dgst + "#" + datainsert.value);
		}else{
			newNode.dgst = crf_obj.Fn(start_string + "#" + datainsert.value);
		}

		this.top = newNode;

		return this.top.dgst;
	}

	public String pop(String proof)throws AuthenticationFailedException, EmptyStackException{
		/*
			Implement Code here
		*/
		if(!CheckStack(this, proof))
			throw new AuthenticationFailedException();
		if(this.top == null)
			throw new EmptyStackException();

		this.top = this.top.previous;

		if(this.top == null){
			return null;
		}
		return this.top.dgst;
	}

	public StackNode GetTop(String proof)throws AuthenticationFailedException,EmptyStackException{
		/*
			Implement Code here
		*/
		if(!CheckStack(this, proof))
			throw new AuthenticationFailedException();
		if(this.top == null)
			throw new EmptyStackException();

		return this.top;
	}
}