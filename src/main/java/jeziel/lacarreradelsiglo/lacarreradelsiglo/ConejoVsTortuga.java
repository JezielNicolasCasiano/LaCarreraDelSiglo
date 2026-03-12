package jeziel.lacarreradelsiglo.lacarreradelsiglo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ConejoVsTortuga extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ConejoVsTortuga.class.getResource("vista.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ConejoVsTortuga");
        stage.setScene(scene);
        stage.show();
    }
}
