/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author pj
 */
@FacesValidator("registerPasswordValidator")
public class RegisterPasswordValidator extends SuperValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        this.fc = fc;
        this.uic = uic;
        String password = (String) o;

        Pattern pattern = Pattern.compile("^\\w+$");
        Matcher matcher = pattern.matcher(password);

        if (password == null) {
            errorSet("Champ nul");
        } else if (password.isEmpty()) {
            errorSet("Champ vide");
        } else if(password.length()<4) {
            errorSet("Champ trop court");
        } else if (password.length() > 15) {
            errorSet("Champ trop long");
        } else if (!matcher.matches()) {
            errorSet("Champ non valide (caractères alphanumériques)");
        }

        if (uic.getId().equals("password2")) {
            UIInput input = (UIInput) fc.getViewRoot().findComponent("form:password");
            String pw = (String) input.getValue();
            if(!pw.equals(password)) {
                errorSet("Les 2 mots de passes ne correspondent pas");
            }
        }
    }
}
