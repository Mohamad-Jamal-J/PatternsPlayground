# Singleton Package (Java)

This package demonstrates the implementation of the **Singleton design pattern** for managing a single game runner instance.

## Motivation

Inspired by gaming consoles like PlayStation and Xbox, which allow only one game to run at a time, this package mirrors that functionality using the Singleton design pattern. It ensures only one instance of the `GameRunner` can be created.

## Key Features

- **Single Instance**: Guarantees only one `GameRunner` instance exists.
- **Game Control**: Provides basic methods to run, pause, and close a game.

## Unit Testing
Testing methods were created to allow users to see how different actions are handled in different states. Unit tests can be found [here](../../../test/java/singleton)

## Usage Example

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
```