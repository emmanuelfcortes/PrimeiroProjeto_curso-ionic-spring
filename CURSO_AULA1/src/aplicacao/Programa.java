package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
	Pessoa p1 = new Pessoa(null,"Carlos One","carlos@one.com");
	Pessoa p2 = new Pessoa(null, "Dom Two", "dom@two.com.br");
	Pessoa p3 = new Pessoa(null, "Siry Three", "siry@three.com.net");
	

	EntityManagerFactory emf= Persistence.createEntityManagerFactory("exemplo-jpa");
	EntityManager em = emf.createEntityManager();
	
	Pessoa p = em.find(Pessoa.class,7);
	em.getTransaction().begin();
	System.out.println(p);
	//em.remove(p);
	//em.persist(p1);
	em.getTransaction().commit();
	
	/* Inserir dados no banco, conforme os parâmetros do arquivo persistence
	em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
	em.getTransaction().commit();*/
	
	System.out.println("Concluído!");
	//System.out.println(p);
	em.close();
	emf.close();
	}
	;
}
