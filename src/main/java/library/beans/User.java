package library.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * naissur
 * 15.09.2017
 */

@ManagedBean(name="user")
@SessionScoped
public class User implements Serializable {
    private String userName;

    public User() {
        // Конструктор по умолчанию
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
