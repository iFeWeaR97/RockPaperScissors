package com.example.rockpaperscissors;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HelloController {

    @FXML private Label scissors;
    @FXML private Label rock;
    @FXML private Label paper;
    @FXML private Label lifeCounter;
    @FXML private Label computerLifeCounter;
    @FXML private Label UpdateBox;
    @FXML private Button ScissorsButton;
    @FXML private Button PaperButton;
    @FXML private Button RockButton;

    private int playerLife = 5;
    private int computerLife = 5;


    @FXML
    public void initialize() {
        updateLifeCounter();
    }

    private void updateLifeCounter() {
        lifeCounter.setText("Your Lives: " + playerLife);
        computerLifeCounter.setText("Opponent's Lives: " + computerLife);
    }

    private String getComputerChoice() {
        List<String> choices = new ArrayList<>();
        choices.add("Paper");
        choices.add("Scissors");
        choices.add("Rock");
        Collections.shuffle(choices);
        return choices.get(0);
    }

    @FXML
    public void ButtonClickScissors() {
        playRound("Scissors");
    }

    @FXML
    public void ButtonClickRock() {
        playRound("Rock");
    }

    @FXML
    public void ButtonClickPaper() {
        playRound("Paper");
    }

    private void playRound(String playerChoice) {
        String computerChoice = getComputerChoice();

        if (playerChoice.equals(computerChoice)) {
            UpdateBox.setText("It's a tie! No one loses a life.");
        } else if ((playerChoice.equals("Scissors") && computerChoice.equals("Paper")) ||
                (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock"))) {
            computerLife--;
            UpdateBox.setText(playerChoice + " beats " + computerChoice + "! Opponent loses 1 life.");
        } else {
            playerLife--;
            UpdateBox.setText(computerChoice + " beats " + playerChoice + "! You lose 1 life.");
        }

        updateLifeCounter();
        checkGameOver();
    }

    private void checkGameOver() {
        if (playerLife == 0) {
            UpdateBox.setText("You lost all your lives. Game over!");
            disableButtons();
        } else if (computerLife == 0) {
            UpdateBox.setText("Your opponent lost all their lives. You win!");
            disableButtons();
        }
    }

    private void disableButtons() {
        ScissorsButton.setDisable(true);
        PaperButton.setDisable(true);
        RockButton.setDisable(true);
    }
}
