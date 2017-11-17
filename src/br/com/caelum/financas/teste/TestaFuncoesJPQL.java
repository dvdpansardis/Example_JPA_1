package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaFuncoesJPQL {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(12);
		
		entityManager.getTransaction().begin();
		
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		BigDecimal soma = (BigDecimal) query.getSingleResult();
		
		System.out.println("Soma de todas as movimentacoes " + soma);
		
		jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta";
		query = entityManager.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		Double media = (Double) query.getSingleResult();
		
		System.out.println("Média de todas as movimentacoes " + media);
		
		jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta";
		query = entityManager.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		BigDecimal maximo = (BigDecimal) query.getSingleResult();
		
		System.out.println("Máximo de todas as movimentacoes " + maximo);
		
		jpql = "select count(m) from Movimentacao m where m.conta = :pConta";
		query = entityManager.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		Long total = (Long) query.getSingleResult();
		
		System.out.println("Quantidade de todas as movimentacoes " + total);
		
		
		
		
		MovimentacaoDAO dao = new MovimentacaoDAO(entityManager);
		List<Double> medias = dao.getMediasPorDataETipo(TipoMovimentacao.SAIDA, conta);
		
		System.out.println("Médias:");
		for (Double m : medias) {
			System.out.println("Media: " + m);
		}
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
	
}
