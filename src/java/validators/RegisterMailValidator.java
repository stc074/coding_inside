package validators;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author pj
 */
@FacesValidator("registerMailValidator")
public class RegisterMailValidator extends SuperValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        this.fc = fc;
        this.uic = uic;
        String mailAddy = (String) o;

        EmailValidator emailValidator = EmailValidator.getInstance();

        if (mailAddy == null) {
            errorSet("Champ nul");
        } else if (mailAddy.isEmpty()) {
            errorSet("Champ vide");
        } else if (mailAddy.length() > 100) {
            errorSet("Champ trop long");
        } else if (!emailValidator.isValid(mailAddy)) {
            errorSet("Champ non valide");
        } else if (exists(mailAddy)) {
            errorSet("Adresse déjà enregistrée");
        }

    }

    private boolean exists(String mailAddy) {
        boolean flag = false;
        try {
            String query = "SELECT COUNT(id) AS nb FROM users_project WHERE mail_address=?";
            PreparedStatement prepare = con.prepareStatement(query);
            prepare.setString(1, mailAddy);
            ResultSet result=prepare.executeQuery();
            if(result.next()) {
                int nb=result.getInt("nb");
                if(nb!=0) {
                    flag=true;
                }
            } else {
                errorSet("Erreur interne");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterMailValidator.class.getName()).log(Level.SEVERE, null, ex);
            errorSet("Erreur interne");
            flag=false;
        }
        return flag;
    }
}
