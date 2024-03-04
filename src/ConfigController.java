import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ConfigController {
    private Stage mainStage;

    @FXML
    TextField textFieldIP;

    public void initialize() {
        System.out.println("Initializing ConfigController...");
        mainStage = Main.getMainStage();
    }
    @FXML
    public void saveConfiguration() {
        System.out.println("In saveConfiguration method!");
        String ip = textFieldIP.getText();
        if( !ip.isEmpty() ) {
            System.out.printf("Saving new IP %s.%n", ip);
            ConfigurationSingleton configSingleton = ConfigurationSingleton.getInstance();
            configSingleton.setConfiguredIP(ip);
        }
        // Swap back to main scene.
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        }catch (IOException ioe){
            System.err.println("Error swapping scenes.");
            ioe.printStackTrace();
        }
    }
}
