package org.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.entity.Client;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				List<Client> clienti=new ArrayList<Client>();

				clienti.add(new Client(10,"Manolea Mihai","Fizica"));
				clienti.add(new Client(11,"Ignutus Powerell","Fizica"));
				clienti.add(new Client(12,"Ungureanu Tiberiu","Fizica"));
				clienti.add(new Client(13,"SC TIMI SRL","Juridica"));
				clienti.add(new Client(14,"TokyMarket SRL","Juridica"));
				clienti.add(new Client(15,"NNT DATE","Juridica"));
				clienti.add(new Client(16,"Iftime Gabriel","Fizica"));
				clienti.add(new Client(17,"IT C&S","Juridica"));
				clienti.add(new Client(18,"Iordache&TIC","Jurdica"));
				clienti.add(new Client(19,"ContaG","Juridica"));
				
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("HostingJPA");
				EntityManager em=emf.createEntityManager();
				
				//Clean-up clienti
				em.getTransaction().begin();
				em.createQuery("Delete From Client c").executeUpdate();
				em.getTransaction().commit();
				
				//Create
				em.persist(clienti.get(0));
				em.persist(clienti.get(1));
				em.persist(clienti.get(2));
				em.persist(clienti.get(3));
				em.persist(clienti.get(4));
				em.persist(clienti.get(5));
				em.persist(clienti.get(6));
				em.persist(clienti.get(7));
				em.persist(clienti.get(8));
				em.persist(clienti.get(9));
				
				em.getTransaction().begin();
				em.getTransaction().commit();
				em.clear();
				
				//Read after create
				List<Client> ClientiPersitenti=em.
						createQuery("Select c From Client c",Client.class).getResultList();
				
				System.out.println("Lista clienti persitenti/salvati in baza de date");
				for(Client c:ClientiPersitenti)
					System.out.println("IdClient: "+c.getId()+", nume: "+c.getNume()+", tip persoana: "+c.getTip_client());
				
				//Update/Remove
				em.getTransaction().begin();
				Client c13=em.find(Client.class, 13);
				if(c13 != null) {
					c13.setNume("TIMI SRL Update");
					c13.setTip_client("Juridica_Update");
				}
				//Read/Remove
				
				//Client c11=(Client)em.createQuery("Select o From Client o where o.idclient=11").getSingleResult();
				Client c11=em.find(Client.class, 11);
				if(c11 !=null) em.remove(c11);
				
				//Realizare tranzactie
				em.getTransaction().commit();
				em.clear();
				
				ClientiPersitenti=em.
						createQuery("Select c From Client c",Client.class).getResultList();
				System.out.println("Lista finala clienti persistenti (salvati in baza de date):");
				for(Client c:ClientiPersitenti)
					System.out.println("IdClient: "+c.getId()+", nume: "+c.getNume()+", tip persoana: "+c.getTip_client());
				

			}

		}

	


