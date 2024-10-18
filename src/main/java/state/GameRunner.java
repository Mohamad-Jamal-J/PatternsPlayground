package state;

public class GameRunner {
    private Game game;
    private static GameRunner instance;
    private State runnerState;
    private GameRunner(){
        setState(new NoGame());
        System.out.println(Messages.FREE);
    }

    public static GameRunner getInstance(){
        if (instance==null)
            instance = new GameRunner();
        return instance;
    }

    public void setState(State state){ this.runnerState = state;}

    protected String setGame(Game game) throws Exception{
        if (game == null)
            throw new IllegalArgumentException(Messages.INVALID_GAME);

        this.game = game;
        setState(new Paused());
        return String.format(Messages.LAUNCHING, game) + "\n" + runnerState.resume(this);
    }

    public Game getGame(){return game;}

    public String run(Game game) throws Exception{
        if (game == null)
            throw new IllegalArgumentException(Messages.INVALID_GAME);
        return runnerState.run(this, game);
    }

    public String pause() throws Exception {
        return runnerState.pause(this);
    }

    public String resume() throws Exception {
        return runnerState.resume(this);
    }

    public String close() throws Exception {
        return runnerState.close(this);
    }
    protected void turnOff(){
        game = null;
        setState(new NoGame());
    }
}

