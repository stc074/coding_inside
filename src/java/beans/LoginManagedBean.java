/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pj
 */
@ManagedBean
@RequestScoped
public class LoginManagedBean extends User {

    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
        super();
    }
    
    public void validate() {
        
    }
}
