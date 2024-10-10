package singleton;

public class Messages {
    public static final String RUN = "'%s' is running.";
    public static final String PAUSED = "'%s' got paused.";
    public static final String LAUNCHING = "Launching '%s'...";
    public static final String ALREADY_PAUSED = "'%s' is already in pause mode.";
    public static final String ALREADY_RUNNING = "'%s' is already in running mode.";
    public final static String NO_GAMES_RUNNING = "No games are currently running.";
    public final static String FREE = "The runner is free and ready to run any game";
    public final static String CLOSE_GAME = "Closing '%s'...\ngame got closed.\n" + FREE;
    public static final String NO_INTERRUPTION = "The game you tried to run is damaged or have missing" +
            " information.\n'%s' continues to run without interruption.";
}
