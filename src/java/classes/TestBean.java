/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author pj
 */
@ManagedBean
@ApplicationScoped
public class TestBean implements Serializable {

    private DataSource ds=null;
    private Connection con=null;
    private String user_name="bad";
    private String user_pass="bad";
    private String errorMsg="";
    /**
     * Creates a new instance of TestBean
     */
    public TestBean() {
        try {
            Context ctx=new InitialContext();
            ds=(DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
            con=ds.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
            errorMsg+=ex.getMessage()+"<br/>";
        } catch (SQLException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
            errorMsg+=ex.getMessage()+"<br/>";
        }
    }
    
    public void test() {
        try {
            Statement statement=con.createStatement();
            String query="SELECT * FROM users";
            ResultSet result=statement.executeQuery(query);
            result.next();
            user_name=result.getString("user_name");
            user_pass=result.getString("user_pass");
        } catch (SQLException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
            errorMsg+=ex.getMessage()+"<br/>";
        }
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @return the user_pass
     */
    public String getUser_pass() {
        return user_pass;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }
}
