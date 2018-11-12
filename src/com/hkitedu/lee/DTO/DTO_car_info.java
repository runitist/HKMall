package com.hkitedu.lee.DTO;

public class DTO_car_info {

	private int c_no; // number(6) primary key, 등록번호
	private int com_no; // number(2), 회사번호
	private String c_name; // VARCHAR2(20), 차량이름
	private String c_type; // VARCHAR2(20), 차종
	private String c_regdate; // date, 출시일자
	private int c_price; // number(10), 차량가격
	private int c_cc; // number(5), 배기량

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getCom_no() {
		return com_no;
	}

	public void setCom_no(int com_no) {
		this.com_no = com_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	public String getC_regdate() {
		return c_regdate;
	}

	public void setC_regdate(String c_regdate) {
		this.c_regdate = c_regdate;
	}

	public int getC_price() {
		return c_price;
	}

	public void setC_price(int c_price) {
		this.c_price = c_price;
	}

	public int getC_cc() {
		return c_cc;
	}

	public void setC_cc(int c_cc) {
		this.c_cc = c_cc;
	}

}
