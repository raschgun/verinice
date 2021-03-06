package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * MbMasUpdate generated by hbm2java
 */
public class MbMasUpdate implements java.io.Serializable {

	private MbMasUpdateId id;
	private MbMassn mbMassn;
	private byte metaUpdate;
	private String guid;
	private Date erstelltAm;
	private String erstelltDurch;

	public MbMasUpdate() {
	}

	public MbMasUpdate(MbMassn mbMassn, byte metaUpdate, String guid,
			Date erstelltAm, String erstelltDurch) {
		this.mbMassn = mbMassn;
		this.metaUpdate = metaUpdate;
		this.guid = guid;
		this.erstelltAm = erstelltAm;
		this.erstelltDurch = erstelltDurch;
	}

	public MbMasUpdateId getId() {
		return this.id;
	}

	public void setId(MbMasUpdateId id) {
		this.id = id;
	}

	public MbMassn getMbMassn() {
		return this.mbMassn;
	}

	public void setMbMassn(MbMassn mbMassn) {
		this.mbMassn = mbMassn;
	}

	public byte getMetaUpdate() {
		return this.metaUpdate;
	}

	public void setMetaUpdate(byte metaUpdate) {
		this.metaUpdate = metaUpdate;
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
