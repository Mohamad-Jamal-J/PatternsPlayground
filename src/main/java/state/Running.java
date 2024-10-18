package state;

public class Running implements State{
    @Override
    public String run(GameRunner context, Game game) throws Exception{
        if (context.getGame().equals(game))
            return String.format(Messages.ALREADY_RUNNING, context.getGame());

        return pause(context) + "\n" + close(context) + "\n" + context.setGame(game);
    }

    @Override
    public String resume(GameRunner context) throws Exception{
        return String.format(Messages.ALREADY_RUNNING, context.getGame());
    }

    @Override
    public String pause(GameRunner context) throws Exception{
        context.setState(new Paused());
        return String.format(Messages.PAUSED, context.getGame());
    }

    @Override
    public String close(GameRunner context) throws Exception{
        context.setState(new NoGame());
        return String.format(Messages.CLOSE_GAME, context.getGame());
    }
}
