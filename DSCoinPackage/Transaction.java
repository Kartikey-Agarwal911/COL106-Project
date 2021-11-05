 package DSCoinPackage;

// import DSCoinPackage.TransactionBlock;
// import DSCoinPackage.Members;

public class Transaction {

  public String coinID;
  public Members Source;
  public Members Destination;
  public TransactionBlock coinsrc_block;

  public Transaction next;
  public Transaction prev;

  public Transaction(){}

  public Transaction(Transaction copy){

    if(copy!=null){
      this.coinID = copy.coinID;
      this.Source = copy.Source;
      this.Destination  = copy.Destination;
      this.coinsrc_block = copy.coinsrc_block;
      this.next = copy.next;
      this.prev = copy.prev;
    }


  }

@Override
public boolean equals(Object o){

  if(this == o){
    return true;
  }

  if (o == null){
    return false;
  }
      
  if (getClass() != o.getClass()){
    return false;
  }

  Transaction c = (Transaction) o;

  if(this.coinID.equals(c.coinID)){
    if(this.Source.UID.equals(c.Source.UID)){
      if(this.Destination.UID.equals(c.Destination.UID)){
        if(this.coinsrc_block == c.coinsrc_block){
          return true;
        }
      }
    }

  }


  return false;
}
}