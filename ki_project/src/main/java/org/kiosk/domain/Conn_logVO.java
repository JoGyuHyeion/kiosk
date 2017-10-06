package org.kiosk.domain;

import java.sql.Timestamp;

public class Conn_logVO {
	private int conn_id;
	private String device_id;
	private Timestamp regdate;

	public int getConn_id() {
		return conn_id;
	}

	public void setConn_id(int conn_id) {
		this.conn_id = conn_id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Conn_logVO [conn_id=" + conn_id + ", device_id=" + device_id + ", regdate=" + regdate + "]";
	}

}
