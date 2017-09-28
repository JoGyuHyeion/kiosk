package org.zerock.domain;

public class DbTestVO {

	private int id_no;
	private String id;
	private int pwd;

	public int getId_no() {
		return id_no;
	}

	public void setId_no(int id_no) {
		this.id_no = id_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "DbTestVO [id_no=" + id_no + ", id=" + id + ", pwd=" + pwd + "]";
	}

}
