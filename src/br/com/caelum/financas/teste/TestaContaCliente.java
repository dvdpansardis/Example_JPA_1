package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {
		
		Cliente clienteDvd = new Cliente();
		clienteDvd.setNome("David Pansardis");
		clienteDvd.setEndereco("Teste");
		clienteDvd.setProfissao("Dev");
		
		Cliente cliente = new Cliente();
		cliente.setNome("Kakashi");
		cliente.setEndereco("Pais do vento");
		cliente.setProfissao("Ninja");
	
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Naruto");
		cliente2.setEndereco("Pais do vento");
		cliente2.setProfissao("Ninja");
		
		Conta contaDvd = new Conta();
		contaDvd.setId(1);
		
		Conta conta = new Conta();
//		conta.setId(13);
		conta.setAgencia("777");
		conta.setBanco("NinjaBank");
		conta.setNumero("123456789");
		conta.setTitular("Kakashi");
		
		cliente.setConta(conta);
		cliente2.setConta(conta);
		clienteDvd.setConta(contaDvd);
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		
		//entityManager.persist(contaDvd);
		entityManager.persist(clienteDvd);
		//entityManager.persist(cliente2);
		
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
	
}
