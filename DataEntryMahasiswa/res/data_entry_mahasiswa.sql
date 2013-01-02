-- tabel user login
CREATE TABLE user_login (
    username VARCHAR(30) NOT NULL,
    password VARCHAR(32) NOT NULL,
    PRIMARY KEY (username)
)ENGINE=INNODB;

-- tabel mahasiswa
CREATE TABLE mahasiswa (
    nim CHAR(7) NOT NULL,
    nama VARCHAR(30) NOT NULL,
    jenis_kelamin ENUM("Laki-laki", "Perempuan"),
    alamat VARCHAR(50),
    kelas VARCHAR(4),
    status ENUM("Ikatan Dinas", "Tugas Belajar"),
    PRIMARY KEY (nim)
)ENGINE=INNODB;

-- asumsi: yang bisa masuk hanya admin
-- password dienkrip menggunakan MD5
INSERT INTO user_login VALUES("admin", MD5("admin"));