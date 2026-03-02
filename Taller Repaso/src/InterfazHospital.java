package src;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InterfazHospital extends JFrame {

    private JPanel panelContenido;
    private JTable tablaPacientes;
    private JTable tablaCirujanos;
    private DefaultTableModel modeloPacientes;
    private JLabel contadorLabel;

    // Constructor de la clase InterfazHospital
    public InterfazHospital() {

        // Establece el título de la ventana
        setTitle("Sistema Hospital Privado");

        // Define el tamaño de la ventana (ancho x alto)
        setSize(1200, 750);

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // Indica que el programa se cierre completamente al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Define el layout principal de la ventana como BorderLayout
        // Esto permite dividir la ventana en zonas (NORTH, SOUTH, EAST, WEST, CENTER)
        setLayout(new BorderLayout());

        // ======================
        // CREACIÓN DEL MENÚ LATERAL
        // ======================

        // Crea un panel con 4 filas y 1 columna para los botones del menú
        JPanel menu = new JPanel(new GridLayout(4, 1));

        // Define el ancho del menú lateral (230px) y altura automática
        menu.setPreferredSize(new Dimension(230, 0));

        // Establece un color de fondo oscuro personalizado
        menu.setBackground(new Color(28, 40, 51));

        // Crea los botones del sistema usando un método personalizado crearBoton()
        JButton btnMedicos = crearBoton("Médicos");
        JButton btnPacientes = crearBoton("Pacientes");
        JButton btnCirujanos = crearBoton("Cirujanos");
        JButton btnSalir = crearBoton("Salir");

        // Agrega los botones al panel del menú
        menu.add(btnMedicos);
        menu.add(btnPacientes);
        menu.add(btnCirujanos);
        menu.add(btnSalir);

        // Agrega el menú al lado izquierdo de la ventana
        add(menu, BorderLayout.WEST);

        // ======================
        // PANEL DE CONTENIDO PRINCIPAL
        // ======================

        // Crea el panel donde se mostrará el contenido dinámico
        panelContenido = new JPanel(new BorderLayout());

        // Lo agrega al centro de la ventana
        add(panelContenido, BorderLayout.CENTER);

        // ======================
        // EVENTOS DE LOS BOTONES
        // ======================

        // Cuando se hace clic en "Médicos", muestra la vista de médicos
        btnMedicos.addActionListener(e -> mostrarMedicos());

        // Cuando se hace clic en "Pacientes", muestra la vista de pacientes
        btnPacientes.addActionListener(e -> mostrarPacientes());

        // Cuando se hace clic en "Cirujanos", muestra la vista de cirujanos
        btnCirujanos.addActionListener(e -> mostrarVistaCirujanos());

        // Cuando se hace clic en "Salir", cierra completamente la aplicación
        btnSalir.addActionListener(e -> System.exit(0));

        // Muestra por defecto la vista de médicos al iniciar el sistema
        mostrarMedicos();
    }
    private JButton crearBoton(String texto) {
        JButton b = new JButton(texto);
        b.setForeground(Color.WHITE);
        b.setBackground(new Color(52, 73, 94));
        b.setFocusPainted(false);
        b.setFont(new Font("Segoe UI", Font.BOLD, 16));
        return b;
    }


    private void mostrarMedicos() {

        panelContenido.removeAll();

        String[] col = {"ID", "Nombre", "Especialidad"};
        Object[][] datos = {
                 {"M01", "Dr. Carlos Gómez", "Cardiología"},
                 {"M02", "Dra. Juan David Marin", "Pediatría"},
                 {"M03", "Dra. Maria Antonia", "Radiología"},
                 {"M04", "Dra. Yeymi Tatiana", "Neurocirujana"},

        };

        JTable tabla = new JTable(new DefaultTableModel(datos, col));
        estilizarTabla(tabla);

        panelContenido.add(new JScrollPane(tabla), BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarPacientes() {

        panelContenido.removeAll();

        inicializarPacientes();

        contadorLabel = new JLabel();
        actualizarContador();

        JPanel superior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        superior.add(contadorLabel);

        panelContenido.add(superior, BorderLayout.NORTH);
        panelContenido.add(new JScrollPane(tablaPacientes), BorderLayout.CENTER);

        aplicarColoresEstado();

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void inicializarPacientes() {

        String[] col = {"ID", "Nombre", "Edad", "Síntomas", "Estado"};

        Object[][] datos = {
                {"P01", "María López", 32, "Fiebre", "En espera"},
                {"P02", "Juan Pérez", 45, "Dolor", "En espera"},
                {"P03", "Ana Torres", 28, "Infarto", "En espera"}
        };

        modeloPacientes = new DefaultTableModel(datos, col);
        tablaPacientes = new JTable(modeloPacientes);

        estilizarTabla(tablaPacientes);
    }

    private void mostrarVistaCirujanos() {

        panelContenido.removeAll();
        panelContenido.setLayout(new BorderLayout());

        inicializarPacientes();

        String[] colCir = {"ID", "Nombre", "Especialidad "};
        Object[][] datosCir = {
                {"C01", "Dr. Felipe Rojas", "Cardiovascular"},
                {"C02", "Dra. Natalia Vega", "Neurocirugía"},
                {"C03", "Dra. Diana Marcela", "Cardiología"}


        };

        tablaCirujanos = new JTable(new DefaultTableModel(datosCir, colCir));
        estilizarTabla(tablaCirujanos);

        JSplitPane split = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(tablaCirujanos),
                new JScrollPane(tablaPacientes)
        );

        split.setDividerLocation(250);

        JButton asignar = new JButton("Enviar a Pabellón");
        asignar.setBackground(new Color(39, 174, 96));
        asignar.setForeground(Color.WHITE);
        asignar.setFont(new Font("Segoe UI", Font.BOLD, 15));

        asignar.addActionListener(e -> enviarAPabellon());

        JPanel sur = new JPanel();
        sur.add(asignar);

        contadorLabel = new JLabel();
        actualizarContador();

        panelContenido.add(split, BorderLayout.CENTER);
        panelContenido.add(sur, BorderLayout.SOUTH);

        aplicarColoresEstado();

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void enviarAPabellon() {

        int filaPaciente = tablaPacientes.getSelectedRow();
        int filaCirujano = tablaCirujanos.getSelectedRow();

        if (filaPaciente == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un paciente.");
            return;
        }

        if (filaCirujano == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cirujano.");
            return;
        }

        String[] opciones = {"Pabellón 1", "Pabellón 2", "Pabellón 3"};

        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione pabellón:",
                "Asignación",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion != null) {

            modeloPacientes.setValueAt(seleccion, filaPaciente, 4);

            aplicarColoresEstado();
            actualizarContador();

            String nombreCirujano =
                    tablaCirujanos.getValueAt(filaCirujano, 1).toString();

            JOptionPane.showMessageDialog(this,
                    "El cirujano " + nombreCirujano +
                            " envió el paciente a " + seleccion);
        }
    }

    private void aplicarColoresEstado() {

        tablaPacientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value,
                                                           boolean isSelected,
                                                           boolean hasFocus,
                                                           int row,
                                                           int column) {

                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);


                String estado = table.getValueAt(row, 4).toString();

                if (estado.equals("En espera...")) {
                    c.setBackground(new Color(255, 255, 153));
                } else {
                    c.setBackground(new Color(169, 223, 191));
                }

                if (isSelected)
                    c.setBackground(c.getBackground().darker());

                return c;
            }
        });
    }


    private void actualizarContador() {

        if (modeloPacientes == null) return;

        int espera = 0, p1 = 0, p2 = 0, p3 = 0;

        for (int i = 0; i < modeloPacientes.getRowCount(); i++) {


            String estado = modeloPacientes.getValueAt(i, 4).toString();

            switch (estado) {
                case "En espera" -> espera++;
                case "Pabellón 1" -> p1++;
                case "Pabellón 2" -> p2++;
                case "Pabellón 3" -> p3++;
            }
        }

        if (contadorLabel != null) {
            contadorLabel.setText("En espera: " + espera +
                    " | P1: " + p1 +
                    " | P2: " + p2 +
                    " | P3: " + p3);
        }
    }

    private void estilizarTabla(JTable tabla) {

        tabla.setRowHeight(30);
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tabla.getTableHeader().setBackground(new Color(41, 128, 185));
        tabla.getTableHeader().setForeground(Color.WHITE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new InterfazHospital().setVisible(true));
    }
}