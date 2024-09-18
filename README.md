# Completed Coding Challenge

Implemented MVC of the RPG Game

## Implementation details and setup

Due to time constraints, some aspects of the system were streamlined or simplified.

Instead of a database, the system uses a file to save game progress, which supports saving only one game at a time.

While certain parts of the system could benefit from further improvement and testing, the MVP effectively meets the given requirements and delivers a solid playable experience.

The project is designed with configurability in mind, allowing you to create the game levels, adjust balance and game complexity. It also supports adding new classes and monsters.

### Running the app
1. Check java version:

```
java -version
OpenJDK Runtime Environment (build 22.0.2+9-70)
OpenJDK 64-Bit Server VM (build 22.0.2+9-70, mixed mode, sharing)
```
2. For an optimal experience, adjust the size of the terminal to handle at least 5 game segments:
```
 __________________________ __________________________ __________________________ __________________________ __________________________
|     -_-                 ||     -_-                 ||     -_-                 ||                          ||     -_-                 |
|                         ||                         ||                         ||         .--.             ||                         |
|                         ||                         ||                         ||        /.--.\            ||                         |
|                         ||                         ||                         ||        |====|            ||                         |
|      .-'````````'.      ||      .-'````````'.      ||      .-'````````'.      ||        |`::`|            ||      .-'````````'.      |
|    .` |           `.    ||    .` |           `.    ||    .` |           `.    ||    .-;`\..../`;_.-^-._.  ||    .` |           `.    |
|   /   |   ()        \   ||   /   |   ()        \   ||   /   |   ()        \   ||   /  |...::..|`   :   `| ||   /   |   ()        \   |
|   |   |     ;        |  ||   |   |     ;        |  ||   |   |     ;        |  ||  |   /'''::''|   .:.   | ||   |   |     ;        |  |
|   |   |     ;        |  ||   |   |     ;        |  ||   |   |     ;        |  ||  ;--'\   ::  |..:::::..| ||   |   |     ;        |  |
|   |   |     ;        |  ||   |   |     ;        |  ||   |   |     ;        |  ||  <__> >._::_.| ':::::' | ||   |   |     ;        |  |
|   |   |____;_________|  ||   |   |____;_________|  ||   |   |____;_________|  ||  |  |/   ^^  |   ':'   | ||   |   |____;_________|  |
|   |  /  __ ;   -     |  ||   |  /  __ ;   -     |  ||   |  /  __ ;   -     |  ||  \::/|       \    :    / ||   |  /  __ ;   -     |  |
|   | / __  ()         |  ||   | / __  ()         |  ||   | / __  ()         |  ||  |||\|        \   :   /  ||   | / __  ()         |  |
|   |/        __-- _   |  ||   |/        __-- _   |  ||   |/        __-- _   |  ||  ''' |___/\___|`-.:.-`   ||   |/        __-- _   |  |
|___|__________________|__||___|__________________|__||___|__________________|__||__________________________||___|__________________|__|
```
3. Run the game:


```
./gradlew build
java -jar build/libs/dungeon_quest-1.0-SNAPSHOT.jar
```

4. Close the game `Ctrl C`
