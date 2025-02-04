package org.entity;

import javax.persistence.Entity;

@Entity
public class DNS_Hosting extends Serviciu {
	private String tip_DNS; //primar sau secundar
	private String denumireRezervata;
	private String domeniu; // .ro/.org/.com ..
	
	public String getTip_DNS() {
		return tip_DNS;
	}
	public void setTip_DNS(String tip_DNS) {
		this.tip_DNS = tip_DNS;
	}
	public String getDenumireRezervata() {
		return denumireRezervata;
	}
	public void setDenumireRezervata(String denumireRezervata) {
		this.denumireRezervata = denumireRezervata;
	}
	public String getDomeniu() {
		return domeniu;
	}
	public void setDomeniu(String domeniu) {
		this.domeniu = domeniu;
	}
	public DNS_Hosting() {
		super();
	}
	public DNS_Hosting(Integer idServiciu, String denServiciu, Double pretServiciu, String tip_DNS,
			String denumireRezervata, String domeniu) {
		super(idServiciu, denServiciu, pretServiciu);
		this.tip_DNS = tip_DNS;
		this.denumireRezervata = denumireRezervata;
		this.domeniu = domeniu;
	}
	
}
