
package com.wordpress.erenha.java.desktop.entry.controller;

import com.wordpress.erenha.java.desktop.entry.dao.UserLoginDao;
import com.wordpress.erenha.java.desktop.entry.dao.impl.UserLoginDaoImpl;
import com.wordpress.erenha.java.desktop.entry.model.UserLogin;
import com.wordpress.erenha.java.desktop.entry.utility.CardLayoutUtility;
import com.wordpress.erenha.java.desktop.entry.utility.Message;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * LoginController.java
 * @author Irfan Hidayat Amarulloh
 */
public class LoginController {

    private UserLogin userLogin;

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * Method ini akan dipanggil ketika button login diklik.
     */
    public void login() {
        String username = userLogin.getUsername();
        String password = userLogin.getPassword();
        if (username.isEmpty()) {
            Message.errorMessage("Username masih kosong");
        } else if (password.isEmpty()) {
            Message.errorMessage("Password masih kosong");
        } else {
            UserLoginDao loginDao = new UserLoginDaoImpl();
            boolean isValid;
            try {
                isValid = loginDao.getUserLogin(username, password);
                if (isValid) {
                    //masuk ke panel entry jika data username dan password sesuai
                    CardLayoutUtility.next(); 
                } else {
                    //jika username dan password tidak sesuai muncul pesan ini
                    Message.errorMessage("Username dan password tidak cocok");
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
