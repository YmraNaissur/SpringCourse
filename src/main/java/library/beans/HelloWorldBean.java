package library.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * naissur
 * 15.09.2017
 */

@ManagedBean(name = "helloWorld")
@SessionScoped
public class HelloWorldBean implements Serializable {
    private String s1 = "Hello, my dear friend!";

    public String getS1() {
        System.out.println(s1);
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }
}