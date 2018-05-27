package id.can.web.taxionline.Model;

import com.google.gson.annotations.SerializedName;

public class KotaTujuanModel {

    @SerializedName("kota_tujuan_nama")
    private String kotaTujuanNama;

    @SerializedName("bigId")
    private String bigId;

    @SerializedName("kota_tujuan_id")
    private String kotaTujuanId;

    public void setKotaTujuanNama(String kotaTujuanNama) {
        this.kotaTujuanNama = kotaTujuanNama;
    }

    public String getKotaTujuanNama() {
        return kotaTujuanNama;
    }

    public void setBigId(String bigId) {
        this.bigId = bigId;
    }

    public String getBigId() {
        return bigId;
    }

    public void setKotaTujuanId(String kotaTujuanId) {
        this.kotaTujuanId = kotaTujuanId;
    }

    public String getKotaTujuanId() {
        return kotaTujuanId;
    }
}