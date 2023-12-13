import array.ActionCounter;

public class Main {
    public static void main(String[] args) {
        ActionCounter actionCounter = new ActionCounter();
        actionCounter.call(1);
        actionCounter.call(2);
        actionCounter.call(2);
//        System.out.println(actionCounter.getActions(4));
//        actionCounter.call(300);
//        actionCounter.call(301);
        System.out.println(actionCounter.getActions(301));
        System.out.println(actionCounter.getActions(302));
    }
}