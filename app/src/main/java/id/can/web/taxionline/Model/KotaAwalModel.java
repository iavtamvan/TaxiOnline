package id.can.web.taxionline.Model;

import com.google.gson.annotations.SerializedName;

public class KotaAwalModel{

	@SerializedName("bigId")
	private String bigId;

	@SerializedName("kota_awal_nama")
	private String kotaAwalNama;

	@SerializedName("kota_awal_id")
	private String kotaAwalId;

	public void setBigId(String bigId){
		this.bigId = bigId;
	}

	public String getBigId(){
		return bigId;
	}

	public void setKotaAwalNama(String kotaAwalNama){
		this.kotaAwalNama = kotaAwalNama;
	}

	public String getKotaAwalNama(){
		return kotaAwalNama;
	}

	public void setKotaAwalId(String kotaAwalId){
		this.kotaAwalId = kotaAwalId;
	}

	public String getKotaAwalId(){
		return kotaAwalId;
	}
}