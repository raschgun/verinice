package sernet.verinice.web;

import java.util.Locale;

import javax.faces.context.FacesContext;

import sernet.gs.web.Util;

/**
 * ManagedBean to show error and info messages.
 * 
 * @author Daniel Murygin <dm[at]sernet[dot]de>
 */
public class MessageBean {

    private String info;
    
    private String error;
    
    private Locale locale = null;

    public void showInfo() {
        Util.addInfo("massagePanel", getInfo()); //$NON-NLS-1$
        setInfo(null);
    }
    
    public void showError() {
        Util.addError("massagePanel", getError()); //$NON-NLS-1$
        setError(null);
    }
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String message) {
        this.info = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public void repeat() {
        Util.repeatMessage();
    }
    
    public void english() {
        setLocale(Locale.ENGLISH);
    }
    
    public void german() {
        setLocale(Locale.GERMAN);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(locale);
    }

    public Locale getLocale() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (locale == null) {
            locale = context.getViewRoot().getLocale();
        } else {
            context.getViewRoot().setLocale(locale);
        }
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public String getcurrentLanguageTag() {
        return Util.getcurrentLanguageTag();
    }


}
