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
    Animal capibara1;
    Animal capibara2;
    private final Map<String, ImageView> imagenesCompetidores = new HashMap<>();
    private final Map<String, Label> caminoCompetidores = new HashMap<>();

    @FXML
    private Label ganador;
    @FXML
    private ImageView conejoImagen;
    @FXML
    private ImageView tortugaImagen;
    @FXML
    private ImageView capibaraImagen1;
    @FXML
    private ImageView capibaraImagen2;
    @FXML
    private Label caminoConejo;
    @FXML
    private Label caminoTortuga;

    @Override
    public void actualizarProgreso(String  nombre, int avance){
        Platform.runLater(()->{
            imagenesCompetidores.get(nombre).setTranslateX(avance);
            if(Objects.equals(nombre, "Conejo") || Objects.equals(nombre, "Tortuga")){
                caminoCompetidores.get(nombre).setText("*".repeat(Math.max(0,(int)avance/8)));
            }else{
                caminoCompetidores.get(nombre).setText(" ".repeat(Math.max(0,(int)avance/8)));
            }
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
        capibaraImagen1.setVisible(false);
        capibaraImagen2.setVisible(false);
        capibaraImagen1.setManaged(false);
        capibaraImagen2.setManaged(false);
        imagenesCompetidores.put("Conejo",conejoImagen);
        imagenesCompetidores.put("Tortuga", tortugaImagen);
        imagenesCompetidores.put("capibara1",capibaraImagen1);
        imagenesCompetidores.put("capibara2",capibaraImagen1);
        caminoCompetidores.put("Conejo",caminoConejo);
        caminoCompetidores.put("Tortuga", caminoTortuga);
        caminoCompetidores.put("capibara1",caminoConejo);
        caminoCompetidores.put("capibara2", caminoTortuga);
        ganador.setText("");
        conejo = new Animal("Conejo", this);
        tortuga = new Animal("Tortuga", this);
        capibara1 = new Animal("capibara1", this);
        capibara2 = new Animal("capibara2", this);


    }

    @FXML
    public void clickEmpezar(){
        Thread t1 = new Thread(conejo);
        Thread t2 = new Thread(tortuga);
        t1.start();
        t2.start();
    }

    @FXML
    public void clickReiniciar(){
        ganador.setText("");

        capibaraImagen1.setVisible(true);
        capibaraImagen2.setVisible(true);
        capibaraImagen1.setManaged(true);
        capibaraImagen2.setManaged(true);
        Thread t3 = new Thread(capibara1);
        Thread t4 = new Thread(capibara2);
        t3.setDaemon(true);
        t4.setDaemon(true);
        t3.start();
        t4.start();
        caminoConejo.setText("");
        caminoConejo.setText("");
        capibaraImagen1.setVisible(false);
        capibaraImagen2.setVisible(false);
        capibaraImagen2.setTranslateX(0);
        capibaraImagen2.setTranslateX(0);
        conejoImagen.setTranslateX(0);
        tortugaImagen.setTranslateX(0);


    }

}
