package org.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.entity.Client;
import org.entity.DNS_Hosting;
import org.entity.Factura;
import org.entity.HostingDedicated;
import org.entity.Serviciu;
import org.entity.SharedHosting;

public class TestServicii {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf =Persistence.createEntityManagerFactory("HostingJPA");
		EntityManager em=emf.createEntityManager();
		
		
		
		//Populare clienti
		
		List <Client> lstClientiPersistenti=em.
				createQuery("Select c From Client c",Client.class).
				getResultList();
		
		if(! lstClientiPersistenti.isEmpty()) {
			em.getTransaction().begin();
			for(Client c: lstClientiPersistenti) em.remove(c);
			em.getTransaction().commit();			
		}
		
		//Create
		em.getTransaction().begin();
		em.persist(new Client(10,"Manolea Mihai","Fizica"));
		em.persist(new Client(11,"Ignutus Powerell","Fizica"));
		em.persist(new Client(12,"Ungureanu Tiberiu","Fizica"));
		em.persist(new Client(13,"SC TIMI SRL","Juridica"));
		em.persist(new Client(14,"TokyMarket SRL","Juridica"));
		em.persist(new Client(15,"NNT DATE","Juridica"));
		em.persist(new Client(16,"Iftime Gabriel","Fizica"));
		em.persist(new Client(17,"IT C&S","Juridica"));
		em.persist(new Client(18,"Iordache&TIC","Jurdica"));
		em.persist(new Client(19,"ContaG","Juridica"));
		em.getTransaction().commit();
		//Read after create
		lstClientiPersistenti=em.createQuery("Select c From Client c",Client.class).getResultList();
		System.out.println("Lista clientilor persistenti/salvati in baza de date");
		
		for(Client c:lstClientiPersistenti)
			System.out.println("IdClient: "+c.getId()+", nume: "+c.getNume()+", tip persoana: "+c.getTip_client());
		
		
		//POPULARE SERVICII
		List <Serviciu> lstServiciiPersistente=em.createQuery("Select s From Serviciu s",Serviciu.class).getResultList();
		if(!lstServiciiPersistente.isEmpty()) {
			em.getTransaction().begin();
			for(Serviciu s:lstServiciiPersistente) em.remove(s);
			em.getTransaction().commit();
		}
		List<Serviciu> catalogServicii=new ArrayList<Serviciu>();
		//Initializare explicita  a unor servicii oferite
		DNS_Hosting s1=new DNS_Hosting(1,"Domain_Name_Service_1",450.0,"primar","tudor",".ro");
		DNS_Hosting s2=new DNS_Hosting (2,"Domain_Name_Service_2",340.0,"secundar","masina",".net");
		catalogServicii.add(s1);
		catalogServicii.add(s2);
		
		SharedHosting s3= new SharedHosting(3,"SH_1",300.0,"PHP","PostgresSQL","64GB","ecommerce","3s");
		SharedHosting s4= new SharedHosting(4,"SH_2",230.0,"Java","MySQL","64GB","prezentare","2s");
		SharedHosting s5= new SharedHosting(5,"SH_3",123.0,"PHP","MySQL","16GB","corporativ","1s");
		SharedHosting s6= new SharedHosting(6,"SH_4",432.0,"PHP","PostgresSQL","128GB","prezentare","nelimitat");
		catalogServicii.add(s3);
		catalogServicii.add(s4);
		catalogServicii.add(s5);
		catalogServicii.add(s6);
		
		HostingDedicated s7=new HostingDedicated(7,"Server_Inchiriat_1",1230.0,"PHP","PostgresSQL","64GB","Windows","Atena");
		HostingDedicated s8=new HostingDedicated(8,"Server_Inchiriat_2",2000.0,"Java","MySQL","128GB","Ubuntu","Budapesta");
		HostingDedicated s9=new HostingDedicated(9,"Server_Inchiriat_3",1550.0,"ASP.NET","PostgresSQL","500GB","Debian","Cluj");
		HostingDedicated s10=new HostingDedicated(10,"Server_Inchiriat_4",2340.0,"ColdFusion","Oracle","1TB","CentOS","Bucuresti");
		catalogServicii.add(s7);
		catalogServicii.add(s8);
		catalogServicii.add(s9);
		catalogServicii.add(s10);
		
		em.getTransaction().begin();
		catalogServicii.stream().forEach(s->em.persist(s));
		em.getTransaction().commit();
		//Read after create
		lstServiciiPersistente=em.createQuery("Select s From Serviciu s",Serviciu.class).getResultList();
		System.out.println("Lista serviciilor persistente/salvate in baza de date");
		for (Serviciu s:lstServiciiPersistente)
			System.out.println("Id: "+s.getIdServiciu()+", denumire: "+s.getDenServiciu()+", pret: "+s.getPretServiciu().toString());
		
		
		
		
		
		
		
		

	}
	}


