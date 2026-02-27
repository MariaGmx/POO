package src;

public class Atencion {


    public void procesarIngreso(Pacientes paciente) {

        switch (paciente.getEPS()) {

            case "SURA":
                System.out.println("Enviar a Pabellón A");
                break;

            case "NuevaEPS":
                System.out.println("Enviar a Pabellón B");
                break;

            default:
                System.out.println("Enviar a Pabellón General");
        }
    }
}


