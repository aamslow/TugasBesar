
package com.wordpress.erenha.java.desktop.entry.dao;

/**
 * UserLoginDao.java
 * Interface ini hanya punya satu method yaitu getUserLogin yang digunakan
 * untuk mengambil data username dan password dari database.
 * @author Irfan Hidayat Amarulloh
 */
public interface UserLoginDao {
    public boolean getUserLogin(String username, String password) throws Exception;
}
