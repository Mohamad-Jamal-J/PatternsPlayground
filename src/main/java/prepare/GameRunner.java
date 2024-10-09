package prepare;

public class GameRunner {
    private Game game;
    private boolean isPaused;
    private static GameRunner instance;
    private GameRunner(){
        System.out.println(Messages.FREE);
    }

    public static GameRunner getInstance(){
        if (instance==null)
            instance = new GameRunner();
        return instance;
    }

    private String setGame(Game game) {
        this.game = game;
        setPaused(true);
        return launch(game);
    }

    private void setPaused(boolean paused) {
        isPaused = paused;
    }

    private String launch(Game game) {
        if (game==null)
            return "";

        return String.format(Messages.LAUNCHING, game) + "\n" + resume();
    }

    public String run(Game game){
        if (this.game!=null && game==null)
            return String.format(Messages.NO_INTERRUPTION, this.game);

        if (this.game==null)
            return setGame(game);

        if (this.game.equals(game))
            return resume();
        return pause() + "\n" + close() + "\n" + setGame(game);
    }

    public String pause() {
        if (game == null)
            return Messages.NO_GAMES_RUNNING;

        if (isPaused)
            return String.format(Messages.ALREADY_PAUSED, game);

        setPaused(true);
        return String.format(Messages.PAUSED, game);
    }

    public String resume() {
        if (game == null)
            return Messages.NO_GAMES_RUNNING;

        if (!isPaused)
            return String.format(Messages.ALREADY_RUNNING, game);

        setPaused(false);
        return String.format(Messages.RUN, game);
    }

    public String close(){
        if (game==null)
            return Messages.NO_GAMES_RUNNING;

        return ((!isPaused)? pause()+"\n": "") + String.format(Messages.CLOSE_GAME, game) + setGame(null);
    }
    public void turnOff(){
        game = null;
        setPaused(true);
    }
}

