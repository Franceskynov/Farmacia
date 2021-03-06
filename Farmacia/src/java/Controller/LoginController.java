package Controller;

import Model.Dao.EmpleadosDao;
import Model.Entities.Empleados;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miguel
 */
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    private Empleados usuario;

    //creando un nuevo objeto de LoginController, y  a su vez un objeto para manejar el usuario
    public LoginController() {
        this.usuario = new Empleados();
    }

    public Empleados getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleados usuario) {
        this.usuario = usuario;
    }
    
    public String login() {
        FacesMessage mensaje = null;
        EmpleadosDao ud = new EmpleadosDao();
        usuario = ud.login(usuario);
        if (usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome  ", this.usuario.getNombre());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return "/views/admin/dashboard.xhtml";
        } else {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de Acceso", "Usuario o Clave incorrecta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            usuario = new Empleados();
            
            return "";
        }
    }

    public String cerrarSession() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        return "login";
    }
    
}
