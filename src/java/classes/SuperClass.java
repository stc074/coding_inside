package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author pj
 */
public class SuperClass {

    protected int test = 0;
    protected String errorMsg = "";
    protected static Connection con = null;
    FacesContext facesContext;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    public SuperClass() {
        try {
            if (con == null) {
                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/postgres");
                con = ds.getConnection();
            }
        } catch (NamingException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
            errorMsg += "Impossible de créer le context: " + ex.getMessage() + "\n";
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
            errorMsg += "Impossible de se connecter : " + ex.getMessage();
        }
        facesContext = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        session = request.getSession(true);
    }

    protected void blank() {
        test = 0;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @return the test
     */
    public int getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(int test) {
        this.test = test;
    }
}
