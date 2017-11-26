
package Model.Dao;

import Model.Entities.Ventas;
import Model.Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Miguel
 */
public class VentasDao {
    
        public List<Ventas> ListaVentas(){
        List<Ventas> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tran = session.beginTransaction();
        String hql = "FROM Ventas";
        try{
            lista = session.createQuery(hql).list();
            tran.commit();
            session.close();
        }catch(Exception ex){
            tran.rollback();
        }
        
        return lista;
    }
    
    public void agregar(Ventas venta) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(venta);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }
    
    public void modificar(Ventas venta) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(venta);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }
    
    public void eliminar(Ventas venta) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(venta);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }
    
}
