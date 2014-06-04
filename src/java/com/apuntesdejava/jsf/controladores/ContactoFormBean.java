/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apuntesdejava.jsf.controladores;

import com.apuntesdejava.jsf.util.ResourcesUtil;
import java.util.Locale;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;






/**
 *
 * @author rory
 */
@Named(value = "contactoFormBean")
@RequestScoped
public class ContactoFormBean {

   private String nombre;
   private String contexto;
   private String contextoCliente;
   private HttpServletRequest httpServletRequest;
    /**
     * Creates a new instance of ContactoFormBean
     */
    public ContactoFormBean() {
        setContexto();
    }
    
       

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    
   
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
   
public String getSaludo(){
    return ResourcesUtil.getString("#{msg['app.saludo']}")  +nombre;
}

    public String getContexto() {
        return contexto;
    }

    public void setContexto() {
              
      //Locale de la palicacion
       this.contexto =  FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
       // this.contexto =httpServletRequest.getLocale().toString();
      
       
       //obtenemos el HttpServletRequest  de la peticion para poder saber
       // el locale del cliente
       HttpServletRequest requestObj = (HttpServletRequest)      
         FacesContext.getCurrentInstance().getExternalContext().getRequest();
       
       //Locale del cliente
       this.contextoCliente = requestObj.getLocale().toString();
       
       
       //Asignamos al locale de la aplicacion el locale del cliente
       FacesContext.getCurrentInstance().getViewRoot().setLocale(requestObj.getLocale());
    }

    public String getContextoCliente() {
        return contextoCliente;
    }



}
