# State Package (Java)

This package builds upon the Singleton pattern by incorporating the **State design pattern** to better manage the various states of a game.

## Motivation

While gaming consoles ensure only one game runs at a time, games also transition through different states (e.g., running, paused, no game). This package introduces a more advanced game runner using the State design pattern to handle these states.

## Key Features

- **Single Instance**: Still ensures only one `GameRunner` instance.
- **State Management**: Handles three states—NoGame, Paused, and Running—to effectively manage the game lifecycle.
- **Game Control**: Provides methods to run, pause, resume, and close games.

## Unit Testing
Testing methods were created to allow users to see how different actions are handled in different states. Unit tests can be found [here](../../../test/java/state)


## Usage Example

```java
public class Main {
    private static final Game mario = new Game("Mario");
    private static final Game callOfDuty = new Game("Call of Duty: Black Ops");

    public static void main(String[] args) {
        GameRunner runner = GameRunner.getInstance();
        System.out.println(runner.run(callOfDuty));
        System.out.println(runner.pause());
        System.out.println(runner.resume());
        System.out.println(runner.close());
        System.out.println(runner.run(mario));
    }
}
```