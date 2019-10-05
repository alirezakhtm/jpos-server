package ir.navaco.mcb.jpos.camel;

import java.io.Serializable;

/**
 *
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class User {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
