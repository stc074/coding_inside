package beans;

import classes.UserProj;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pj
 */
@ManagedBean
@RequestScoped
public class RegisterProjectManagedBean extends UserProj {

    /**
     * Creates a new instance of RegisterProjectManagedBean
     */
    public RegisterProjectManagedBean() {
        super();
    }

    public void validate() {
        try {
            String query = "INSERT INTO users_project (mail_address, nickname, last_name, first_name, pass, phone, siren_number, tstp) VALUES (?,?,?,?,md5(?),?,?, ?) RETURNING id";
            tstp = System.currentTimeMillis();
            PreparedStatement prepare = con.prepareStatement(query);
            prepare.setString(1, mailAddress);
            prepare.setString(2, nickname);
            prepare.setString(3, lastname);
            prepare.setString(4, firstname);
            prepare.setString(5, pass);
            prepare.setString(6, phone);
            prepare.setString(7, sirenNumber);
            prepare.setLong(8, tstp);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                id=result.getInt("id");
                session.setAttribute("id", id);
                blank();
                test = 1;
                try {
                    response.sendRedirect(response.encodeRedirectURL("creer-projet.html"));
                } catch (IOException ex) {
                    Logger.getLogger(RegisterProjectManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                    test=2;
                    errorMsg+="Erreur de redirection";
                }
            } else {
                test = 2;
                errorMsg += "Erreur SQL<br/>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterProjectManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            test = 2;
            errorMsg += ex.getMessage() + "<br/>";
        }
    }

    @Override
    protected void blank() {
        super.blank();
    }
}
