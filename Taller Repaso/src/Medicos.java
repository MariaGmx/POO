package src;

import java.util.ArrayList;
import java.util.List;

public class Medicos extends Personas {
    private String especialidad;
    private int numRegistro;

    private List<Pacientes> pacientes = new ArrayList<>();

    public Medicos(String nombre, String genero, int DNI, int edad, String especialidad, int numRegistro) {
        super(nombre, genero, DNI, edad);
        this.especialidad = especialidad;
        this.numRegistro = numRegistro;
    }


    public String getEspecialidad() {
        return especialidad;
    }

    public void agregarPaciente(Pacientes paciente) {
        pacientes.add(paciente);
    }

    public void revisarPacientes() {
        for (Pacientes paciente : pacientes) {
            System.out.println("----------------------------------------");
            System.out.println("Paciente" + paciente.getNombre());

        }
    }


    public void prioridadSintoma(Pacientes paciente) {
        String sintoma = paciente.getSintoma();


        switch (sintoma) {
            case "Infarto":
                sintoma = "1";
                break;
            case "Dolor":
                sintoma = "2";
                break;
            case "Fiebre":
                sintoma = "3";
                break;
            default:
                sintoma = "Sintoma no reconocido, no te estas muriendo, puedes esperar";
                break;
        }
        System.out.println(sintoma);
    }

    @Override
    public void realizarActividad() {
        revisarPacientes();
    }
}
