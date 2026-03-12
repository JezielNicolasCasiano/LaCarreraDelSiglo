package jeziel.lacarreradelsiglo.lacarreradelsiglo.controlador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import jeziel.lacarreradelsiglo.lacarreradelsiglo.modelo.Animal;

public class Controlador {
    Animal conejo = new Animal("Conejo");
    Animal tortuga = new Animal("Tortuga");

    @FXML
    private Label ganador;
    @FXML
    private Button empezar;
    @FXML
    private ImageView conejoImagen;
    @FXML
    private ImageView tortugaImagen;





}
