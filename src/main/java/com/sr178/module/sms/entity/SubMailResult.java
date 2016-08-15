package com.sr178.module.sms.entity;

public class SubMailResult {

	private String status;
	private String send_id;
	private int fee;
	private int sms_credits;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getSms_credits() {
		return sms_credits;
	}
	public void setSms_credits(int sms_credits) {
		this.sms_credits = sms_credits;
	}
	public SubMailResult(String status, String send_id, int fee, int sms_credits) {
		super();
		this.status = status;
		this.send_id = send_id;
		this.fee = fee;
		this.sms_credits = sms_credits;
	}
	public SubMailResult() {
		super();
	}
	@Override
	public String toString() {
		return "SubMailResult [status=" + status + ", send_id=" + send_id + ", fee=" + fee + ", sms_credits="
				+ sms_credits + "]";
	}
}
