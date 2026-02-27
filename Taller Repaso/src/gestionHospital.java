package src;

import java.util.ArrayList;
import java.util.List;

public class gestionHospital {

    public static void main(String[] args) {

        System.out.println("\n--- 1. POLIMORFISMO: PRESENTACIÓN DE DATOS ---\n");

        // =========================
        // CREACIÓN MÉDICOS
        // =========================
        Medicos m1 = new Medicos("Yeymi Tatiana", "Femenino", 101, 17, "Cardiología", 5001);
        Medicos m2 = new Medicos("Maria Antonia", "Femenino", 102, 50, "Pediatría", 5002);
        Medicos m3 = new Medicos("Emmanuel ", "Masculino", 103, 39, "Medicina General", 5003);
        Medicos m4 = new Medicos("Diana Montoya", "Femenino", 104, 20, "Ginecología", 5004);

        MedicoCirujano c1 = new MedicoCirujano("Yeymi Tatiana", "Femenino", 201, 17, "Neurocirugía", 6001, 5);
        MedicoCirujano c2 = new MedicoCirujano("Mario Antonio", "Masculino", 202, 52, "Traumatología", 6002, 6);
        MedicoCirujano c3 = new MedicoCirujano("Manuela", "Femenino", 203, 44, "Cirugía Plástica", 6003, 7);
        MedicoCirujano c4 = new MedicoCirujano("Cesar", "Masculino", 204, 47, "Cirugía Cardiovascular", 6004, 8);

        // =========================
        // CREACIÓN PACIENTES
        // =========================
        Pacientes p1 = new Pacientes(1, "Sanidad militar", 200.0, "Susana", "No binario", 301, 30, "Infarto");
        Pacientes p2 = new Pacientes(2, "Nueva EPS", 30.0, "Mariana ", "Femenino", 302, 25, "Fiebre");

        // =========================
        // LISTA POLIMÓRFICA
        // =========================
        List<Personas> lista = new ArrayList<>();

        lista.add(m1);
        lista.add(m2);
        lista.add(m3);
        lista.add(m4);
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);
        lista.add(p1);
        lista.add(p2);

        System.out.println(">> PRESENTACIÓN MÉDICOS");
        for (Personas persona : lista) {
            if (persona instanceof Medicos && !(persona instanceof MedicoCirujano)) {
                Medicos med = (Medicos) persona;
                System.out.println("[Médico] Dr. " + med.getNombre() + " - Especialidad: " + med.getEspecialidad());
            }
        }

        System.out.println("\n>> PRESENTACIÓN PACIENTES");
        for (Personas persona : lista) {
            if (persona instanceof Pacientes) {
                Pacientes pac = (Pacientes) persona;
                System.out.println("[Paciente] " + pac.getNombre()
                        + " - EPS: " + pac.getEPS()
                        + " - Síntoma: " + pac.getSintoma());
            }
        }

        // =========================
        // 2. ACCIÓN DEL MÉDICO
        // =========================
        System.out.println("\n--- 2. ACCIÓN DEL MÉDICO ---");

        m1.agregarPaciente(p1);
        m1.agregarPaciente(p2);

        System.out.println("Dr. " + m1.getNombre() + " revisando lista de pacientes:");
        m1.revisarPacientes();

        System.out.print("El Dr. " + m1.getNombre()
                + " evaluó el síntoma [" + p1.getSintoma() + "] y asignó Prioridad ");

        m1.prioridadSintoma(p1);

        // =========================
        // 3. ACCIÓN DEL PACIENTE
        // =========================
        System.out.println("\n--- 3. ACCIÓN DEL PACIENTE ---");

        double valorConsulta = 50.0;

        System.out.print("El paciente " + p1.getNombre()
                + " intenta pagar $50.0. Saldo actual: $"
                + p1.getSaldoDisponible() + " -> Resultado: ");

        if (p1.getSaldoDisponible() >= valorConsulta) {
            System.out.println("Éxito.");
        } else {
            System.out.println("Rechazado (Fondos insuficientes).");
        }

        System.out.print("El paciente " + p2.getNombre()
                + " intenta pagar $50.0. Saldo actual: $"
                + p2.getSaldoDisponible() + " -> Resultado: ");

        if (p2.getSaldoDisponible() >= valorConsulta) {
            System.out.println("Éxito.");
        } else {
            System.out.println("Rechazado que mal ohhhhh nooooooooooooooooo (Fondos insuficientes).");
        }

        // =========================
        // 4. ACCIÓN DEL CIRUJANO
        // =========================
        System.out.println("\n--- 4. ACCIÓN DEL CIRUJANO ---");

        boolean quirofanoDisponible = true;

        if (quirofanoDisponible) {
            System.out.println("La cirujana " + c1.getNombre()
                    + " está operando en el quirófano B6");
        } else {
            System.out.println("El quirófano no está disponible.");
        }

        // =========================
        // 5. DEPENDENCIA: ATENCIÓN
        // =========================
        System.out.println("\n--- 5. DEPENDENCIA: CLASE ATENCION ---");

        Atencion atencion = new Atencion();
        atencion.procesarIngreso(p1);
    }
}
