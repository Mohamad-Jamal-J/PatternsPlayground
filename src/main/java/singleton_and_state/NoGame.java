package singleton_and_state;

public class NoGame implements State{
    @Override
    public String run(GameRunner context, Game game) throws Exception {
        return context.setGame(game);
    }

    @Override
    public String resume(GameRunner context) throws Exception {
        throw new Exception(Messages.NO_GAMES_RUNNING);
    }

    @Override
    public String pause(GameRunner context) throws Exception {
        throw new Exception(Messages.NO_GAMES_RUNNING);
    }

    @Override
    public String close(GameRunner context) throws Exception {
        throw new Exception(Messages.NO_GAMES_RUNNING);
    }
}
