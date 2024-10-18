package factory;

public class Main {
    private final static Game mario = GameFactory.getGame("Mario", "DISC");
    private final static Game callOfDuty = GameFactory.getGame("Call of duty black ops", "CLOUD");

    public static void main(String[] args) throws Exception  {
        GameRunner runner = GameRunner.getInstance();
        System.out.println(runner.run(callOfDuty));
        System.out.println(runner.run(mario));
    }
}