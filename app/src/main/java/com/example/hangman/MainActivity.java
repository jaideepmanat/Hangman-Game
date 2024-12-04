package com.example.hangman;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView wordTextView, livesTextView, usedLettersTextView, messageTextView;
    private EditText guessEditText;
    private Button submitButton, playAgainButton;

    private List<String> wordList = Arrays.asList(
            "ANDROID", "JAVA", "KOTLIN", "DEVELOPER", "MOBILE",
            "PYTHON", "PROGRAMMER", "DEBUGGING", "VARIABLE", "FUNCTION",
            "OBJECT", "CLASS", "STRING", "BOOLEAN", "ALGORITHM",
            "SOFTWARE", "HARDWARE", "COMPUTER", "DATABASE", "NETWORK",
            "SECURITY", "ENCRYPTION", "HACKER", "PASSWORD", "CLOUD",
            "DESKTOP", "LAPTOP", "SMARTPHONE", "TABLET", "APPLICATION",
            "SERVER", "CLIENT", "BROWSER", "INTERNET", "PROTOCOL",
            "HTML", "CSS", "JAVASCRIPT", "PHP", "SQL",
            "NODEJS", "REACT", "ANGULAR", "VUE", "GITHUB",
            "TERMINAL", "COMMAND", "BASH", "SCRIPT", "FRAMEWORK",
            "LIBRARY", "DEBUGGER", "EXECUTION", "THREAD", "PROCESS",
            "OPERATING", "SYSTEM", "WINDOWS", "LINUX", "MACOS",
            "ANDROIDSTUDIO", "XCODE", "INTELLIJ", "ECLIPSE", "VISUALSTUDIO",
            "FIREBASE", "AWS", "AZURE", "DOCKER", "KUBERNETES",
            "BLOCKCHAIN", "BITCOIN", "ETHEREUM", "SMARTCONTRACT", "TOKEN",
            "ARTIFICIAL", "INTELLIGENCE", "MACHINELEARNING", "DEEPLEARNING", "ALGORITHM",
            "NEURALNETWORK", "CLASSIFICATION", "PREDICTION", "REGRESSION", "CLUSTERING",
            "CYBERSECURITY", "MALWARE", "PHISHING", "VIRUS", "FIREWALL",
            "ANTIVIRUS", "BACKUP", "RESTORE", "RECOVERY", "BREACH",
            "AUTHENTICATION", "VERIFICATION", "BIOMETRICS", "ENCRYPT", "DECRYPT",
            "ROBOTICS", "AUTOMATION", "SIMULATION", "VIRTUALREALITY", "AUGMENTEDREALITY",
            "DIGITAL", "SIGNATURE", "HASH", "ALGORITHM", "CERTIFICATE",
            "DATA", "ANALYTICS", "VISUALIZATION", "STATISTICS", "INSIGHTS"
    );

    private String wordToGuess;
    private StringBuilder displayWord;
    private int lives;
    private List<Character> usedLetters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordTextView = findViewById(R.id.wordTextView);
        livesTextView = findViewById(R.id.livesTextView);
        usedLettersTextView = findViewById(R.id.usedLettersTextView);
        messageTextView = findViewById(R.id.messageTextView);
        guessEditText = findViewById(R.id.guessEditText);
        submitButton = findViewById(R.id.submitButton);
        playAgainButton = findViewById(R.id.playAgainButton);

        setupGame();

        submitButton.setOnClickListener(v -> checkGuess());
        playAgainButton.setOnClickListener(v -> setupGame());
    }

    private void setupGame() {
        lives = 6;
        usedLetters = new ArrayList<>();
        Random random = new Random();
        wordToGuess = wordList.get(random.nextInt(wordList.size()));

        displayWord = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            displayWord.append("_");
        }

        updateDisplayedWord();
        livesTextView.setText("Lives: " + lives);
        usedLettersTextView.setText("Used Letters: ");
        messageTextView.setText("");
        guessEditText.setText("");
        submitButton.setEnabled(true);
    }

    private void checkGuess() {
        String guess = guessEditText.getText().toString().toUpperCase();
        if (guess.length() != 1) {
            messageTextView.setText("Please enter a single letter.");
            return;
        }
        char guessedLetter = guess.charAt(0);
        if (usedLetters.contains(guessedLetter)) {
            messageTextView.setText("Letter already used. Try another one.");
            return;
        }
        usedLetters.add(guessedLetter);
        usedLettersTextView.setText("Used Letters: " + usedLetters.toString());

        if (wordToGuess.contains(guess)) {
            messageTextView.setText("Correct guess!");
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    displayWord.setCharAt(i, guessedLetter);
                }
            }
            updateDisplayedWord();

            if (!displayWord.toString().contains("_")) {
                messageTextView.setText("Congratulations! You won!");
                submitButton.setEnabled(false);
            }
        } else {
            lives--;
            livesTextView.setText("Lives: " + lives);
            messageTextView.setText("Incorrect guess. Try again.");
            if (lives == 0) {
                messageTextView.setText("Game over! The word was " + wordToGuess);
                submitButton.setEnabled(false);
            }
        }
        guessEditText.setText("");
    }

    private void updateDisplayedWord() {
        StringBuilder formattedDisplay = new StringBuilder();
        for (int i = 0; i < displayWord.length(); i++) {
            formattedDisplay.append(displayWord.charAt(i)).append(" ");
        }
        wordTextView.setText(formattedDisplay.toString().trim());
    }
}
