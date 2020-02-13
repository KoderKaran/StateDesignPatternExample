import java.util.Random;
public class HasQuarterState implements State {
    private GumballMachine gumballMachine;
    private Random rnd;

    public HasQuarterState(GumballMachine newGumballMachine){
        gumballMachine = newGumballMachine;
        rnd = new Random(System.currentTimeMillis());
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter has been returned!");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned the crank!");
        int winner = rnd.nextInt(10);
        if(winner == 0 && (gumballMachine.getCount() > 1)){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else{
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("You need to turn the crank to dispense gumballs!");
    }
}
