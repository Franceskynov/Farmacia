/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dao.EmpleadosDao;
import Model.Entities.Empleados;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.inject.Named;
//import javax.faces.view.ViewScoped;

/**
 *
 * @author Josué Mercally
 */
//@Named(value = "Empleados")
@ManagedBean
@ViewScoped
public class EmpleadosController implements Serializable {

    public EmpleadosController(){        
    }
    
    private List<Empleados> listaEmpleados;
    
    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }   
    
    public List<Empleados> getListaEmpleados(){
        
        //retorna lista de empleados
        return EmpleadosDao.ListaEmpleados();
    } 
}
