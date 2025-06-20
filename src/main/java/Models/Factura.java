

package Models;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int id;
    private int cantidad;
    private double total;
    private Cliente cliente;
    private List<Renglon> renglones;

    public Factura (){
        
    };
    
    public Factura(int id, int cantidad, double total, Cliente cliente, List<Renglon> renglones) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.cliente = cliente;
        this.renglones = renglones;
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

    public Cliente getCliente() {
        return cliente;
    }

    public List<Renglon> getRenglones() {
        return renglones;
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setRenglones(List<Renglon> renglones) {
        this.renglones = renglones;
    }

    public void agregarRenglon(Renglon renglon) {
        this.renglones.add(renglon);
        this.cantidad = renglones.size();
        this.total += renglon.getTotal();
    }

    public void quitarRenglon(Renglon renglon) {
        if (this.renglones.remove(renglon)) {
            this.cantidad = renglones.size();
            this.total -= renglon.getTotal();
        }
    }
}
