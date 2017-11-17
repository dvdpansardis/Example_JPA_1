package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteDelete {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		//I need a managed object to delete.
		//To this first i find a object by Id to before remove.
		//Note: Detached Objects not possible to delete
		Conta conta = entityManager.find(Conta.class, 11);
		
		entityManager.remove(conta);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
	
}
