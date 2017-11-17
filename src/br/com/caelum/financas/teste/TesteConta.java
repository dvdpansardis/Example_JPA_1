package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		//Para o hibernate esta conta é Transient
		Conta conta = new Conta();
		
		conta.setTitular("David");
		conta.setAgencia("123");
		conta.setBanco("Santander");
		conta.setNumero("123456789");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		//Sempre deve estar em uma transação
		em.getTransaction().begin();
		
		//Persistir
		em.persist(conta);

		//Agora a conta é Managed
		conta.setBanco("Itau");
		
		//Commitar uma transação
		em.getTransaction().commit();
		
		//Sempre fechar para livrar recurso
		em.close();
		
		//Agora a conta esta livre
		conta.setBanco("Teste");
		
		System.out.println(conta.getBanco());
		
	}

}
