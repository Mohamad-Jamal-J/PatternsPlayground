package singleton_and_state;

public class Paused implements State{
    @Override
    public String run(GameRunner context, Game game) throws Exception{
        return context.setGame(game);
    }

    @Override
    public String resume(GameRunner context) throws Exception{
        context.setState(new Running());
        return String.format(Messages.RUN, context.getGame());
    }

    @Override
    public String pause(GameRunner context) throws Exception{
        return String.format(Messages.ALREADY_PAUSED, context.getGame());
    }

    @Override
    public String close(GameRunner context) throws Exception{
        context.setState(new NoGame());
        return String.format(Messages.CLOSE_GAME, context.getGame());
    }
}
