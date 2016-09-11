package validators;

import classes.SuperClass;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author pj
 */
class SuperValidator extends SuperClass {

    protected FacesContext fc;
    protected UIComponent uic;

    public SuperValidator() {
        super();
    }
    
    protected void errorSet(String message) {
        fc.addMessage(uic.getClientId(fc), new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
    }
}
