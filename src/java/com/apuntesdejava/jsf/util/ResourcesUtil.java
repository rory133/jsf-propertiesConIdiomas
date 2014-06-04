package com.apuntesdejava.jsf.util;
 
import javax.faces.context.FacesContext;
 
 
public class ResourcesUtil {
 
    public static String getString(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        String value = context.getApplication().evaluateExpressionGet(context, key, String.class);
         
        return value;
    }
}
