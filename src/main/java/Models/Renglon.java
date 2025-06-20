package Models;

import java.util.ArrayList;
import java.util.List;

public class Renglon {
    private int id;
    private int cantidad;
    private double total;
    private Factura factura;
    private Calzado calzado;

    public Renglon(){
        
    };
    
    public Renglon(int id, int cantidad, double total, Factura factura, Calzado calzado) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.factura = factura;
        this.calzado = calzado;
    }
    
    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }

    public Factura getFactura(){
        return factura;
    }
    
    public Calzado getCalzado() {
        return calzado;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setFactura(Factura f) {
        this.factura = f;
    }
    
    public void setCalzado(Calzado calzado) {
        this.calzado = calzado;
    }
}


