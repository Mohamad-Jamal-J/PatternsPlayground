# Factory Package (Java)

This package demonstrates the **Factory design pattern** in combination with Singleton and State patterns to manage different types of games (Disc-based and Cloud-based) in a gaming console simulator.

## Motivation

The goal of this package is to simulate gaming environments where different types of games (disc-based and cloud-based) are handled differently. By using the Factory pattern, we can create game instances without exposing the underlying logic of how they are created. This adds flexibility to the system by allowing different types of games to be added in the future.

## Key Features

- **Factory Design Pattern**: The `GameFactory` class is used to instantiate different types of games (`DiscBasedGame` and `CloudGame`) based on the provided type.
- **Game Management**: The `GameRunner` manages the lifecycle of the game and ensures only one game runs at a time, with state transitions like pause, resume, and close.
- **State Design Pattern**: Game states (`NoGame`, `Paused`, `Running`) are used to manage the current status of the game.

## Classes Overview

- **Game**: Abstract base class for all games.
- **DiscBasedGame**: Extends `Game` and simulates loading progress from disc-based storage.
- **CloudGame**: Extends `Game` and simulates loading progress from cloud-based storage.
- **GameFactory**: Responsible for creating `DiscBasedGame` or `CloudGame` based on the input type.
- **GameRunner**: Singleton class that manages the game’s state and enforces that only one game can run at a time.

## Unit Testing
Testing methods were created to allow users to test the factory behaviour. Unit tests can be found [here](../../../test/java/factory)

## Usage Example

```java
public class Main {
    private final static Game mario = GameFactory.getGame("Mario", "DISC");
    private final static Game callOfDuty = GameFactory.getGame("Call of Duty: Black Ops", "CLOUD");

    public static void main(String[] args) throws Exception  {
        GameRunner runner = GameRunner.getInstance();
        System.out.println(runner.run(callOfDuty));
        System.out.println(runner.run(mario));
    }
}
