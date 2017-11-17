package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager entityManager;

	public MovimentacaoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Double> getMediasPorDataETipo(TipoMovimentacao saida, Conta conta) {
		// Don't forget! use distinct! but i dont put!
		TypedQuery<Double> typedQuery = entityManager.createNamedQuery(Movimentacao.GET_MEDIAS_POR_DATA_E_CATEGORIA, Double.class);
		typedQuery.setParameter("pConta", conta);

		return typedQuery.getResultList();
	}

}
