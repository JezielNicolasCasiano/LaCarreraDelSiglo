module jeziel.lacarreradelsiglo.lacarreradelsiglo {
    requires javafx.controls;
    requires javafx.fxml;


    opens jeziel.lacarreradelsiglo.lacarreradelsiglo to javafx.fxml;
    opens jeziel.lacarreradelsiglo.lacarreradelsiglo.controlador to javafx.fxml;
    exports jeziel.lacarreradelsiglo.lacarreradelsiglo;
}