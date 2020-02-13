public class NoQuarterState implements State {
    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine newGumballMachine) {
        gumballMachine = newGumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You have inserted a quarter!");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter!");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there is no quarter!");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first!");
    }
}
