package protectedarea.bigdata.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "protected")

public class Protected {

	private String NAME;
	private String ISO3;
	private String STATUS;
	private String OWN_TYPE;
	private String DESIG_TYPE;
	private String GOV_TYPE;
	private String NO_TK_AREA;
	private String field29;
	private String field30;
	
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getISO3() {
		return ISO3;
	}
	public void setISO3(String iSO3) {
		ISO3 = iSO3;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getOWN_TYPE() {
		return OWN_TYPE;
	}
	public void setOWN_TYPE(String oWN_TYPE) {
		OWN_TYPE = oWN_TYPE;
	}
	public String getDESIG_TYPE() {
		return DESIG_TYPE;
	}
	public void setDESIG_TYPE(String dESIG_TYPE) {
		DESIG_TYPE = dESIG_TYPE;
	}
	public String getGOV_TYPE() {
		return GOV_TYPE;
	}
	public void setGOV_TYPE(String gOV_TYPE) {
		GOV_TYPE = gOV_TYPE;
	}
	public String getNO_TK_AREA() {
		return NO_TK_AREA;
	}
	public void setNO_TK_AREA(String nO_TK_AREA) {
		NO_TK_AREA = nO_TK_AREA;
	}
	public String getField29() {
		return field29;
	}
	public void setField29(String field29) {
		this.field29 = field29;
	}
	public String getField30() {
		return field30;
	}
	public void setField30(String field30) {
		this.field30 = field30;
	}
		
}
