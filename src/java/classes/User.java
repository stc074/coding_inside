package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pj
 */
public class User extends SuperClass {

    protected int id = 0;
    protected String nickname = "";
    protected String pass = "";
    protected String confirmPass = "";
    protected String mailAddress = "";
    protected String lastname = "";
    protected String firstname = "";
    protected String phone = "";
    protected String sirenNumber = "";
    protected long tstp = 0;

    public User() {
        super();
        id = 0;
        if (session.getAttribute("id") != null) {
            id = Integer.parseInt(session.getAttribute("id").toString());
        }
    }

    public boolean isNicknameExists(String nickname) throws SQLException {
        boolean flag = false;
        String query = "SELECT COUNT(id) AS nb FROM users WHERE nickname=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1, nickname);
        ResultSet result = prepare.executeQuery();
        if (result.next()) {
            int nb = result.getInt("nb");
            if (nb != 0) {
                flag = true;
            }
        }
        result.close();
        prepare.close();
        return flag;
    }

    @Override
    protected void blank() {
        super.blank();
        nickname = "";
        pass = "";
        confirmPass = "";
        mailAddress = "";
        lastname = "";
        firstname = "";
        phone = "";
        sirenNumber = "";
        tstp = 0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the confirmPass
     */
    public String getConfirmPass() {
        return confirmPass;
    }

    /**
     * @param confirmPass the confirmPass to set
     */
    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    /**
     * @return the mailAddress
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * @param mailAddress the mailAddress to set
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the sirenNumber
     */
    public String getSirenNumber() {
        return sirenNumber;
    }

    /**
     * @param sirenNumber the sirenNumber to set
     */
    public void setSirenNumber(String sirenNumber) {
        this.sirenNumber = sirenNumber;
    }

    /**
     * @return the tstp
     */
    public long getTstp() {
        return tstp;
    }

    /**
     * @param tstp the tstp to set
     */
    public void setTstp(long tstp) {
        this.tstp = tstp;
    }
}
