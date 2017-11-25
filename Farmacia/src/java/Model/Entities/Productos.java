package Model.Entities;
// Generated 11-25-2017 09:52:42 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Productos generated by hbm2java
 */
public class Productos  implements java.io.Serializable {


     private Integer productoId;
     private String nombre;
     private BigDecimal precio;
     private String descripcion;
     private int existencias;
     private Set<Proveedores> proveedoreses = new HashSet<Proveedores>(0);
     private Set<Detalleventas> detalleventases = new HashSet<Detalleventas>(0);

    public Productos() {
    }

	
    public Productos(String nombre, BigDecimal precio, int existencias) {
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }
    public Productos(String nombre, BigDecimal precio, String descripcion, int existencias, Set<Proveedores> proveedoreses, Set<Detalleventas> detalleventases) {
       this.nombre = nombre;
       this.precio = precio;
       this.descripcion = descripcion;
       this.existencias = existencias;
       this.proveedoreses = proveedoreses;
       this.detalleventases = detalleventases;
    }
   
    public Integer getProductoId() {
        return this.productoId;
    }
    
    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getExistencias() {
        return this.existencias;
    }
    
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    public Set<Proveedores> getProveedoreses() {
        return this.proveedoreses;
    }
    
    public void setProveedoreses(Set<Proveedores> proveedoreses) {
        this.proveedoreses = proveedoreses;
    }
    public Set<Detalleventas> getDetalleventases() {
        return this.detalleventases;
    }
    
    public void setDetalleventases(Set<Detalleventas> detalleventases) {
        this.detalleventases = detalleventases;
    }




}


