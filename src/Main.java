import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    //private static Stage mainStage;

    @Override
    public void start(Stage mainStage) throws Exception {
        //Main.mainStage = mainStage;
        ConfigurationSingleton.getInstance().setMainStage(mainStage);
        Parameters p = getParameters();
        //stage.setHeight(Double.parseDouble(p.getNamed().get("height")));
        //stage.setWidth(Double.parseDouble(p.getNamed().get("width")));
        mainStage.setTitle("My Super Cool Application");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    //public static Stage getMainStage() {
    //    return mainStage;
    //}

    public static void main(String[] args) {
        launch(args);
    }
}