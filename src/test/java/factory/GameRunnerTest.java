package factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameRunnerTest {

    private GameRunner runner;
    private Game mario;
    private Game callOfDuty;

    @BeforeEach
    public void setUp() {
        runner = GameRunner.getInstance();
        mario = GameFactory.getGame("Mario", "DISC");
        callOfDuty = GameFactory.getGame("Call of Duty", "CLOUD");
    }

    @AfterEach
    public void cleanUp() {
        runner.turnOff();
    }

    @Test
    public void testFactoryUnknown() {
        assertThrowsExactly(IllegalArgumentException.class, () -> GameFactory.getGame("none", "none"));
    }

    @Test
    public void testFactoryDiscGame() {
        assertTrue(mario instanceof DiscBasedGame);
    }

    @Test
    public void testFactoryCloudGame() {
        assertTrue(callOfDuty instanceof CloudGame);
    }
}
