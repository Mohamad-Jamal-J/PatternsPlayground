# Patterns Playground (Java)

This Java repository demonstrates various design patterns applied to gaming console management. It contains three packages, each focusing on a different design pattern: Singleton, Singleton with State, and Factory.

## Motivation

The project simulates the behavior of gaming consoles that allow only one game to run at a time. By applying design patterns like Singleton, State, and Factory, we create a flexible game runner that can handle instance control, state transitions, and game creation.

## Packages

1. **Singleton Package**: Implements the Singleton pattern to ensure only one game runner instance is created.
2. **State Package**: Builds upon the Singleton package by adding the State pattern to manage game states such as running, paused, and no game.
3. **Factory Package**: Introduces the Factory design pattern to create different types of games (Disc-based and Cloud-based) without exposing the instantiation logic, allowing for better scalability and flexibility in managing game instances.

### Unit Testing
Testing methods were created for all packages to allow users to see how different actions are handled in different states.