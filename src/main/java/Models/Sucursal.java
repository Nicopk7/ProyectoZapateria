package Models;

import java.util.List;
import java.util.ArrayList;

public class Sucursal {
    private int id;
    private String nombre;
    private String domicilio;
    private String ciudad;
    private List<Empleado> empleados;

    public Sucursal(int id,String nombre, String domicilio, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.empleados = new ArrayList<>();
    }

    public Sucursal() {
         
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    //Agregar un empleado individual
    public void agregarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }
}

