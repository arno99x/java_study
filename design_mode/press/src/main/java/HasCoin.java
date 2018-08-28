import java.util.Random;

public class HasCoin implements State{
  private CandyMachine candyMachine;
  public HasCoin(CandyMachine candyMachine){
    this.candyMachine = candyMachine;
  }
  @Override
  public void insertCoin() {
    System.out.println("you can't insert another coin!");
  }
  
  @Override
  public void returnCoin() {
    System.out.println("coin return!");
    candyMachine.setState(candyMachine.mOnReadyState);
  }
  
  @Override
  public void turnCrank() {
    System.out.println("crank turn...!");
    Random random = new Random();
    int winner = random.nextInt(10);
    if (winner == 0){
      candyMachine.setState(candyMachine.mWinnerState);
    }else {
      candyMachine.setState(candyMachine.mSoldOutState);
    }
  }
  
  @Override
  public void dispense() {
  }
  
  @Override
  public void printstate() {
    System.out.println("***OnHasCoin***");
  }
}
