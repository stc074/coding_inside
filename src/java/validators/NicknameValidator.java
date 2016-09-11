package validators;

import classes.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author pj
 */
@FacesValidator("validators.NicknameValidator")		
public class NicknameValidator extends User implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        try {
            String nick=(String)o;
            Pattern pattern=Pattern.compile("^\\w+$");
            Matcher matcher=pattern.matcher(nick);
            
            if(nick==null) {
                fc.addMessage(uic.getClientId(fc), new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ nul", "Champ nul"));
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ nul", "Champ nul"));
            } else if(nick.isEmpty()) {
                fc.addMessage(uic.getClientId(fc), new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ vide", "Champ vide"));
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ vide", "Champ vide"));            
            } else if(nick.length()>100) {
                fc.addMessage(uic.getClientId(fc), new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ trop long", "Champ trop long"));
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ trop long", "Champ trop long"));                        
            } else if(!matcher.matches()) {
                fc.addMessage(uic.getClientId(fc), new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ non valide (Caractères alphanumériques)", "Champ non valide (Caractères alphanumériques)"));
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ non valide (Caractères alphanumériques)", "Champ non valide (Caractères alphanumériques)"));                
            } else if(!this.isNicknameExists(nick)) {
                fc.addMessage(uic.getClientId(fc), new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pseudonyme inconnu", "Pseudonyme inconnu"));
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pseudonyme inconnu", "Pseudonyme inconnu"));                                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(NicknameValidator.class.getName()).log(Level.SEVERE, null, ex);
                fc.addMessage(uic.getClientId(fc), new FacesMessage(FacesMessage.SEVERITY_ERROR, "SQL EXCEPTION", "SQL EXCEPTION"));
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "SQL EXCEPTION", "SQL EXCEPTION"));                        
        }
        
    }
    
}
