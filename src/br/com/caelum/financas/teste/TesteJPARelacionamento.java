package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("0102");
		conta.setTitular("David Pansardis");
		conta.setBanco("0102050607");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("100"));

		movimentacao.setConta(conta);
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		//Passing the object from Transient to Managed.
		entityManager.persist(conta);
		entityManager.persist(movimentacao);
				
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
	
}
