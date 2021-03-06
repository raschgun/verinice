package sernet.gs.reveng;

// Generated Jun 5, 2015 1:28:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * StgMbGefaehrskatTxtId generated by hbm2java
 */
public class StgMbGefaehrskatTxtId implements java.io.Serializable {

	private Integer gfkId;
	private Integer gfkImpId;
	private Short sprId;
	private String name;
	private String beschreibung;
	private String guid;
	private Date timestamp;
	private String guidOrg;

	public StgMbGefaehrskatTxtId() {
	}

	public StgMbGefaehrskatTxtId(Integer gfkId, Integer gfkImpId, Short sprId,
			String name, String beschreibung, String guid, Date timestamp,
			String guidOrg) {
		this.gfkId = gfkId;
		this.gfkImpId = gfkImpId;
		this.sprId = sprId;
		this.name = name;
		this.beschreibung = beschreibung;
		this.guid = guid;
		this.timestamp = timestamp;
		this.guidOrg = guidOrg;
	}

	public Integer getGfkId() {
		return this.gfkId;
	}

	public void setGfkId(Integer gfkId) {
		this.gfkId = gfkId;
	}

	public Integer getGfkImpId() {
		return this.gfkImpId;
	}

	public void setGfkImpId(Integer gfkImpId) {
		this.gfkImpId = gfkImpId;
	}

	public Short getSprId() {
		return this.sprId;
	}

	public void setSprId(Short sprId) {
		this.sprId = sprId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getGuidOrg() {
		return this.guidOrg;
	}

	public void setGuidOrg(String guidOrg) {
		this.guidOrg = guidOrg;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StgMbGefaehrskatTxtId))
			return false;
		StgMbGefaehrskatTxtId castOther = (StgMbGefaehrskatTxtId) other;

		return ((this.getGfkId() == castOther.getGfkId()) || (this.getGfkId() != null
				&& castOther.getGfkId() != null && this.getGfkId().equals(
				castOther.getGfkId())))
				&& ((this.getGfkImpId() == castOther.getGfkImpId()) || (this
						.getGfkImpId() != null
						&& castOther.getGfkImpId() != null && this
						.getGfkImpId().equals(castOther.getGfkImpId())))
				&& ((this.getSprId() == castOther.getSprId()) || (this
						.getSprId() != null && castOther.getSprId() != null && this
						.getSprId().equals(castOther.getSprId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getBeschreibung() == castOther.getBeschreibung()) || (this
						.getBeschreibung() != null
						&& castOther.getBeschreibung() != null && this
						.getBeschreibung().equals(castOther.getBeschreibung())))
				&& ((this.getGuid() == castOther.getGuid()) || (this.getGuid() != null
						&& castOther.getGuid() != null && this.getGuid()
						.equals(castOther.getGuid())))
				&& ((this.getTimestamp() == castOther.getTimestamp()) || (this
						.getTimestamp() != null
						&& castOther.getTimestamp() != null && this
						.getTimestamp().equals(castOther.getTimestamp())))
				&& ((this.getGuidOrg() == castOther.getGuidOrg()) || (this
						.getGuidOrg() != null && castOther.getGuidOrg() != null && this
						.getGuidOrg().equals(castOther.getGuidOrg())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGfkId() == null ? 0 : this.getGfkId().hashCode());
		result = 37 * result
				+ (getGfkImpId() == null ? 0 : this.getGfkImpId().hashCode());
		result = 37 * result
				+ (getSprId() == null ? 0 : this.getSprId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37
				* result
				+ (getBeschreibung() == null ? 0 : this.getBeschreibung()
						.hashCode());
		result = 37 * result
				+ (getGuid() == null ? 0 : this.getGuid().hashCode());
		result = 37 * result
				+ (getTimestamp() == null ? 0 : this.getTimestamp().hashCode());
		result = 37 * result
				+ (getGuidOrg() == null ? 0 : this.getGuidOrg().hashCode());
		return result;
	}

}
