package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
// Join the query and model
// Validate on startup
@NamedQuery(name = Movimentacao.GET_MEDIAS_POR_DATA_E_CATEGORIA , query = "select avg(m.valor) from Movimentacao m where m.conta = :pConta group by m.data")
public class Movimentacao {

	public static final String GET_MEDIAS_POR_DATA_E_CATEGORIA = "MediasPorDataETipo";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// Double is not precision
	private BigDecimal valor;
	// Indication that this property is a ENUM
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;
	// Indication that this property should mapped to TimeStamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	private String descricao;
	@ManyToOne // Many "Movimentacoes" to One "Conta"
	private Conta conta;
	@ManyToMany
	private List<Categoria> categorias;

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
