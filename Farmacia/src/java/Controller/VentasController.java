/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dao.EmpleadosDao;
import Model.Dao.VentasDao;
import Model.Entities.Detalleventas;
import Model.Entities.Empleados;
import Model.Entities.Ventas;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
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

    public VentasController() {
    }
    
    private List<Ventas> listaVentas;
    private List<Detalleventas> listaDetalleVentas;
    private Detalleventas detalleVentas;
    private Ventas venta;
    
    public List<Ventas> getListaVentas() {
        VentasDao dao = new VentasDao();
        this.listaVentas = dao.ListaVentas();
        return this.listaVentas;
    }

    public void setListaVentas(List<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public List<Detalleventas> getListaDetalleVentas() {
        return listaDetalleVentas;
    }

    public void setListaDetalleVentas(List<Detalleventas> listaDetalleVentas) {
        this.listaDetalleVentas = listaDetalleVentas;
    }
    
    public Detalleventas getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(Detalleventas detalleVentas) {
        this.detalleVentas = detalleVentas;
    }
    
    public void iniciarVenta() {
        venta = new Ventas();
        venta.setFechaVenta(new Date());
        venta.setEmpleados(new EmpleadosDao().ObtenerEmpleado(1)); // Obtener el empleado según el Id de la sesión
    }
    
    public void agregarVenta() {
        VentasDao ventasDao = new VentasDao();
        ventasDao.agregar(venta);
    }
    
    public void agregarDetalles(){
        listaDetalleVentas.add(detalleVentas);
        this.venta.setDetalleventases((Set<Detalleventas>) this.listaDetalleVentas);
    }
}
