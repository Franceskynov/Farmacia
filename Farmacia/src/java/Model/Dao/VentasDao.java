
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
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tran = sesion.beginTransaction();
        try {
            sesion.save(venta);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }
    
    public void modificar(Ventas venta) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tran = sesion.beginTransaction();
        try {    
            sesion.update(venta);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }
    
    public void eliminar(Ventas venta) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tran = sesion.beginTransaction();
        try {
            sesion.delete(venta);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }
}
