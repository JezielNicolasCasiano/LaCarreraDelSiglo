package jeziel.lacarreradelsiglo.lacarreradelsiglo.modelo;

public class Buffer implements BufferInterface{

    private boolean avaliable = false;
    private  int content;

    public synchronized int get(){
        while(!avaliable){
            try{
                wait(); //Espera a que available sea verdadero
            }catch (InterruptedException e){}

        }
        avaliable = false;
        notifyAll(); //Le avisa al productor que la caja ya esta vacia
        return content;
    }

    public synchronized void put(int value) {
        while (avaliable == true) {
            try {
                wait(); // Espera a que available sea falso
            } catch (InterruptedException e) {
            }
        }
        content = value;
        avaliable = true;
        notifyAll(); //Le avisa al consumidor que hay algo en la caja
    }

}
