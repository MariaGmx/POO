package src;

public abstract class Personas {
    private String nombre;
    private String genero;
    private int DNI;
    private int edad;

    public Personas(String nombre, String genero, int DNI, int edad) {
        this.nombre = nombre;
        this.genero = genero;
        this.DNI = DNI;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public abstract void realizarActividad();

    
}
