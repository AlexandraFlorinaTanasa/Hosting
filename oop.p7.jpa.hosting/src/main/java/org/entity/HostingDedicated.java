package org.entity;

import javax.persistence.Entity;

@Entity
public class HostingDedicated extends WebHosting {
	private String tipSO; // folosit de cel care inchiriaza spatiu> Windows Server, Debian, CentOS, Ubuntu
	private String locatie_server; //Bucuresti, Cluj, Budapesta, Atena
	
	public String getTipSO() {
		return tipSO;
	}
	public void setTipSO(String tipSO) {
		this.tipSO = tipSO;
	}
	public String getLocatie_server() {
		return locatie_server;
	}
	public void setLocatie_server(String locatie_server) {
		this.locatie_server = locatie_server;
	}
	public HostingDedicated(Integer idServiciu, String denServiciu, Double pretServiciu, String tip_tehnologie,
			String baza_date, String spatiu_stocare, String tipSO, String locatie_server) {
		super(idServiciu, denServiciu, pretServiciu, tip_tehnologie, baza_date, spatiu_stocare);
		this.tipSO = tipSO;
		this.locatie_server = locatie_server;
	}
	public HostingDedicated() {
		super();
	}
	@Override
	public String toString() {
		return "HostigDedicated [tipSO=" + tipSO + ", locatie_server=" + locatie_server + "]";
	}
	
	
	
	
}

