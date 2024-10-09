package prepare;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameRunnerTest {
    private GameRunner runner;
    private Game mario;
    private Game callOfDuty;

    @BeforeEach
    public void setUp() {
        runner = GameRunner.getInstance();
        mario = new Game("Mario");
        callOfDuty = new Game("Call of Duty");
    }
    @AfterEach
    public void cleanUp(){
        runner.turnOff();
    }

    @Test
    public void testSingleton() {
        assertEquals(runner, GameRunner.getInstance());
    }

    @Test
    public void testRunGame() {
        String output = runner.run(mario);
        String expected = String.format(Messages.LAUNCHING, mario) + "\n" + String.format(Messages.RUN, mario);
        assertEquals(expected, output);
    }

    @Test
    public void testPauseGame() {
        runner.run(mario);
        String expected = String.format(Messages.PAUSED, mario);
        String output = runner.pause();
        assertEquals(expected, output);
    }

    @Test
    public void testResumeGame() {
        runner.run(mario);
        runner.pause();
        String expected = String.format(Messages.RUN, mario);
        String output = runner.resume();
        assertEquals(expected, output);
    }

    @Test
    public void testCloseGame() {
        runner.run(mario);
        runner.pause();
        String expected = String.format(Messages.CLOSE_GAME, mario);
        String output = runner.close();
        assertEquals(expected, output);
    }

    @Test
    public void testLaunchingMultipleGames() {
        runner.run(mario);
        String expected = String.format(Messages.PAUSED, mario) + "\n" +
                String.format(Messages.CLOSE_GAME, mario) + "\n" +
                String.format(Messages.LAUNCHING, callOfDuty) + "\n" +
                String.format(Messages.RUN, callOfDuty);
        String output = runner.run(callOfDuty);
        assertEquals(expected, output);
    }

    @Test
    public void testPauseAlreadyPausedGame() {
        runner.run(mario);
        runner.pause();
        String expected = String.format(Messages.ALREADY_PAUSED, mario);
        String output = runner.pause();
        assertEquals(expected, output);
    }

    @Test
    public void testResumeAlreadyRunningGame() {
        runner.run(mario);
        String expected = String.format(Messages.ALREADY_RUNNING, mario);
        String output = runner.resume();
        assertEquals(expected, output);
    }

    @Test
    public void testCloseGameWithoutPausing() {
        runner.run(mario);
        String expected = String.format(Messages.PAUSED, mario) + "\n" +
                String.format(Messages.CLOSE_GAME, mario);
        String output = runner.close();
        assertEquals(expected, output);
    }

    @Test
    public void testNoGamesRunning() {
        String expected = Messages.NO_GAMES_RUNNING;
        String output = runner.pause();
        assertEquals(expected, output);

        output = runner.resume();
        assertEquals(expected, output);

        output = runner.close();
        assertEquals(expected, output);
    }

    @Test
    public void testRunNullGame() {
        runner.run(mario);
        String expected = String.format(Messages.NO_INTERRUPTION, mario);
        String output = runner.run(null);
        assertEquals(expected, output);
    }
}
