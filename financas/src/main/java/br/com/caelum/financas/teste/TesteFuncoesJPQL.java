package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);
			
		String jpql = "SELECT sum(m.valor) FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo";
		Query query = manager.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		BigDecimal soma = (BigDecimal) query.getSingleResult();
		
		System.out.println("A soma é: " + soma);
		
		
		jpql = "SELECT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo "
				+ "group by day(m.data), month(m.data), year(m.data)";
		
		TypedQuery<Double> myQuery = manager.createQuery(jpql, Double.class);
		myQuery.setParameter("pConta", conta);
		myQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = myQuery.getResultList();
		
		System.out.println("A media é: " + medias.get(0));
		System.out.println("A media é: " + medias.get(1));
		
		
		jpql = "SELECT max(m.valor) FROM Movimentacao m WHERE m.conta = :pConta";
		query = manager.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		BigDecimal max = (BigDecimal) query.getSingleResult();
		
		System.out.println("A max é: " + max);
		
		jpql = "SELECT count(m.valor) FROM Movimentacao m WHERE m.conta = :pConta";
		query = manager.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		Long count = (Long) query.getSingleResult();
		
		System.out.println("O count é: " + count);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
