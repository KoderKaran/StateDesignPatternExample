public class SoldOutState implements State {
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine newGumballMachine) {
        gumballMachine = newGumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You have inserted a quarter even though the machine is sold out!");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("There is no quarter in the machine!");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there is no quarter!");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first, but the machine is sold out anyway!");
    }
}
