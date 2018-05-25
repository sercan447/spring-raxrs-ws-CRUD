package com.mimaraslan.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="musteri")
@XmlAccessorType(XmlAccessType.FIELD)
public class Musteri {
	
	@XmlElement
	private int musteriId;
	@XmlElement
	private int musteriNo;
	@XmlElement
	private String musteriAdi;
	@XmlElement
	private String musteriSoyadi;
	
	
	
	public Musteri() {
		
	}

	
	
	public Musteri(int musteriId, int musteriNo, String musteriAdi, String musteriSoyadi) {
		super();
		this.musteriId = musteriId;
		this.musteriNo = musteriNo;
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
	}



	public Musteri(int musteriNo, String musteriAdi, String musteriSoyadi) {
		
		this.musteriNo = musteriNo;
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
	}

	public int getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}

	public int getMusteriNo() {
		return musteriNo;
	}

	public void setMusteriNo(int musteriNo) {
		this.musteriNo = musteriNo;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}

	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
	}

	@Override
	public String toString() {
		return "Musteri [musteriId=" + musteriId + ", musteriNo=" + musteriNo + ", musteriAdi=" + musteriAdi
				+ ", musteriSoyadi=" + musteriSoyadi + "]";
	}
	
	

	
	
}
