package jeziel.lacarreradelsiglo.lacarreradelsiglo.modelo;

import javafx.application.Platform;

import java.util.Random;
import java.util.random.*;

public class AnimalProductor implements Runnable{
    private BufferInterface buffer;
    private int numero = 0;
    private Random random;

    public AnimalProductor(BufferInterface buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        numero = random.nextInt(21);
        random.setSeed(System.currentTimeMillis());
        buffer.put(numero);
    }
}
