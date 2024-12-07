package com.xj.family.bean;

import java.util.Date;
import java.util.Objects;

public class SixLog2{

    private Long id;
    private String logContent;
    private String logCover;
    private Date logDate; // this one is never used when insert, but will be useful when retriving
    private int ownerId;
	private String logTag;

	public SixLog2() {
	}

	public SixLog2(Long id, String logContent, String logCover, Date logDate, int ownerId, String logTag) {
		this.id = id;
		this.logContent = logContent;
		this.logCover = logCover;
		this.logDate = logDate;
		this.ownerId = ownerId;
		this.logTag = logTag;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogContent() {
		return this.logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public String getLogCover() {
		return this.logCover;
	}

	public void setLogCover(String logCover) {
		this.logCover = logCover;
	}

	public Date getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public int getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getLogTag() {
		return this.logTag;
	}

	public void setLogTag(String logTag) {
		this.logTag = logTag;
	}

	public SixLog2 id(Long id) {
		setId(id);
		return this;
	}

	public SixLog2 logContent(String logContent) {
		setLogContent(logContent);
		return this;
	}

	public SixLog2 logCover(String logCover) {
		setLogCover(logCover);
		return this;
	}

	public SixLog2 logDate(Date logDate) {
		setLogDate(logDate);
		return this;
	}

	public SixLog2 ownerId(int ownerId) {
		setOwnerId(ownerId);
		return this;
	}

	public SixLog2 logTag(String logTag) {
		setLogTag(logTag);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof SixLog2)) {
			return false;
		}
		SixLog2 sixLog2 = (SixLog2) o;
		return Objects.equals(id, sixLog2.id) && Objects.equals(logContent, sixLog2.logContent) && Objects.equals(logCover, sixLog2.logCover) && Objects.equals(logDate, sixLog2.logDate) && ownerId == sixLog2.ownerId && Objects.equals(logTag, sixLog2.logTag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, logContent, logCover, logDate, ownerId, logTag);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", logContent='" + getLogContent() + "'" +
			", logCover='" + getLogCover() + "'" +
			", logDate='" + getLogDate() + "'" +
			", ownerId='" + getOwnerId() + "'" +
			", logTag='" + getLogTag() + "'" +
			"}";
	}

}