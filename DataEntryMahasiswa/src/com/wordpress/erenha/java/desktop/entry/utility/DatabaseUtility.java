
package com.wordpress.erenha.java.desktop.entry.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseUtility.java
 * Class yang digunakan untuk membuat koneksi ke database
 * @author Irfan Hidayat Amarulloh
 */
public class DatabaseUtility {

    private static Connection connection;
    //driver mysql
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    //mysql url pattern = jdbc:mysql://nama_db_server:db_port/nama_db 
    private static final String DB_URL = "jdbc:mysql://localhost:3306/data_entry_mahasiswa";
    //database user default 'root'
    private static final String USER = "root";
    //no password
    private static final String PASSWORD = "";

    /**
     * Membuat koneksi ke database sesuai dengan nilai dari 
     * final atribut class ini e.g. USER = "root"
     * @return koneksi yang berhasil dibuat
     * @throws SQLException jika koneksi gagal dibuat
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                //load driver
                Class.forName(DB_DRIVER).newInstance();
                //koneksi ke database
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            } catch (InstantiationException ex) {
                System.out.println(ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return connection;
    }
}
