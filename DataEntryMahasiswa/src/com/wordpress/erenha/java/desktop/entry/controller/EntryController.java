
package com.wordpress.erenha.java.desktop.entry.controller;

import com.wordpress.erenha.java.desktop.entry.dao.MahasiswaDao;
import com.wordpress.erenha.java.desktop.entry.dao.impl.MahasiswaDaoImpl;
import com.wordpress.erenha.java.desktop.entry.model.Mahasiswa;
import com.wordpress.erenha.java.desktop.entry.utility.Message;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irfan Hidayat Amarulloh
 */
public class EntryController {

    private Mahasiswa mahasiswa;

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    /**
     * Method yang dipanggil ketika button insert diklik.
     */
    public void insert() {
        if (validasi()) {
            MahasiswaDao dao = new MahasiswaDaoImpl();
            try {
                dao.insert(mahasiswa);
                Message.infoMessage("Data berhasil diinsert");
                clear();
            } catch (Exception ex) {
                Logger.getLogger(EntryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Method yang dipanggil ketika button update diklik.
     */
    public void update() {
        if (validasi()) {
            MahasiswaDao dao = new MahasiswaDaoImpl();
            try {
                dao.update(mahasiswa);
                Message.infoMessage("Data berhasil diupdate");
                clear();
            } catch (Exception ex) {
                Logger.getLogger(EntryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Method yang dipanggil ketika button delete diklik.
     */
    public void delete() {
        MahasiswaDao dao = new MahasiswaDaoImpl();
        try {
            dao.delete(mahasiswa.getNim());
            Message.infoMessage("Data berhasil dihapus");
            clear();
        } catch (Exception ex) {
            Logger.getLogger(EntryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method yang dipanggil ketika button load diklik.
     */
    public void getByNim() {
        MahasiswaDao dao = new MahasiswaDaoImpl();
        System.out.println(mahasiswa.getNim());
        try {
            Mahasiswa m = dao.getByNim(mahasiswa.getNim());
            if (m != null) {
                mahasiswa.setNim(m.getNim());
                mahasiswa.setNama(m.getNama());
                mahasiswa.setJenisKelamin(m.getJenisKelamin());
                mahasiswa.setAlamat(m.getAlamat());
                mahasiswa.setKelas(m.getKelas());
                mahasiswa.setStatus(m.getStatus());
            } else {
                Message.errorMessage("Data tidak ditemukan");
            }
        } catch (Exception ex) {
            Logger.getLogger(EntryController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * ketika button new diklik, akan kembali ke default.
     * method ini juga dipanggil ketika insert/update/delete berhasil.
     */
    public void clear() {
        mahasiswa.setNim("");
        mahasiswa.setNama("");
        mahasiswa.setJenisKelamin("Laki-laki");
        mahasiswa.setAlamat("");
        mahasiswa.setKelas("");
        mahasiswa.setStatus("Pemrograman 3");
    }

    /**
     * Untuk validasi field.
     * @return false jika data tidak valid
     */
    public boolean validasi() {
        boolean isValid = false;
        if (mahasiswa.getNim().isEmpty() || mahasiswa.getNim() == null) {
            Message.errorMessage("NIM harus diisi");
        } else if (mahasiswa.getNama().isEmpty() || mahasiswa.getNama() == null) {
            Message.errorMessage("Nama harus diisi");
        } else if (mahasiswa.getJenisKelamin().isEmpty() || mahasiswa.getJenisKelamin() == null) {
            Message.errorMessage("Jenis Kelamin harus diisi");
        } else if (mahasiswa.getAlamat().isEmpty() || mahasiswa.getAlamat() == null) {
            Message.errorMessage("Alamat harus diisi");
        } else if (mahasiswa.getKelas().isEmpty() || mahasiswa.getKelas() == null) {
            Message.errorMessage("Kelas harus diisi");
        } else {
            isValid = true;
        }
        return isValid;
    }
}
