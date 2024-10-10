# PatternsPlayground (Java)

This Java repository contains two applications related to gaming console management. The first application showcases the **Singleton design pattern** to manage a single game runner, while the second application extends this concept by incorporating the **State design pattern** for enhanced game state management.

## Motivation

Gaming consoles like PlayStation and Xbox allow only one game to run at a time. This repository aims to mirror that functionality by implementing two versions of a game runner: one that focuses solely on ensuring a single instance of the runner and another that incorporates state management to handle the different states a game can be in.

## Applications

### 1. Singleton Package

This application demonstrates the basic Singleton design pattern. It ensures that only one instance of the game runner can exist at any time.

- **Key Features**:
  - **Single Instance**: Ensures only one `GameRunner` instance exists.
  - **Game Control**: Basic methods to run, pause, and close a game.

### 2. Singleton and State Package

This application builds on the Singleton concept by incorporating the State design pattern. It allows for better management of the game's various states: running, paused, and no game.

- **Key Features**:
  - **Single Instance**: Maintains a single instance of `GameRunner`.
  - **State Management**: Uses three states (NoGame, Paused, Running) to manage the game's lifecycle effectively.
  - **Game Control**: Provides methods to run, pause, resume, and close games.

### Unit Testing
Testing methods were created to allow users to see how different actions are handled in different states.

### Code Sample for Singleton and State Package

Here is an example of how to use the `GameRunner` and `Game` classes in the Singleton and State package:

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
