
package com.wordpress.erenha.java.desktop.entry.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * Mahasiswa.java
 * @author Irfan Hidayat Amarulloh
 */
public class Mahasiswa implements Serializable {

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private String nim;
    public static final String PROP_NIM = "nim";
    private String nama;
    public static final String PROP_NAMA = "nama";
    private String jenisKelamin;
    public static final String PROP_JENISKELAMIN = "jenisKelamin";
    private String alamat;
    public static final String PROP_ALAMAT = "alamat";
    private String kelas;
    public static final String PROP_KELAS = "kelas";
    private String status;
    public static final String PROP_STATUS = "status";

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        String oldKelas = this.kelas;
        this.kelas = kelas;
        propertyChangeSupport.firePropertyChange(PROP_KELAS, oldKelas, kelas);
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        String oldAlamat = this.alamat;
        this.alamat = alamat;
        propertyChangeSupport.firePropertyChange(PROP_ALAMAT, oldAlamat, alamat);
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        String oldJenisKelamin = this.jenisKelamin;
        this.jenisKelamin = jenisKelamin;
        propertyChangeSupport.firePropertyChange(PROP_JENISKELAMIN, oldJenisKelamin, jenisKelamin);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        String oldNama = this.nama;
        this.nama = nama;
        propertyChangeSupport.firePropertyChange(PROP_NAMA, oldNama, nama);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        String oldNim = this.nim;
        this.nim = nim;
        propertyChangeSupport.firePropertyChange(PROP_NIM, oldNim, nim);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        propertyChangeSupport.firePropertyChange(PROP_STATUS, oldStatus, status);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
