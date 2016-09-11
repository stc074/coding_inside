package beans;

import classes.Project;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pj
 */
@ManagedBean
@RequestScoped
public class RecProjectManagedBean extends Project {

    /**
     * Creates a new instance of RecProjectManagedBean
     */
    public RecProjectManagedBean()  {
        super();
    }
}
