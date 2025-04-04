package feedme;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);

            //need this line to make the CSS work
            scene.getStylesheets().add(getClass().getResource("/view/MainWindow.css").toExternalForm());

            stage.setTitle("FeedMe");
            stage.setScene(scene);
            stage.show();
            fxmlLoader.<MainWindow>getController().initializeGui();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
