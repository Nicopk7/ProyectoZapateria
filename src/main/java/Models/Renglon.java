package Models;

import java.util.ArrayList;
import java.util.List;

public class Renglon {
    private int cantidad;
    private double total;
    private Calzado calzado;

    public Renglon(int cantidad, double total, Calzado calzado) {
        this.cantidad = cantidad;
        this.total = total;
        this.calzado = calzado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }

    public Calzado getCalzado() {
        return calzado;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCalzado(Calzado calzado) {
        this.calzado = calzado;
    }
}


