package Models;

public class Cliente {
    private String nombre;
    private String DNI_CUIL;
    private String telefono;

    public Cliente(String nombre, String DNI_CUIL, String telefono) {
        this.nombre = nombre;
        this.DNI_CUIL = DNI_CUIL;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI_CUIL() {
        return DNI_CUIL;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI_CUIL(String DNI_CUIL) {
        this.DNI_CUIL = DNI_CUIL;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

