package jeziel.lacarreradelsiglo.lacarreradelsiglo.modelo;
import java.util.Random;

public class Animal {
    String nombre = "";
    int avance = 0;
    Random random = new Random(System.currentTimeMillis());

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public void avanzar(){
        while (this.avance<=471){
            this.avance+=random.nextInt();
        }
    }
}
