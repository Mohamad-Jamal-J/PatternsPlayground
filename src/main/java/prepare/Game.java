package prepare;

public class Game implements Comparable<Game> {
    private String name;
    public Game(String name){
        setName(name);
    }
    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Game o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
