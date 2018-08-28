public class MainTest {
  public static void main(String[] args){
    CandyMachine candyMachine = new CandyMachine(6);
    
    candyMachine.printState();
    candyMachine.insertCoin();
    candyMachine.printState();
    candyMachine.turnCrank();
    candyMachine.printState();
    candyMachine.insertCoin();
    candyMachine.printState();
    candyMachine.turnCrank();
    candyMachine.printState();
  }
}
