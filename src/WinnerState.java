public class WinnerState implements State {
    private GumballMachine gumballMachine;

    public WinnerState(GumballMachine newGumballMachine){
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
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            System.out.println("CONGRATS! You're a winner and get two gumballs instead of two!");
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                gumballMachine.setState(gumballMachine.getSoldOutState());

            }
        }
    }
}
