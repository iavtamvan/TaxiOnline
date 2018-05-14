package id.can.web.taxionline.Model;

/**
 * Created by canc on 4/16/2018.
 */

public class OperatorTaxiModel {

    private String namaOperator;

    private String jamBerangkat;

    private String estimasiPerjalanan;

    private String hargaTiket;

    public OperatorTaxiModel(String namaOperator, String jamBerangkat, String estimasiPerjalanan, String hargaTiket) {
        this.namaOperator = namaOperator;
        this.jamBerangkat = jamBerangkat;
        this.estimasiPerjalanan = estimasiPerjalanan;
        this.hargaTiket = hargaTiket;
    }


    public String getNamaOperator() {
        return namaOperator;
    }

    public void setNamaOperator(String namaOperator) {
        this.namaOperator = namaOperator;
    }

    public String getJamBerangkat() {
        return jamBerangkat;
    }

    public void setJamBerangkat(String jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    public String getEstimasiPerjalanan() {
        return estimasiPerjalanan;
    }

    public void setEstimasiPerjalanan(String estimasiPerjalanan) {
        this.estimasiPerjalanan = estimasiPerjalanan;
    }

    public String getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(String hargaTiket) {
        this.hargaTiket = hargaTiket;
    }
}
