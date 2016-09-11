package beans;

import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author pj
 */
@ManagedBean
@ApplicationScoped
public class DatasManagedBean {
    
    
    final private String URL_ROOT="http://www.coding-inside.com";
    private String ACTUAL_YEAR="";


    /**
     * Creates a new instance of DatasManagedBean
     */
    public DatasManagedBean() {
    }
    
    /**
     * @return the URL_ROOT
     */
    public String getURL_ROOT() {
        return URL_ROOT;
    }
    
    /**
     * @return the ACTUAL_YEAR
     */
    public String getACTUAL_YEAR() {
        Calendar cal=Calendar.getInstance();
        ACTUAL_YEAR=""+cal.get(Calendar.YEAR);
        return ACTUAL_YEAR;
    }


}
