package model;

/**
 *
 * @author MauricioBertodo
 */
public class Produtos {
    
    private int idProduto;
    private String nomeProduto;
    private String tipoProduto;
    private String valorProduto;

    public Produtos(String nomeProduto, String tipoProduto, String valorProduto) {
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
        this.valorProduto = valorProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public void setValorProduto(String valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public String getValorProduto() {
        return valorProduto;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nomeProduto + "Tipo: " + tipoProduto + "Valor: " + valorProduto;
    }
    
}
