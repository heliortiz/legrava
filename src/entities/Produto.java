package entities;

public class Produto {

	private String nomeProduto;
	private Double valorProduto;
	private Long qtdProduto;
	
	public Produto() {
		
	}
	
	public Produto(String nomeProduto, Double valorProduto, Long qtdProduto) {
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.qtdProduto = qtdProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public Long getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(Long qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	
	public Double valorTotal() {
		return qtdProduto * valorProduto;
	}

	public String toStringOut() {
		return nomeProduto + "; " + String.format("%.2f", valorTotal());
	} 
	
	@Override
	public String toString() {
		return nomeProduto + "; " + String.format("%.2f", valorProduto) + "; " + qtdProduto;
	}	
	
}
