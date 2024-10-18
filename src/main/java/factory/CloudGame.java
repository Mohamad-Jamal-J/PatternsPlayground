package factory;

public class CloudGame extends Game {
    public CloudGame(String name) {
        super(name);
    }
    private void connectWithServer(){
        System.out.println(String.format(Messages.FOUND_IN_MEMORY, this));
    }
    public void loadProgress(){
        connectWithServer();
        System.out.println(String.format(Messages.PROGRESS_LOADED, this));
    }
}
