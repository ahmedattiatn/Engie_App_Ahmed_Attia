package ahmedattia.engieapplicationbyahmedatia.model;

/**
 * Created by Ahmed Attia on 06/05/2017.
 */

public class User {
    private String mail;
    private String id;

    public User(String mail, String id) {
        this.mail = mail;
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
}
