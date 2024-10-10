package singleton_and_state;

public class Main {
    private static final Game mario = new Game("Mario");
    private static final Game callOfDuty = new Game("Call of duty black ops");

    public static void main(String[] args) throws Exception  {
        GameRunner runner = GameRunner.getInstance();
        System.out.println(runner.run(callOfDuty));
        System.out.println(runner.run(mario));
    }
}