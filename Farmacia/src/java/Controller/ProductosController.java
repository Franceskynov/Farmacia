package Controller;

import Model.Dao.ProductosDao;
import Model.Entities.Productos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class ProductosController  implements Serializable{

    public ProductosController() {
    }
    
    private List<Productos> listaProductos;
    private Productos producto;

    public List<Productos> getListaProductos() {
        
        ProductosDao pd = new ProductosDao();
        this.listaProductos = pd.ListaProductos();
        
        return this.listaProductos;
    }

    public void setListarProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    
    public void limpiarProducto(){
        
        producto = new Productos();
        producto.setFechaIngreso(new Date());
    }
    
    public void agregarProducto(){
        
        ProductosDao pd = new ProductosDao();
        pd.agregar(producto);
    }
    
    public void modificarProducto(){
        ProductosDao pd = new ProductosDao();
        pd.modificar(producto);
        limpiarProducto();
    }
    
    public void eliminarProducto(){
        ProductosDao pd = new ProductosDao();
        pd.eliminar(producto);
        limpiarProducto();
    }
    
    public Productos obtenerProducto(int pProductoId){
        ProductosDao pd = new ProductosDao();
        return pd.ObtenerProductos(pProductoId);
    }
}
