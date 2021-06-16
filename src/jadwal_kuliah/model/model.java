package jadwal_kuliah.model;

import javafx.beans.property.SimpleStringProperty;

public class model {
    public final SimpleStringProperty id_jadwal_kuliah;
    public final SimpleStringProperty matkul;
    public final SimpleStringProperty waktu;
    public final SimpleStringProperty gkb;
    public final SimpleStringProperty ruangan;
    public final SimpleStringProperty nama_dosen;

    public model (String fid_jadwal_kuliah, String fmatkul, String fwaktu, String fgkb, String fruangan, String fnama_dosen){
        this.id_jadwal_kuliah = new SimpleStringProperty(fid_jadwal_kuliah);
        this.matkul = new SimpleStringProperty(fmatkul);
        this.waktu = new SimpleStringProperty(fwaktu);
        this.gkb = new SimpleStringProperty(fgkb);
        this.ruangan = new SimpleStringProperty(fruangan);
        this.nama_dosen = new SimpleStringProperty(fnama_dosen);
    }


    public String getid_jadwal_kuliah() {
        return id_jadwal_kuliah.get();
    }

    public void setid_jadwal_kuliah(String value) {
        id_jadwal_kuliah.set(value);
    }


    public String getmatkul() {
        return matkul.get();
    }

    public void setmatkul(String value) {
        matkul.set(value);
    }


    public String getwaktu() {
        return waktu.get();
    }

    public void setwaktu(String value) {
        waktu.set(value);
    }


    public String getgkb() {
        return gkb.get();
    }

    public void setgkb(String value) {
        gkb.set(value);
    }

    public String getruangan() {
        return ruangan.get();
    }

    public void setruangan(String value) {
        ruangan.set(value);
    }

    public String getnama_dosen() {
        return nama_dosen.get();
    }

    public void setnama_dosen(String value) {
        nama_dosen.set(value);
    }
}
