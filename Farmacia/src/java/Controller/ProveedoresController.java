    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dao.ProveedoresDao;
import Model.Entities.Proveedores;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.inject.Named;
//import javax.faces.view.ViewScoped;


@ManagedBean
@ViewScoped
public class ProveedoresController implements Serializable{

    public ProveedoresController() {
    }
    
    private List<Proveedores> listaProveedores;
    private Proveedores proveedor;
    private String active;
    
    public String getActive() {
        active = "active";
        return active;
    }
    
    public void setListaProveedores(List<Proveedores> listaProveedores){
        this.listaProveedores = listaProveedores;
    }
    
    public List<Proveedores> getListaProveedores(){
        ProveedoresDao Dao = new ProveedoresDao();
        this.listaProveedores = Dao.ListaProveedores();
        return this.listaProveedores;
    }
    
    public Proveedores getProveedor()
    {
        return proveedor;
    }
    
    public void limpiarProveedor(){
        proveedor = new Proveedores();
        proveedor.setFechaCreacion(new Date());
    }
    
    public void agregarProveedor(){
        ProveedoresDao pd = new ProveedoresDao();
        pd.agregar(proveedor);
    }
    
    public void modificarProveedor() {
        ProveedoresDao pd = new ProveedoresDao();
        pd.modificar(proveedor);
        limpiarProveedor();
    }
    
    public void eliminarProveedor() {
        ProveedoresDao pd = new ProveedoresDao();
        pd.eliminar(proveedor);
        limpiarProveedor();
    }
    
}
