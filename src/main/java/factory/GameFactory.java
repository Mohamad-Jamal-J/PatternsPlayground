package factory;

public abstract class GameFactory {
    public static Game getGame(String name, String type){
        if (type.equalsIgnoreCase("DISC"))
            return new DiscBasedGame(name);
        else if(type.equalsIgnoreCase("CLOUD"))
            return new CloudGame(name);

        throw new IllegalArgumentException(Messages.UNKNOWN_GAME); // or null
    }
}
