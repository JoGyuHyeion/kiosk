package org.zerock.domain;

public class Conn_logVO {
	private int conn_id;
	private String device_id;
	private String timestamp;

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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Conn_logVO [conn_id=" + conn_id + ", device_id=" + device_id + ", timestamp=" + timestamp + "]";
	}

}
