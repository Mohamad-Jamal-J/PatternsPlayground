# PatternPlay (Java)

This Java application helps manage a gaming console runner, allowing consoles to have only one runner component that manages single-game-at-a-time functionality. 
It is designed specifically to showcase the **Singleton design pattern**, ensuring only one instance of the game runner can exist at a time.

## Motivation

If you've ever played with gaming consoles like PlayStation or Xbox, you'll notice that they only allow one game to run at a time. To mirror this single-game constraint, the `GameRunner` class was designed to ensure only one game can be managed and run at any given moment. This approach prevents the complexity and difficulty of managing multiple game runners simultaneously, aligning with the design of real-life gaming consoles that also have only one game runner.

### GameRunner Class

The `GameRunner` class contains methods to run, pause, resume, and close games. Here are the key components of the `GameRunner` class:

- **Game Control Methods**
    - `public String run(Game game)`: Runs the given game and returns a message describing the game's status.
    - `public String pause()`: Pauses the current game and returns a message confirming the game has paused.
    - `public String resume()`: Resumes the current game and returns a message confirming the game is running.
    - `public String close()`: Closes the current game and returns a message confirming the game closure.

### Unit Testing

Testing methods were created to allow users to see how different actions are handled in different states.

### Code Sample

Here is an example of how to use the `GameRunner` and `Game` classes:

```java
public class Main {
    private static final Game mario = new Game("Mario");
    private static final Game callOfDuty = new Game("Call of duty black ops");

    public static void main(String[] args) {
        GameRunner runner = GameRunner.getInstance();
        System.out.println(runner.run(callOfDuty));
        System.out.println(runner.pause());
        System.out.println(runner.resume());
        System.out.println(runner.close());
        System.out.println(runner.run(mario));
    }
}
