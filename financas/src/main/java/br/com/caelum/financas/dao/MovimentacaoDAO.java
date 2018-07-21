package br.com.caelum.financas.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager em;
	
	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipo, Conta conta) {
		String jpql = "SELECT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo "
				+ "group by day(m.data), month(m.data), year(m.data)";

		TypedQuery<Double> myQuery = em.createQuery(jpql, Double.class);
		myQuery.setParameter("pConta", conta);
		myQuery.setParameter("pTipo", tipo);

		return myQuery.getResultList();
	}

	public BigDecimal getSoma(TipoMovimentacao tipo, Conta conta) {
		String jpql = "SELECT sum(m.valor) FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);

		return (BigDecimal) query.getSingleResult();
	}

	public Long getCount(Conta conta) {
		String jpql = "SELECT count(m.valor) FROM Movimentacao m WHERE m.conta = :pConta";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);

		return (Long) query.getSingleResult();
	}

	public BigDecimal getMax(Conta conta) {
		String jpql = "SELECT max(m.valor) FROM Movimentacao m WHERE m.conta = :pConta";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);

		return (BigDecimal) query.getSingleResult();
	}

}
