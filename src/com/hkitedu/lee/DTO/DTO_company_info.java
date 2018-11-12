package com.hkitedu.lee.DTO;

public class DTO_company_info {

	private int com_no; // number(2) primary key, 회사번호
	private String com_name; // VARCHAR2(20), 회사이름
	private String com_addr; // VARCHAR2(100), 회사주소
	private int com_amount; // number, 판매대수
	private int com_total; // number, 총수익

	public int getCom_no() {
		return com_no;
	}

	public void setCom_no(int com_no) {
		this.com_no = com_no;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public String getCom_addr() {
		return com_addr;
	}

	public void setCom_addr(String com_addr) {
		this.com_addr = com_addr;
	}

	public int getCom_amount() {
		return com_amount;
	}

	public void setCom_amount(int com_amount) {
		this.com_amount = com_amount;
	}

	public int getCom_total() {
		return com_total;
	}

	public void setCom_total(int com_total) {
		this.com_total = com_total;
	}

}
