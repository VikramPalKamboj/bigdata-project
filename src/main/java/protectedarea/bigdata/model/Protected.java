package protectedarea.bigdata.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "protected")
public class Protected {

	private String NAME;
	private String STATUS;
	private String METADATAID;
	
    public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getMETADATAID() {
		return METADATAID;
	}
	public void setMETADATAID(String mETADATAID) {
		METADATAID = mETADATAID;
	}
	
	
}
