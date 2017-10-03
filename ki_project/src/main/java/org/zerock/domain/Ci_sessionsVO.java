package org.zerock.domain;

public class Ci_sessionsVO {

	private String id;
	private String ip_address;
	private int timestamp;
	private String data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Ci_sessionsVO [id=" + id + ", ip_address=" + ip_address + ", timestamp=" + timestamp + ", data=" + data
				+ "]";
	}

}
