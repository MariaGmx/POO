package src;
// clase medico cirujano

public class MedicoCirujano extends Medicos {

    private int numeroQuirofano;

    public MedicoCirujano(String nombre, String genero, int DNI, int edad,
                          String especialidad, int numRegistro, int numeroQuirofano) {

        super(nombre, genero, DNI, edad, especialidad, numRegistro);
        this.numeroQuirofano = numeroQuirofano;
    }

    public void operar(boolean quirofanoDisponible) {

        if (quirofanoDisponible) {
            System.out.println("OperaciónNNNNNNNN realizada en quirófano " + numeroQuirofano);
        } else {
            System.out.println("No se puede operar, quirófano no disponible.");
        }
    }
}


