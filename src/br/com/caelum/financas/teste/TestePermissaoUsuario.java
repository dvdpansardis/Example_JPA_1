package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Permissao;
import br.com.caelum.financas.modelo.Usuario;
import br.com.caelum.financas.util.JPAUtil;

public class TestePermissaoUsuario {

	public static void main(String[] args) {
		
		Permissao permissaoUsu = new Permissao();
		permissaoUsu.setPermissao("usuario");
		
		Permissao permissaoAdm = new Permissao();
		permissaoAdm.setPermissao("adm");
		
		Permissao permissaoDev = new Permissao();
		permissaoAdm.setPermissao("dev");
		
		Usuario usuDvd = new Usuario();
		usuDvd.setNome("David");
		
		
		Usuario usuLeh = new Usuario();
		usuLeh.setNome("Leticia");
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(permissaoAdm);
		entityManager.persist(permissaoUsu);
		entityManager.persist(permissaoDev);
		
		usuDvd.adiciona(permissaoAdm);
		usuDvd.adiciona(permissaoDev);
		usuLeh.adiciona(permissaoDev);
		
		entityManager.persist(usuDvd);
		entityManager.persist(usuLeh);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
	
}
