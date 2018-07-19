package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua Fulano, 123");
		cliente.setProfissao("Professor");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Douglas");
		cliente2.setEndereco("Rua Fulano, 234");
		cliente2.setProfissao("Professor");
		
		Conta conta = new Conta();
		conta.setId(2); // detached; Was managed someday
		
		cliente.setConta(conta);
		cliente2.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();
		
		manager.persist(cliente);
		// manager.persist(cliente2); // throws an error because the relationship OneToOne is declared as unique
		
		manager.getTransaction().commit();
	}

}
