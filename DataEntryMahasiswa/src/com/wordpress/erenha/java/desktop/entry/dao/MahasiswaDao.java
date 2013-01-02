
package com.wordpress.erenha.java.desktop.entry.dao;

import com.wordpress.erenha.java.desktop.entry.model.Mahasiswa;

/**
 * MahasiswaDao.java
 * Setidaknya ada 4 method yang dibutuhkan untuk akses tabel mahasiswa yaitu
 * insert, update, delete, dan getByNim
 * @author Irfan Hidayat Amarulloh
 */
public interface MahasiswaDao {

    public void insert(Mahasiswa mahasiswa) throws Exception;

    public void update(Mahasiswa mahasiswa) throws Exception;

    public void delete(String nim) throws Exception;

    public Mahasiswa getByNim(String nim) throws Exception;
}
