package src;

public class Pacientes extends Personas {
    private int numeroHistorial;
    private String EPS;
    private double saldoDisponible;
    private String sintoma;


    public Pacientes(int numeroHistorial, String EPS, double saldoDisponible, String nombre, String genero, int DNI, int edad, String sintoma) {
        super(nombre, genero, DNI, edad);
        this.numeroHistorial = numeroHistorial;
        this.EPS = EPS;
        this.saldoDisponible = saldoDisponible;
        this.sintoma = sintoma;
    }

    public int getNumeroHistorial() {
        return numeroHistorial;
    }

    public void setNumeroHistorial(int numeroHistorial) {
        this.numeroHistorial = numeroHistorial;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }


    public void verificarSaldo() {

        double costoConsulta = 45.00;
        if (saldoDisponible > 0) {
            if (saldoDisponible >= costoConsulta) {
                System.out.println("si te alcanza ya que tu saldo es : " + saldoDisponible + "y la consulta te vale : " + costoConsulta);


            } else {
                System.out.println("no te alcanza, trabaja mas ");
            }
        }

    }

    public void mostrarSintoma() {
        System.out.println("Síntoma: " + sintoma);
    }


    @Override
    public void realizarActividad() {
        verificarSaldo();
    }
}
