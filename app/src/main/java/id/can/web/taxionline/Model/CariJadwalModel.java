package id.can.web.taxionline.Model;

import com.google.gson.annotations.SerializedName;

public class CariJadwalModel{

	@SerializedName("kota_tujuan")
	private String kotaTujuan;

	@SerializedName("rute")
	private String rute;

	@SerializedName("jam_berangkat_awal")
	private String jamBerangkatAwal;

	@SerializedName("tarif_infane")
	private int tarifInfane;

	@SerializedName("error")
	private boolean error;

	@SerializedName("perusahaan_nama")
	private String perusahaanNama;

	@SerializedName("kota_awal_id")
	private String kotaAwalId;

	@SerializedName("kota_tujuan_id")
	private String kotaTujuanId;

	@SerializedName("kota_awal")
	private String kotaAwal;

	@SerializedName("perjalanan_tanggal")
	private String perjalananTanggal;

	@SerializedName("jumlah_pesan")
	private String jumlahPesan;

	@SerializedName("perusahaan_id")
	private String perusahaanId;

	@SerializedName("jam_berangkat_akhir")
	private String jamBerangkatAkhir;

	@SerializedName("harga_awal")
	private String hargaAwal;

	@SerializedName("total_jam_perjalan")
	private String totalJamPerjalan;

	@SerializedName("jumlah_bayar")
	private String jumlahBayar;

	public void setKotaTujuan(String kotaTujuan){
		this.kotaTujuan = kotaTujuan;
	}

	public String getKotaTujuan(){
		return kotaTujuan;
	}

	public void setRute(String rute){
		this.rute = rute;
	}

	public String getRute(){
		return rute;
	}

	public void setJamBerangkatAwal(String jamBerangkatAwal){
		this.jamBerangkatAwal = jamBerangkatAwal;
	}

	public String getJamBerangkatAwal(){
		return jamBerangkatAwal;
	}

	public void setTarifInfane(int tarifInfane){
		this.tarifInfane = tarifInfane;
	}

	public int getTarifInfane(){
		return tarifInfane;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setPerusahaanNama(String perusahaanNama){
		this.perusahaanNama = perusahaanNama;
	}

	public String getPerusahaanNama(){
		return perusahaanNama;
	}

	public void setKotaAwalId(String kotaAwalId){
		this.kotaAwalId = kotaAwalId;
	}

	public String getKotaAwalId(){
		return kotaAwalId;
	}

	public void setKotaTujuanId(String kotaTujuanId){
		this.kotaTujuanId = kotaTujuanId;
	}

	public String getKotaTujuanId(){
		return kotaTujuanId;
	}

	public void setKotaAwal(String kotaAwal){
		this.kotaAwal = kotaAwal;
	}

	public String getKotaAwal(){
		return kotaAwal;
	}

	public void setPerjalananTanggal(String perjalananTanggal){
		this.perjalananTanggal = perjalananTanggal;
	}

	public String getPerjalananTanggal(){
		return perjalananTanggal;
	}

	public void setJumlahPesan(String jumlahPesan){
		this.jumlahPesan = jumlahPesan;
	}

	public String getJumlahPesan(){
		return jumlahPesan;
	}

	public void setPerusahaanId(String perusahaanId){
		this.perusahaanId = perusahaanId;
	}

	public String getPerusahaanId(){
		return perusahaanId;
	}

	public void setJamBerangkatAkhir(String jamBerangkatAkhir){
		this.jamBerangkatAkhir = jamBerangkatAkhir;
	}

	public String getJamBerangkatAkhir(){
		return jamBerangkatAkhir;
	}

	public void setHargaAwal(String hargaAwal){
		this.hargaAwal = hargaAwal;
	}

	public String getHargaAwal(){
		return hargaAwal;
	}

	public void setTotalJamPerjalan(String totalJamPerjalan){
		this.totalJamPerjalan = totalJamPerjalan;
	}

	public String getTotalJamPerjalan(){
		return totalJamPerjalan;
	}

	public void setJumlahBayar(String jumlahBayar){
		this.jumlahBayar = jumlahBayar;
	}

	public String getJumlahBayar(){
		return jumlahBayar;
	}
}