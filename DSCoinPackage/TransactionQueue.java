package DSCoinPackage;

// import DSCoinPackage.Transaction;
// import DSCoinPackage.EmptyQueueException;

public class TransactionQueue {

  public Transaction firstTransaction;
  public Transaction lastTransaction;
  public int numTransactions;

  public void AddTransactions (Transaction transaction) {
    if(numTransactions == 0){
        firstTransaction = transaction;
        lastTransaction = transaction;

    }else{
      lastTransaction.next = transaction;
      transaction.prev  = lastTransaction;
      lastTransaction = transaction;
    }

    numTransactions+=1;

  }
  
  public Transaction RemoveTransaction () throws EmptyQueueException {
    if(numTransactions == 0)
      throw new  EmptyQueueException();
    
    Transaction toRet;
    
    if(numTransactions == 1){
      toRet = firstTransaction;
      firstTransaction = null;
      lastTransaction = null;
    }else{
      toRet = firstTransaction;
      firstTransaction = firstTransaction.next;
      firstTransaction.prev = null;                                                           
    }

    numTransactions-=1;       
    return toRet;
  }

  public int size() {
    return numTransactions;
  }
}
