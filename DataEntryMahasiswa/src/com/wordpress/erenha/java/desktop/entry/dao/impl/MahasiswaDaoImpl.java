
package com.wordpress.erenha.java.desktop.entry.dao.impl;

import com.wordpress.erenha.java.desktop.entry.dao.MahasiswaDao;
import com.wordpress.erenha.java.desktop.entry.model.Mahasiswa;
import com.wordpress.erenha.java.desktop.entry.utility.DatabaseUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MahasiswaDaoImpl.java
 * Implementasi dari interface MahasiswaDao 
 * @author Irfan Hidayat Amarulloh
 */
public class MahasiswaDaoImpl implements MahasiswaDao {

    private Connection connection;
    private final String insertQuery =
            "INSERT INTO mahasiswa VALUES (?,?,?,?,?,?)";
    private final String updateQuery =
            "UPDATE mahasiswa SET nama = ?, jenis_kelamin = ?, "
            + "alamat = ?, kelas = ?, status = ? WHERE nim = ?";
    private final String deleteQuery =
            "DELETE from mahasiswa WHERE nim = ?";
    private final String getByNimQuery =
            "SELECT * FROM mahasiswa WHERE nim = ?";

    @Override
    public void insert(Mahasiswa mahasiswa) throws Exception {
        PreparedStatement statement = null;
        try {
            connection = DatabaseUtility.getConnection();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(insertQuery);
            statement.setString(1, mahasiswa.getNim());
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getJenisKelamin());
            statement.setString(4, mahasiswa.getAlamat());
            statement.setString(5, mahasiswa.getKelas());
            statement.setString(6, mahasiswa.getStatus());
            statement.execute();

            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(true);
            if (statement != null) {
                statement.close();
            }
        }
    }

    @Override
    public void update(Mahasiswa mahasiswa) throws Exception {
        PreparedStatement statement = null;
        try {
            connection = DatabaseUtility.getConnection();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(updateQuery);
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getJenisKelamin());
            statement.setString(3, mahasiswa.getAlamat());
            statement.setString(4, mahasiswa.getKelas());
            statement.setString(5, mahasiswa.getStatus());
            statement.setString(6, mahasiswa.getNim());
            statement.execute();

            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(true);
            if (statement != null) {
                statement.close();
            }
        }
    }

    @Override
    public void delete(String nim) throws Exception {
        PreparedStatement statement = null;
        try {
            connection = DatabaseUtility.getConnection();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(deleteQuery);
            statement.setString(1, nim);
            statement.execute();

            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(true);
            if (statement != null) {
                statement.close();
            }
        }
    }

    @Override
    public Mahasiswa getByNim(String nim) throws Exception {
        PreparedStatement statement = null;
        try {
            connection = DatabaseUtility.getConnection();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(getByNimQuery);
            statement.setString(1, nim);
            ResultSet resultSet = statement.executeQuery();
            Mahasiswa mahasiswa = null;
            if (resultSet.next()) {
                mahasiswa = new Mahasiswa();
                mahasiswa.setNim(resultSet.getString("nim"));
                mahasiswa.setNama(resultSet.getString("nama"));
                mahasiswa.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                mahasiswa.setAlamat(resultSet.getString("alamat"));
                mahasiswa.setKelas(resultSet.getString("kelas"));
                mahasiswa.setStatus(resultSet.getString("status"));
            }
            connection.commit();
            return mahasiswa;
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(true);
            if (statement != null) {
                statement.close();
            }
        }
    }
}
