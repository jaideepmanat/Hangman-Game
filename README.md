# Hangman Game

A fun and engaging Hangman game developed for Android using Java. Players guess letters to reveal the hidden word while trying to avoid running out of lives. The game is simple yet challenging and provides a great way to learn Android development basics.

## Features
- Random word selection from a predefined list of words.
- Track remaining lives and used letters.
- Interactive user interface with a clean and intuitive design.
- Play again functionality to restart the game.
- Visual and textual feedback for correct and incorrect guesses.

## How to Play
1. Launch the game.
2. Guess letters by entering them in the input field and pressing the **Submit** button.
3. Correct guesses will reveal the letter in the word. Incorrect guesses will reduce your lives.
4. The game ends when:
   - You guess the word correctly, or
   - You run out of lives.

## Code Files
### 1. `activity_main.xml`
Defines the layout for the main game interface. Includes:
- Word display (`TextView`)
- Lives count (`TextView`)
- Input field for guesses (`EditText`)
- Buttons for submitting guesses and restarting the game.
  
### 2. `AndroidManifest.xml`
Defines application metadata and the main activity:
- Launcher activity is set to `MainActivity`.
- Configured for API level 31.

### 3. `MainActivity.java`
Contains the game logic and functionality:
- Word selection from a predefined list.
- Guess validation (correct, incorrect, or previously used).
- Updates to the UI based on the player's actions.
- Game reset functionality.

## Word List
A wide variety of words from technical and non-technical domains, including:
- Programming languages: `JAVA`, `PYTHON`, `KOTLIN`
- Concepts: `ALGORITHM`, `VARIABLE`
- Technologies: `BLOCKCHAIN`, `CLOUD`
- And many more!

## Tech Stack
- **Programming Language**: Java
- **Android Components**: Activity, Layout, UI Widgets
- **Tools**: Android Studio, XML

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/jaideepmanat/Hangman-Game.git
