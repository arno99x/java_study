public class OnReadyState implements State {
  private CandyMachine candyMachine;
  public OnReadyState(CandyMachine candyMachine){
    this.candyMachine = candyMachine;
  }
  @Override
  public void insertCoin() {
    System.out.println("you have inserted a coin, next, please turn crank!");
    candyMachine.setState(candyMachine.mHasCoin);
  }
  
  @Override
  public void returnCoin() {
    System.out.println("you haven't inserted a coin yet!");
  }
  
  @Override
  public void turnCrank() {
    System.out.println("you yruned, but you haven't inserted a coin!");
  }
  
  @Override
  public void dispense() {
  }
  
  @Override
  public void printstate() {
    System.out.println("***OnReadyState***");
  }
}
