package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author pj
 */
@FacesValidator("registerProjSirenValidator")
public class RegisterProjSirenValidator extends SuperValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        this.fc = fc;
        this.uic = uic;
        String siren = (String) o;

        if (siren == null) {
            errorSet("Champ nul");
        } else if (!siren.isEmpty()) {
            if(siren.length()!=9) {
                errorSet("Numéro non valide");
            } else if (!isSiren(siren)) {
                errorSet("Numéro non valide");
            }
        }
    }

    private boolean isSiren(String number) {
        boolean flag;
        Pattern pattern = Pattern.compile("^[0-9]{9}$");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            flag = false;
        } else {
            //
            int sum = 0;
            for (int i = 8; i >= 0; i--) {
                int value = Integer.parseInt("" + number.charAt(i));
                if (((i + 1) % 2) == 0) {
                    value *= 2;
                }
                if (value >= 10) {
                    value -= 9;
                }
                sum += value;
            }
            flag = ((sum % 10) == 0);
        }
        return flag;
    }
}
