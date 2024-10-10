import javafx.stage.Stage;

public class ConfigurationSingleton {

    private Stage mainStage;
    private String configuredIP;
    private ConfigurationSingleton(){ }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    private static class SingletonHelper {
        private static final ConfigurationSingleton INSTANCE = new ConfigurationSingleton();
    }

    public static ConfigurationSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void setConfiguredIP(String ip) {
        this.configuredIP = ip;
    }
    public String getConfiguredIP() {
        System.out.println("Returning the IP I have.");
        return this.configuredIP;
    }
}