package id.can.web.taxionline.Model;

import com.google.gson.annotations.SerializedName;

public class LoginResponseModel{

	@SerializedName("telpon")
	private String telpon;

	@SerializedName("login_waktu")
	private String loginWaktu;

	@SerializedName("login_fb")
	private Object loginFb;

	@SerializedName("login_google")
	private Object loginGoogle;

	@SerializedName("device_id")
	private String deviceId;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("avatar_path")
	private Object avatarPath;

	@SerializedName("rule")
	private String rule;

	@SerializedName("login_token")
	private String loginToken;

	@SerializedName("nama_user")
	private String namaUser;

	@SerializedName("error")
	private boolean error;

	@SerializedName("email")
	private String email;

	public void setTelpon(String telpon){
		this.telpon = telpon;
	}

	public String getTelpon(){
		return telpon;
	}

	public void setLoginWaktu(String loginWaktu){
		this.loginWaktu = loginWaktu;
	}

	public String getLoginWaktu(){
		return loginWaktu;
	}

	public void setLoginFb(Object loginFb){
		this.loginFb = loginFb;
	}

	public Object getLoginFb(){
		return loginFb;
	}

	public void setLoginGoogle(Object loginGoogle){
		this.loginGoogle = loginGoogle;
	}

	public Object getLoginGoogle(){
		return loginGoogle;
	}

	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;
	}

	public String getDeviceId(){
		return deviceId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setAvatarPath(Object avatarPath){
		this.avatarPath = avatarPath;
	}

	public Object getAvatarPath(){
		return avatarPath;
	}

	public void setRule(String rule){
		this.rule = rule;
	}

	public String getRule(){
		return rule;
	}

	public void setLoginToken(String loginToken){
		this.loginToken = loginToken;
	}

	public String getLoginToken(){
		return loginToken;
	}

	public void setNamaUser(String namaUser){
		this.namaUser = namaUser;
	}

	public String getNamaUser(){
		return namaUser;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}