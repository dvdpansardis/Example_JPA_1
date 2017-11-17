package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {
	public static void main(String[] args) {

		EntityManager entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();

		Conta conta = entityManager.find(Conta.class, 6);

		System.out.println(conta.getTitular());

		// O hibernate retorna um objeto Managed, qualquer alteração reflete
		// diretamente no banco.
		conta.setTitular("David");

		entityManager.getTransaction().commit();

		entityManager.close();

		
		
		EntityManager entityManager2 = new JPAUtil().getEntityManager();

		entityManager2.getTransaction().begin();

		//Estado Detached
		conta.setTitular("Leticia");
		//Alterar para estado Managed
		entityManager2.merge(conta);
		
		
		entityManager2.getTransaction().commit();

		entityManager2.close();
	}
}
