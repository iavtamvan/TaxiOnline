package id.can.web.taxionline.Model;

import com.google.gson.annotations.SerializedName;

public class BankModel{

	@SerializedName("TB_BIGID")
	private String tBBIGID;

	@SerializedName("TB_REKENING_NOMOR")
	private String tBREKENINGNOMOR;

	@SerializedName("TB_BANK_AVATAR")
	private String tBBANKAVATAR;

	@SerializedName("TB_BANK_NAMA")
	private String tBBANKNAMA;

	@SerializedName("TB_REKENING_NAMA")
	private String tBREKENINGNAMA;

	@SerializedName("TB_BANK_STATUS")
	private String tBBANKSTATUS;

	@SerializedName("TB_BANK_ID")
	private String tBBANKID;

	public void setTBBIGID(String tBBIGID){
		this.tBBIGID = tBBIGID;
	}

	public String getTBBIGID(){
		return tBBIGID;
	}

	public void setTBREKENINGNOMOR(String tBREKENINGNOMOR){
		this.tBREKENINGNOMOR = tBREKENINGNOMOR;
	}

	public String getTBREKENINGNOMOR(){
		return tBREKENINGNOMOR;
	}

	public void setTBBANKAVATAR(String tBBANKAVATAR){
		this.tBBANKAVATAR = tBBANKAVATAR;
	}

	public String getTBBANKAVATAR(){
		return tBBANKAVATAR;
	}

	public void setTBBANKNAMA(String tBBANKNAMA){
		this.tBBANKNAMA = tBBANKNAMA;
	}

	public String getTBBANKNAMA(){
		return tBBANKNAMA;
	}

	public void setTBREKENINGNAMA(String tBREKENINGNAMA){
		this.tBREKENINGNAMA = tBREKENINGNAMA;
	}

	public String getTBREKENINGNAMA(){
		return tBREKENINGNAMA;
	}

	public void setTBBANKSTATUS(String tBBANKSTATUS){
		this.tBBANKSTATUS = tBBANKSTATUS;
	}

	public String getTBBANKSTATUS(){
		return tBBANKSTATUS;
	}

	public void setTBBANKID(String tBBANKID){
		this.tBBANKID = tBBANKID;
	}

	public String getTBBANKID(){
		return tBBANKID;
	}
}