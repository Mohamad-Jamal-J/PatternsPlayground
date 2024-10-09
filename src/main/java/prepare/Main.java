package prepare;
public class Main {
    private static final GameRunner runner = GameRunner.getInstance();
    private static final Game mario = new Game("Mario");
    private static final Game callOfDuty = new Game("Call of duty black ops");

    public static void main(String[] args) {
        System.out.println(runner.run(callOfDuty));
        System.out.println(runner.pause());
        System.out.println(runner.resume());
        System.out.println(runner.close());
        System.out.println(runner.run(mario));
    }
}