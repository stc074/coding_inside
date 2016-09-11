/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
@FacesValidator("registerProjPhoneValidator")
public class RegisterProjPhoneValidator extends SuperValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        this.fc = fc;
        this.uic = uic;
        String phone = (String) o;
        
        if(phone==null) {
            errorSet("Champ nul");
        } else if(!phone.isEmpty()) {
            if(phone.length()>14) {
                errorSet("Champ trop long");
            }
        }
    }
}
