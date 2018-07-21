package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

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
			
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		
		BigDecimal soma = dao.getSoma(TipoMovimentacao.SAIDA, conta);
		System.out.println("A soma é: " + soma);
		
		List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		System.out.println("A media é: " + medias.get(0));
		System.out.println("A media é: " + medias.get(1));
		
		Long count = dao.getCount(conta);
		System.out.println("O count é: " + count);
		
		BigDecimal max = dao.getMax(conta);
		System.out.println("A max é: " + max);
		
		em.getTransaction().commit();
		em.close();
	}

}
