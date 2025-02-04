package org.entity;

import javax.persistence.Entity;

@Entity
public class WebHosting extends Serviciu {
	private String tip_tehnologie; //PHP, Java, Ruby on Rails, ColdFusion, ASP.NET
	private String baza_date; // MySQL, PostgreSQL, Oracle
	private String spatiu_stocare; //16GB-10TB
	
	
	public String getTip_tehnologie() {
		return tip_tehnologie;
	}
	public void setTip_tehnologie(String tip_tehnologie) {
		this.tip_tehnologie = tip_tehnologie;
	}
	public String getBaza_date() {
		return baza_date;
	}
	public void setBaza_date(String baza_date) {
		this.baza_date = baza_date;
	}
	public String getSpatiu_stocare() {
		return spatiu_stocare;
	}
	public void setSpatiu_stocare(String spatiu_stocare) {
		this.spatiu_stocare = spatiu_stocare;
	}
	
	public WebHosting() {
		super();
	}
	public WebHosting(Integer idServiciu, String denServiciu, Double pretServiciu, String tip_tehnologie,
			String baza_date, String spatiu_stocare) {
		super(idServiciu, denServiciu, pretServiciu);
		this.tip_tehnologie = tip_tehnologie;
		this.baza_date = baza_date;
		this.spatiu_stocare = spatiu_stocare;
	}
	@Override
	public String toString() {
		return "WebHosting [tip_tehnologie=" + tip_tehnologie + ", baza_date=" + baza_date + ", spatiu_stocare="
				+ spatiu_stocare + "]";
	}
	
	
}
