package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class InterfazHospital extends JFrame {

    private JTextArea areaTexto;
    private List<Personas> lista;

    public InterfazHospital() {

        setTitle("Sistema de Gestión Hospitalaria");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        UIManager.put("Button.arc", 20);

        // ======================
        // COLORES
        // ======================
        Color fondo = new Color(230, 240, 250);
        Color botonColor = new Color(0, 123, 255);

        getContentPane().setBackground(fondo);
        setLayout(new BorderLayout());

        // ======================
        // TÍTULO
        // ======================
        JLabel titulo = new JLabel("HOSPITAL CENTRAL", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titulo, BorderLayout.NORTH);

        // ======================
        // ÁREA DE TEXTO
        // ======================
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);

        // ======================
        // PANEL BOTONES
        // ======================
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(fondo);

        JButton btnMedicos = new JButton("Ver Médicos");
        JButton btnPacientes = new JButton("Ver Pacientes");
        JButton btnAtencion = new JButton("Procesar Atención");

        JButton[] botones = {btnMedicos, btnPacientes, btnAtencion};

        for (JButton b : botones) {
            b.setBackground(botonColor);
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
            b.setFont(new Font("Arial", Font.BOLD, 14));
            panelBotones.add(b);
        }

        add(panelBotones, BorderLayout.SOUTH);

        // ======================
        // DATOS
        // ======================
        inicializarDatos();

        // ======================
        // EVENTOS
        // ======================

        btnMedicos.addActionListener(e -> mostrarMedicos());
        btnPacientes.addActionListener(e -> mostrarPacientes());
        btnAtencion.addActionListener(e -> procesarAtencion());

        setVisible(true);
    }

    private void inicializarDatos() {

        lista = new ArrayList<>();

        Medicos m1 = new Medicos("Yeymi Tatiana", "Femenino", 101, 17, "Cardiología", 5001);
        MedicoCirujano c1 = new MedicoCirujano("Mario Antonio", "Masculino", 202, 52, "Traumatología", 6002, 6);
        Pacientes p1 = new Pacientes(1, "SURA", 200.0, "Susana", "No binario", 301, 30, "Infarto");

        lista.add(m1);
        lista.add(c1);
        lista.add(p1);
    }

    private void mostrarMedicos() {
        areaTexto.setText("=== LISTA MÉDICOS ===\n\n");

        for (Personas p : lista) {
            if (p instanceof Medicos) {
                Medicos m = (Medicos) p;
                areaTexto.append("Dr. " + m.getNombre() +
                        " - Especialidad: " + m.getEspecialidad() + "\n");
            }
        }
    }

    private void mostrarPacientes() {
        areaTexto.setText("=== LISTA PACIENTES ===\n\n");

        for (Personas p : lista) {
            if (p instanceof Pacientes) {
                Pacientes pac = (Pacientes) p;
                areaTexto.append(pac.getNombre() +
                        " - EPS: " + pac.getEPS() +
                        " - Síntoma: " + pac.getSintoma() + "\n");
            }
        }
    }

    private void procesarAtencion() {
        areaTexto.setText("=== PROCESANDO ATENCIÓN ===\n\n");

        Atencion atencion = new Atencion();

        for (Personas p : lista) {
            if (p instanceof Pacientes) {
                Pacientes pac = (Pacientes) p;
                areaTexto.append("Paciente: " + pac.getNombre() + "\n");

                switch (pac.getEPS()) {
                    case "SURA":
                        areaTexto.append("Enviar a Pabellón A\n\n");
                        break;
                    case "NuevaEPS":
                        areaTexto.append("Enviar a Pabellón B\n\n");
                        break;
                    default:
                        areaTexto.append("Enviar a Pabellón General\n\n");
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new InterfazHospital();
    }
}

