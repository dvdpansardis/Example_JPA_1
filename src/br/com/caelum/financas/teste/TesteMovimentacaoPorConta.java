package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoPorConta {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		
		Movimentacao movimentacao = entityManager.find(Movimentacao.class, 1);
		Conta conta = movimentacao.getConta();
				
		System.out.println(conta.getMovimentacoes().size());
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
	
}
