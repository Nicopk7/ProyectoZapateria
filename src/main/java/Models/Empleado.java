package Models;

public class Empleado {
    private int legajo;
    private String nombre;
    private String dni;
    private String domicilio;
    private String telefono;
    private int antiguedad;
    private Sucursal sucursal;

    public Empleado(){
        
    };
    
    public Empleado(int legajo, String nombre, String dni, String domicilio, String telefono, int antiguedad, Sucursal sucursal) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.antiguedad = antiguedad;
        this.sucursal = sucursal;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}