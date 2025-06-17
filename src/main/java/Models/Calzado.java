package Models;

public class Calzado {
    private int codigo;
    private String descripcion;
    private String marca;
    private double precioCosto;
    private double precioVenta;
    private String color;
    private int talle;
    private int cantStock;
    private Sucursal sucursal; 

    public Calzado(int codigo, String descripcion, String marca, double precioCosto, double precioVenta, String color, int talle, int cantStock, Sucursal sucursal) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.color = color;
        this.talle = talle;
        this.cantStock = cantStock;
        this.sucursal = sucursal;
    }
    public Calzado() {
    
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTalle() {
        return talle;
    }

    public void setTalle(int talle) {
        this.talle = talle;
    }

    public int getCantStock() {
        return cantStock;
    }

    public void setCantStock(int cantStock) {
        this.cantStock = cantStock;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}



