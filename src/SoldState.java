public class SoldState implements State {
    private GumballMachine gumballMachine;

    public SoldState(GumballMachine newGumballMachine){
        gumballMachine = newGumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait you are already getting a gumball!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You cannot eject the quarter after turning the crank!");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning the crank twice won't get you more gumballs!");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.getCount() > 0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }else{
            System.out.println("We are now out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
