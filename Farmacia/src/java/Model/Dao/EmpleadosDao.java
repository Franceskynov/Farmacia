/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entities.Empleados;
import Model.Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Josué Mercally
 */
public class EmpleadosDao {
    
    public List<Empleados> ListaEmpleados(){
        List<Empleados> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tran = session.beginTransaction();
        String hql = "FROM Empleados";
        try{
            lista = session.createQuery(hql).list();
            tran.commit();
        }catch(Exception ex){
            tran.rollback();
        }
        session.close();
        return lista;
    }
}
