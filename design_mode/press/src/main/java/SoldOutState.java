public class SoldOutState implements State {
  private CandyMachine candyMachine;
  public SoldOutState(CandyMachine candyMachine){
    this.candyMachine = candyMachine;
  }
  @Override
  public void insertCoin() {
    System.out.println("you can't inserted a coin, the machine sold out ");
    candyMachine.setState(candyMachine.mHasCoin);
  }
  
  @Override
  public void returnCoin() {
    System.out.println("you can't return, you haven't inserted a coin yet!");
  }
  
  @Override
  public void turnCrank() {
    System.out.println("you truned, but you haven't inserted a coin!");
  }
  
  @Override
  public void dispense() {
  
  }
  
  @Override
  public void printstate() {
    System.out.println("***OnSoldOutState***");
  }
}
