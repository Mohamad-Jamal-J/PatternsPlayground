package singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
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
    public void testRunGame() throws Exception {
        String output = runner.run(mario);
        String expected = String.format(Messages.LAUNCHING, mario) + "\n" + String.format(Messages.RUN, mario);
        assertEquals(expected, output);
    }

    @Test
    public void testPauseGame() throws Exception {
        runner.run(mario);
        String expected = String.format(Messages.PAUSED, mario);
        String output = runner.pause();
        assertEquals(expected, output);
    }

    @Test
    public void testResumeGame() throws Exception {
        runner.run(mario);
        runner.pause();
        String expected = String.format(Messages.RUN, mario);
        String output = runner.resume();
        assertEquals(expected, output);
    }

    @Test
    public void testCloseGame() throws Exception {
        runner.run(mario);
        runner.pause();
        String output = runner.close();
        String expected = String.format(Messages.CLOSE_GAME, mario);
        assertEquals(expected, output);
    }

    @Test
    public void testLaunchingMultipleGames() throws Exception {
        runner.run(mario);
        String expected = String.format(Messages.PAUSED, mario) + "\n" +
                String.format(Messages.CLOSE_GAME, mario) + "\n" +
                String.format(Messages.LAUNCHING, callOfDuty) + "\n" +
                String.format(Messages.RUN, callOfDuty);
        String output = runner.run(callOfDuty);
        assertEquals(expected, output);
    }

    @Test
    public void testPauseAlreadyPausedGame() throws Exception {
        runner.run(mario);
        runner.pause();
        String expected = String.format(Messages.ALREADY_PAUSED, mario);
        String output = runner.pause();
        assertEquals(expected, output);
    }

    @Test
    public void testResumeAlreadyRunningGame() throws Exception {
        runner.run(mario);
        String expected = String.format(Messages.ALREADY_RUNNING, mario);
        String output = runner.resume();
        assertEquals(expected, output);
    }

    @Test
    public void testCloseGameWithoutPausing() throws Exception {
        runner.run(mario);
        String expected = String.format(Messages.PAUSED, mario) + "\n" +
                String.format(Messages.CLOSE_GAME, mario);
        String output = runner.close();
        assertEquals(expected, output);
    }

    @Test
    public void testNoGamesRunning() {
        String expected = Messages.NO_GAMES_RUNNING;

        Exception pause_exception = assertThrowsExactly(Exception.class, () -> runner.pause());
        assertEquals(pause_exception.getMessage(), expected);

        Exception resume_exception = assertThrowsExactly(Exception.class, () -> runner.resume());
        assertEquals(resume_exception.getMessage(), expected);

        Exception exception = assertThrowsExactly(Exception.class, () -> runner.close());
        assertEquals(exception.getMessage(), expected);
    }

    @Test
    public void testRunNullGame() throws Exception {
        runner.run(mario);
        String expected = String.format(Messages.NO_INTERRUPTION, mario);
        String output = runner.run(null);
        assertEquals(expected, output);
    }
}
