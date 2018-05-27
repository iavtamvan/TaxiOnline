package id.can.web.taxionline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CallCenterModel{

	@SerializedName("msg")
	@Expose
	private String msg;

	@SerializedName("telpon")
	@Expose
	private String telpon;

	@SerializedName("alamat_office")
	@Expose
	private String alamatOffice;

	@SerializedName("website")
	@Expose
	private String website;

	@SerializedName("facebook")
	@Expose
	private String facebook;

	@SerializedName("instagram")
	@Expose
	private String instagram;

	@SerializedName("error")
	@Expose
	private boolean error;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setTelpon(String telpon){
		this.telpon = telpon;
	}

	public String getTelpon(){
		return telpon;
	}

	public void setAlamatOffice(String alamatOffice){
		this.alamatOffice = alamatOffice;
	}

	public String getAlamatOffice(){
		return alamatOffice;
	}

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setFacebook(String facebook){
		this.facebook = facebook;
	}

	public String getFacebook(){
		return facebook;
	}

	public void setInstagram(String instagram){
		this.instagram = instagram;
	}

	public String getInstagram(){
		return instagram;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}
}