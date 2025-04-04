package feedme;

import java.io.IOException;

import feedme.task.TaskList;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private TaskList taskList = new TaskList();
    private Storage storage = new Storage();
    private Ui ui = new Ui();

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private Image botImage = new Image(this.getClass().getResourceAsStream("/images/charmander.png"));
    private boolean isInitialized = false;

    /**
     * Sets up the GUI with a start message
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }


    /**
     * Sends start message when GUI is initialized
     */
    public void initializeGui() {
        dialogContainer.getChildren().add(DialogBox.getBotDialog(ui.greet(), botImage));
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() throws IOException {
        // Handle the file input and update the UI
        if (!isInitialized) {
            String fileName = userInput.getText();
            String fileResult = storage.setUsingString(taskList, fileName);
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(fileName, userImage),
                    DialogBox.getBotDialog(fileResult, botImage)
            );
            userInput.clear();
            if (fileResult.equals("Tummy set!") || fileResult.contains("Created a new tummy")) {
                isInitialized = true;
                handleCommand();
            }
        } else {
            handleCommand();
        }
    }

    /**
     * Handles commands after file is set and updates the UI
     */
    private void handleCommand() {
        userInput.setOnAction(event -> {
            try {
                // process commands
                String userText = userInput.getText();
                String dukeText = ui.handleCommand(userText, taskList, storage);
                dialogContainer.getChildren().addAll(
                        DialogBox.getUserDialog(userText, userImage),
                        DialogBox.getBotDialog(dukeText, botImage)
                );
                // If the user types "bye", wait for 1 second before closing the stage
                if (userText.equals("bye")) {
                    PauseTransition pause = new PauseTransition(Duration.seconds(1)); // 1-second delay
                    pause.setOnFinished(e -> System.exit(0)); // Close the stage after the delay
                    pause.play(); // Start the pause transition
                }
                userInput.clear();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        sendButton.setOnAction(event -> {
            try {
                // process commands
                String userText = userInput.getText();
                String dukeText = ui.handleCommand(userText, taskList, storage);
                dialogContainer.getChildren().addAll(
                        DialogBox.getUserDialog(userText, userImage),
                        DialogBox.getBotDialog(dukeText, botImage)
                );
                // If the user types "bye", wait for 1 second before closing the stage
                if (userText.equals("bye")) {
                    PauseTransition pause = new PauseTransition(Duration.seconds(1)); // 1-second delay
                    pause.setOnFinished(e -> System.exit(0)); // Close the stage after the delay
                    pause.play(); // Start the pause transition
                }
                userInput.clear();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
