package factory;

public class DiscBasedGame extends Game {

    public DiscBasedGame(String name) {
        super(name);
    }
    private void checkMemoryForData(){
        System.out.println(String.format(Messages.FOUND_IN_MEMORY, this));
    }
    public void loadProgress(){
        checkMemoryForData();
        System.out.println(String.format(Messages.PROGRESS_LOADED, this));
    }
}
