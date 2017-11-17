package br.com.caelum.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class PopulaMovimentacaoComCategoria {

	public static void main(String[] args) {
		
		Categoria cat1 = new Categoria("viagem");
		
		Categoria cat2 = new Categoria("negócios");

		Conta conta = new Conta();
		conta.setId(12);
		
		Movimentacao mov1 = new Movimentacao();
		mov1.setData(Calendar.getInstance()); //Today
		mov1.setDescricao("Viagem a SP");
		mov1.setValor(new BigDecimal("100.0"));
		mov1.setTipo(TipoMovimentacao.SAIDA);
		mov1.setCategorias(Arrays.asList(cat1, cat2));
		
		mov1.setConta(conta);
		
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		Movimentacao mov2 = new Movimentacao();
		mov2.setData(amanha); //Today
		mov2.setDescricao("Viagem a MG");
		mov2.setValor(new BigDecimal("400.0"));
		mov2.setTipo(TipoMovimentacao.SAIDA);
		mov2.setCategorias(Arrays.asList(cat1, cat2));
		
		mov2.setConta(conta);

		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(cat1);
		entityManager.persist(cat2);

		entityManager.persist(mov1);
		entityManager.persist(mov2);
				
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
	
}
