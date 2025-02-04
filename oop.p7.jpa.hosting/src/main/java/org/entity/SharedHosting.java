package org.entity;

import javax.persistence.Entity;

@Entity
public class SharedHosting extends WebHosting {
	private String tipSite;// corporativ, prezentare, ecommerce
	private String nrSite; //numar de site-uri care pot fi inregistrate (1 site->nelimitat)
	
	public String getTipSite() {
		return tipSite;
	}
	public void setTipSite(String tipSite) {
		this.tipSite = tipSite;
	}
	public String getNrSite() {
		return nrSite;
	}
	public void setNrSite(String nrSite) {
		this.nrSite = nrSite;
	}
	public SharedHosting() {
		super();
	}
	public SharedHosting(Integer idServiciu, String denServiciu, Double pretServiciu, String tip_tehnologie,
			String baza_date, String spatiu_stocare, String tipSite, String nrSite) {
		super(idServiciu, denServiciu, pretServiciu, tip_tehnologie, baza_date, spatiu_stocare);
		this.tipSite = tipSite;
		this.nrSite = nrSite;
	}
	@Override
	public String toString() {
		return "SharedHosting [tipSite=" + tipSite + ", nrSite=" + nrSite + "]";
	}
	
	
	

}
