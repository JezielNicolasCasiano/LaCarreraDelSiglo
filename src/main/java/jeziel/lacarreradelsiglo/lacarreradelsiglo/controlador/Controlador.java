package jeziel.lacarreradelsiglo.lacarreradelsiglo.controlador;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import jeziel.lacarreradelsiglo.lacarreradelsiglo.modelo.Animal;
import jeziel.lacarreradelsiglo.lacarreradelsiglo.modelo.AnimalListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controlador implements Initializable, AnimalListener {
    Animal conejo;
    Animal tortuga;
    StringBuilder sb;
    private final Map<String, ImageView> imagenesCompetidores = new HashMap<>();
    private final Map<String, Label> caminoCompetidores = new HashMap<>();

    @FXML
    private Label ganador;
    @FXML
    private ImageView conejoImagen;
    @FXML
    private ImageView tortugaImagen;
    @FXML
    private Label caminoConejo;
    @FXML
    private Label caminoTortuga;

    @Override
    public void actualizarProgreso(String  nombre, int avance){
        Platform.runLater(()->{
            imagenesCompetidores.get(nombre).setX(avance);
            caminoCompetidores.get(nombre).setText("*".repeat(Math.max(0,(int)avance/13)));
        });
    }

    @Override
    public void alFinalizar(String nombre) {
        if (Objects.equals(ganador.getText(), "")){
            ganador.setText(nombre);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        imagenesCompetidores.put("Conejo",conejoImagen);
        imagenesCompetidores.put("Tortuga", tortugaImagen);
        caminoCompetidores.put("Conejo",caminoConejo);
        caminoCompetidores.put("Tortuga", caminoTortuga);
        ganador.setText("");
        conejo = new Animal("Conejo", this);
        tortuga = new Animal("Tortuga", this);
    }

    @FXML
    public void clickEmpezar(){
        Thread t1 = new Thread(conejo);
        Thread t2 = new Thread(tortuga);
        t1.start();
        t2.start();
    }


}
