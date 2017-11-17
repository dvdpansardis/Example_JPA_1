package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDeTodasAsContas {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		

		/**
		 * 
		 * Join Fetch has the same behavior that the EAGER on relationship.
		 * 
		 */
		
		/**
		 * 
		 * Distinct acts only on the entity that is configured
		 * 
		 */
		
		String jpql = "select distinct c from Conta c join fetch c.movimentacoes";
		
		Query query = entityManager.createQuery(jpql);
		
		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes:");
			System.out.println(conta.getMovimentacoes());
		}
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		

	}

}
