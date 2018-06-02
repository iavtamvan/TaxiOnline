package id.can.web.taxionline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by CAN Creative on 29/05/2018.
 */

public class HistoryOrderModel {
    @SerializedName("TO_ORDER_ID")
    @Expose
    private String tOORDERID;
    @SerializedName("TO_COST_ID")
    @Expose
    private String tOCOSTID;
    @SerializedName("TO_COST_NIK")
    @Expose
    private String toCOSTNIK;
    @SerializedName("TO_BOOKING_KURSI")
    @Expose
    private String toBOOKINGKURSI;
    @SerializedName("TO_COST_NAMA")
    @Expose
    private String tOCOSTNAMA;
    @SerializedName("TO_COST_TELPON")
    @Expose
    private String tOCOSTTELPON;
    @SerializedName("TO_COST_EMAIL")
    @Expose
    private String tOCOSTEMAIL;
    @SerializedName("TO_COST_ALAMAT")
    @Expose
    private String tOCOSTALAMAT;
    @SerializedName("TO_DRIVER_ID")
    @Expose
    private String tODRIVERID;
    @SerializedName("TO_DRIVER_NAMA")
    @Expose
    private String tODRIVERNAMA;
    @SerializedName("TO_ARMADA_ID")
    @Expose
    private String tOARMADAID;
    @SerializedName("TO_ARMADA_NOPOL")
    @Expose
    private String tOARMADANOPOL;
    @SerializedName("TO_ARMADA_NAMA")
    @Expose
    private String tOARMADANAMA;
    @SerializedName("TO_ARMADA_MERK")
    @Expose
    private String tOARMADAMERK;
    @SerializedName("TO_KA_ID")
    @Expose
    private String tOKAID;
    @SerializedName("TO_KA_NAMA")
    @Expose
    private String tOKANAMA;
    @SerializedName("TO_TARIF_AWAL")
    @Expose
    private String tOTARIFAWAL;
    @SerializedName("TO_KT_ID")
    @Expose
    private String tOKTID;
    @SerializedName("TO_KT_NAMA")
    @Expose
    private String tOKTNAMA;
    @SerializedName("TO_TARIF_AKHIR")
    @Expose
    private String tOTARIFAKHIR;
    @SerializedName("TO_SUB_TOTAL")
    @Expose
    private String tOSUBTOTAL;
    @SerializedName("TO_PAYMENT_BY")
    @Expose
    private String tOPAYMENTBY;
    @SerializedName("TO_NO_VERIF_TIKET")
    @Expose
    private String tONOVERIFTIKET;
    @SerializedName("TO_STATUS")
    @Expose
    private String tOSTATUS;
    @SerializedName("TO_CREATED_COST")
    @Expose
    private String tOCREATEDCOST;
    @SerializedName("TO_UPDATED_DRIVER")
    @Expose
    private Object tOUPDATEDDRIVER;
    @SerializedName("TO_BOOKING_TGL")
    @Expose
    private String tOBOOKINGTGL;
    @SerializedName("TO_BOOKING_START")
    @Expose
    private String tOBOOKINGSTART;
    @SerializedName("TO_BOOKING_END")
    @Expose
    private String tOBOOKINGEND;
    @SerializedName("TO_SYS_CREATED_AT")
    @Expose
    private String tOSYSCREATEDAT;
    @SerializedName("TO_SYS_UPDATED_AT")
    @Expose
    private String tOSYSUPDATEDAT;

    public String getTOORDERID() {
        return tOORDERID;
    }

    public void setTOORDERID(String tOORDERID) {
        this.tOORDERID = tOORDERID;
    }

    public String getTOCOSTID() {
        return tOCOSTID;
    }

    public void setTOCOSTID(String tOCOSTID) {
        this.tOCOSTID = tOCOSTID;
    }

    public String getTOCOSTNAMA() {
        return tOCOSTNAMA;
    }

    public void setTOCOSTNAMA(String tOCOSTNAMA) {
        this.tOCOSTNAMA = tOCOSTNAMA;
    }

    public String getTOCOSTTELPON() {
        return tOCOSTTELPON;
    }

    public void setTOCOSTTELPON(String tOCOSTTELPON) {
        this.tOCOSTTELPON = tOCOSTTELPON;
    }

    public String getTOCOSTEMAIL() {
        return tOCOSTEMAIL;
    }

    public void setTOCOSTEMAIL(String tOCOSTEMAIL) {
        this.tOCOSTEMAIL = tOCOSTEMAIL;
    }

    public String getTOCOSTALAMAT() {
        return tOCOSTALAMAT;
    }

    public void setTOCOSTALAMAT(String tOCOSTALAMAT) {
        this.tOCOSTALAMAT = tOCOSTALAMAT;
    }

    public String getTODRIVERID() {
        return tODRIVERID;
    }

    public void setTODRIVERID(String tODRIVERID) {
        this.tODRIVERID = tODRIVERID;
    }

    public String getTODRIVERNAMA() {
        return tODRIVERNAMA;
    }

    public void setTODRIVERNAMA(String tODRIVERNAMA) {
        this.tODRIVERNAMA = tODRIVERNAMA;
    }

    public String getTOARMADAID() {
        return tOARMADAID;
    }

    public void setTOARMADAID(String tOARMADAID) {
        this.tOARMADAID = tOARMADAID;
    }

    public String getTOARMADANOPOL() {
        return tOARMADANOPOL;
    }

    public void setTOARMADANOPOL(String tOARMADANOPOL) {
        this.tOARMADANOPOL = tOARMADANOPOL;
    }

    public String getTOARMADANAMA() {
        return tOARMADANAMA;
    }

    public void setTOARMADANAMA(String tOARMADANAMA) {
        this.tOARMADANAMA = tOARMADANAMA;
    }

    public String getTOARMADAMERK() {
        return tOARMADAMERK;
    }

    public void setTOARMADAMERK(String tOARMADAMERK) {
        this.tOARMADAMERK = tOARMADAMERK;
    }

    public String getTOKAID() {
        return tOKAID;
    }

    public void setTOKAID(String tOKAID) {
        this.tOKAID = tOKAID;
    }

    public String getTOKANAMA() {
        return tOKANAMA;
    }

    public void setTOKANAMA(String tOKANAMA) {
        this.tOKANAMA = tOKANAMA;
    }

    public String getTOTARIFAWAL() {
        return tOTARIFAWAL;
    }

    public void setTOTARIFAWAL(String tOTARIFAWAL) {
        this.tOTARIFAWAL = tOTARIFAWAL;
    }

    public String getTOKTID() {
        return tOKTID;
    }

    public void setTOKTID(String tOKTID) {
        this.tOKTID = tOKTID;
    }

    public String getTOKTNAMA() {
        return tOKTNAMA;
    }

    public void setTOKTNAMA(String tOKTNAMA) {
        this.tOKTNAMA = tOKTNAMA;
    }

    public String getTOTARIFAKHIR() {
        return tOTARIFAKHIR;
    }

    public void setTOTARIFAKHIR(String tOTARIFAKHIR) {
        this.tOTARIFAKHIR = tOTARIFAKHIR;
    }

    public String getTOSUBTOTAL() {
        return tOSUBTOTAL;
    }

    public void setTOSUBTOTAL(String tOSUBTOTAL) {
        this.tOSUBTOTAL = tOSUBTOTAL;
    }

    public String getTOPAYMENTBY() {
        return tOPAYMENTBY;
    }

    public void setTOPAYMENTBY(String tOPAYMENTBY) {
        this.tOPAYMENTBY = tOPAYMENTBY;
    }

    public String getTONOVERIFTIKET() {
        return tONOVERIFTIKET;
    }

    public void setTONOVERIFTIKET(String tONOVERIFTIKET) {
        this.tONOVERIFTIKET = tONOVERIFTIKET;
    }

    public String getTOSTATUS() {
        return tOSTATUS;
    }

    public void setTOSTATUS(String tOSTATUS) {
        this.tOSTATUS = tOSTATUS;
    }

    public String getTOCREATEDCOST() {
        return tOCREATEDCOST;
    }

    public void setTOCREATEDCOST(String tOCREATEDCOST) {
        this.tOCREATEDCOST = tOCREATEDCOST;
    }

    public Object getTOUPDATEDDRIVER() {
        return tOUPDATEDDRIVER;
    }

    public void setTOUPDATEDDRIVER(Object tOUPDATEDDRIVER) {
        this.tOUPDATEDDRIVER = tOUPDATEDDRIVER;
    }

    public String getTOBOOKINGTGL() {
        return tOBOOKINGTGL;
    }

    public void setTOBOOKINGTGL(String tOBOOKINGTGL) {
        this.tOBOOKINGTGL = tOBOOKINGTGL;
    }

    public String getTOBOOKINGSTART() {
        return tOBOOKINGSTART;
    }

    public void setTOBOOKINGSTART(String tOBOOKINGSTART) {
        this.tOBOOKINGSTART = tOBOOKINGSTART;
    }

    public String getTOBOOKINGEND() {
        return tOBOOKINGEND;
    }

    public void setTOBOOKINGEND(String tOBOOKINGEND) {
        this.tOBOOKINGEND = tOBOOKINGEND;
    }

    public String getTOSYSCREATEDAT() {
        return tOSYSCREATEDAT;
    }

    public void setTOSYSCREATEDAT(String tOSYSCREATEDAT) {
        this.tOSYSCREATEDAT = tOSYSCREATEDAT;
    }

    public String getTOSYSUPDATEDAT() {
        return tOSYSUPDATEDAT;
    }

    public void setTOSYSUPDATEDAT(String tOSYSUPDATEDAT) {
        this.tOSYSUPDATEDAT = tOSYSUPDATEDAT;
    }

    public String getToCOSTNIK() {
        return toCOSTNIK;
    }

    public void setToCOSTNIK(String toCOSTNIK) {
        this.toCOSTNIK = toCOSTNIK;
    }

    public String getToBOOKINGKURSI() {
        return toBOOKINGKURSI;
    }

    public void setToBOOKINGKURSI(String toBOOKINGKURSI) {
        this.toBOOKINGKURSI = toBOOKINGKURSI;
    }
}
