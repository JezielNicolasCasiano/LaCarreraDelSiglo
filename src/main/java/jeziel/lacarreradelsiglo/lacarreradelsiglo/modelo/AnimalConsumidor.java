package jeziel.lacarreradelsiglo.lacarreradelsiglo.modelo;

import javafx.application.Platform;

public class AnimalConsumidor extends Animal {
    private BufferInterface buffer;

    public AnimalConsumidor(String nombre, AnimalListener listener, BufferInterface buffer) {
        super(nombre, listener);
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (this.getAvance() <= 571) {
            this.setAvance(this.getAvance() + this.buffer.get());
            System.out.print(getAvance());
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                this.getListener().actualizarProgreso(this.getNombre(), this.getAvance());
            });
        }
        Platform.runLater(() -> {
            this.getListener().alFinalizar(this.getNombre());
        });
    }
}