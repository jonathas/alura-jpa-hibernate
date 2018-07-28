package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);
			
		TypedQuery<Double> typedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = typedQuery.getResultList();
		System.out.println("A media é: " + medias.get(0));
		System.out.println("A media é: " + medias.get(1));
		
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		
		BigDecimal soma = dao.getSoma(TipoMovimentacao.SAIDA, conta);
		System.out.println("A soma é: " + soma);
		
		Long count = dao.getCount(conta);
		System.out.println("O count é: " + count);
		
		BigDecimal max = dao.getMax(conta);
		System.out.println("A max é: " + max);
		
		em.getTransaction().commit();
		em.close();
	}

}
