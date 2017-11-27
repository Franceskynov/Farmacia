/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dao.VentasDao;
import Model.Entities.Empleados;
import Model.Entities.Ventas;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Josué Mercally
 */
//@Named(value = "ventasController")
@ManagedBean
@ViewScoped
public class VentasController {

    /**
     * @return the active
     */
    public String getActive() {
        active = "active";
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     * @return the listaVentas
     */
    public List<Ventas> getListaVentas() {
        VentasDao dao = new VentasDao();
        this.listaVentas = dao.ListaVentas();
        return this.listaVentas;
    }

    /**
     * @param listaVentas the listaVentas to set
     */
    public void setListaVentas(List<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }

    /**
     * @return the venta
     */
    public Ventas getVenta() {
        return venta;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    /**
     * Creates a new instance of VentasController
     */
    public VentasController() {
    }
    
    private List<Ventas> listaVentas;
    private Ventas venta;
    private String active;
    
    public void limpiarVenta() {
        venta = new Ventas();
        venta.setFechaVenta(new Date());
    }
}
