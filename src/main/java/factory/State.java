package factory;

public interface State {
    String run(GameRunner context, Game game) throws Exception;
    String resume(GameRunner context) throws Exception;
    String pause(GameRunner context) throws Exception;
    String close(GameRunner context) throws Exception;
}
