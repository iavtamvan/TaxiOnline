package id.can.web.taxionline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by CAN Creative on 30/05/2018.
 */

public class HistoryPoinModel {
    @SerializedName("HP_ID")
    @Expose
    private String hPID;
    @SerializedName("HP_USER_ID")
    @Expose
    private String hPUSERID;
    @SerializedName("HP_POIN_USER")
    @Expose
    private String hPPOINUSER;
    @SerializedName("HP_ITEM_POIN")
    @Expose
    private String hPITEMPOIN;
    @SerializedName("HP_ORDER_ID")
    @Expose
    private String hPORDERID;
    @SerializedName("TP_SYS_CREATED_AT")
    @Expose
    private String tPSYSCREATEDAT;
    @SerializedName("TP_SYS_UPDATED_AT")
    @Expose
    private String tPSYSUPDATEDAT;

    public String getHPID() {
        return hPID;
    }

    public void setHPID(String hPID) {
        this.hPID = hPID;
    }

    public String getHPUSERID() {
        return hPUSERID;
    }

    public void setHPUSERID(String hPUSERID) {
        this.hPUSERID = hPUSERID;
    }

    public String getHPPOINUSER() {
        return hPPOINUSER;
    }

    public void setHPPOINUSER(String hPPOINUSER) {
        this.hPPOINUSER = hPPOINUSER;
    }

    public String getHPITEMPOIN() {
        return hPITEMPOIN;
    }

    public void setHPITEMPOIN(String hPITEMPOIN) {
        this.hPITEMPOIN = hPITEMPOIN;
    }

    public String getHPORDERID() {
        return hPORDERID;
    }

    public void setHPORDERID(String hPORDERID) {
        this.hPORDERID = hPORDERID;
    }

    public String getTPSYSCREATEDAT() {
        return tPSYSCREATEDAT;
    }

    public void setTPSYSCREATEDAT(String tPSYSCREATEDAT) {
        this.tPSYSCREATEDAT = tPSYSCREATEDAT;
    }

    public String getTPSYSUPDATEDAT() {
        return tPSYSUPDATEDAT;
    }

    public void setTPSYSUPDATEDAT(String tPSYSUPDATEDAT) {
        this.tPSYSUPDATEDAT = tPSYSUPDATEDAT;
    }

}
