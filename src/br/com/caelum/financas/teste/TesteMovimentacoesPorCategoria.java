package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultList = query.getResultList();
		for (Movimentacao movimentacao : resultList) {
			System.out.println(movimentacao.getDescricao());
		}
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
	}
	
	
}
