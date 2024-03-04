import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RootApplicationController {
    private Stage mainStage;

    @FXML
    MenuItem menuItemPreferences;

    @FXML
    Label labelMainApp;

    public void initialize() {
        System.out.println("Initializing RootApplicationController...");
        mainStage = Main.getMainStage();
        // Since this gets called with scene swapping due to me re-loading the FXML
        // this is where I can initialize my Main Application Scene Label with the new config.
        // There are better ways of doing this, but this is to demo the Singleton Config, so I'm
        // doing it this way for now :-)
        labelMainApp.setText(
                labelMainApp.getText() + " " +
                        ConfigurationSingleton.getInstance().getConfiguredIP());
    }

    @FXML
    public void editPreferences(ActionEvent event) {
        System.out.println("Switching to the configuration scene!");
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("configuration.fxml")));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        }catch (IOException ioe){
            System.err.println("Error swapping scenes.");
            ioe.printStackTrace();
        }
    }
}
