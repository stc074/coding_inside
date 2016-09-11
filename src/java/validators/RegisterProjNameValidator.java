package validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author pj
 */
@FacesValidator("registerProjNameValidator")
public class RegisterProjNameValidator extends SuperValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        this.fc = fc;
        this.uic = uic;
        String lastname = (String) o;
        
        if(lastname==null) {
            errorSet("Champ nul");
        } else if(!lastname.isEmpty()) {
            if(lastname.length()>100) {
                errorSet("Champ trop long");
            }
        }
    }
}
