package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * MsZykTxt generated by hbm2java
 */
public class MsZykTxt implements java.io.Serializable {

	private MsZykTxtId id;
	private MsZyk msZyk;
	private MSprache MSprache;
	private String name;
	private String guid;
	private Date erstelltAm;
	private String erstelltDurch;

	public MsZykTxt() {
	}

	public MsZykTxt(MsZykTxtId id, MsZyk msZyk, MSprache MSprache, String name,
			String guid, Date erstelltAm) {
		this.id = id;
		this.msZyk = msZyk;
		this.MSprache = MSprache;
		this.name = name;
		this.guid = guid;
		this.erstelltAm = erstelltAm;
	}

	public MsZykTxt(MsZykTxtId id, MsZyk msZyk, MSprache MSprache, String name,
			String guid, Date erstelltAm, String erstelltDurch) {
		this.id = id;
		this.msZyk = msZyk;
		this.MSprache = MSprache;
		this.name = name;
		this.guid = guid;
		this.erstelltAm = erstelltAm;
		this.erstelltDurch = erstelltDurch;
	}

	public MsZykTxtId getId() {
		return this.id;
	}

	public void setId(MsZykTxtId id) {
		this.id = id;
	}

	public MsZyk getMsZyk() {
		return this.msZyk;
	}

	public void setMsZyk(MsZyk msZyk) {
		this.msZyk = msZyk;
	}

	public MSprache getMSprache() {
		return this.MSprache;
	}

	public void setMSprache(MSprache MSprache) {
		this.MSprache = MSprache;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getErstelltAm() {
		return this.erstelltAm;
	}

	public void setErstelltAm(Date erstelltAm) {
		this.erstelltAm = erstelltAm;
	}

	public String getErstelltDurch() {
		return this.erstelltDurch;
	}

	public void setErstelltDurch(String erstelltDurch) {
		this.erstelltDurch = erstelltDurch;
	}

}
