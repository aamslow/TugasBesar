
package com.wordpress.erenha.java.desktop.entry.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * UserLogin.java
 * @author Irfan Hidayat Amarulloh
 */
public class UserLogin implements Serializable {

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private String username;
    public static final String PROP_USERNAME = "username";
    private String password;
    public static final String PROP_PASSWORD = "password";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        propertyChangeSupport.firePropertyChange(PROP_PASSWORD, oldPassword, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        propertyChangeSupport.firePropertyChange(PROP_USERNAME, oldUsername, username);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
