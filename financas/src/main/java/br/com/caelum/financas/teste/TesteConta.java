package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setAgencia("123");
		conta.setBanco("Caixa Economica");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta); // transforms the object to 'managed'
		
		conta.setBanco("Itaú"); // it will execute an update automatically because it's 'managed'
		
		em.getTransaction().commit();
		
		em.close(); // from here on, not 'managed' anymore
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		
		em2.getTransaction().begin();
		
		conta.setTitular("Leonardo");
		em2.merge(conta); // transforms 'conta' from 'detached' to 'managed' again
		
		conta = em2.find(Conta.class, 1); // getting it as 'managed' again to be able to remove
		em2.remove(conta);
		
		em2.getTransaction().commit();
		
		em2.close();
	}

}
