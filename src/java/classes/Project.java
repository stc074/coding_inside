package classes;

/**
 *
 * @author pj
 */
public class Project extends SuperClass {

    protected int idUser = 0;

    public Project() {
        super();
        idUser=0;
        if (session.getAttribute("id") != null) {
            idUser = Integer.parseInt(session.getAttribute("id").toString());
        }
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
