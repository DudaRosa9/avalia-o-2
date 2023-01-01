import java.time.LocalDate;

public class Venda {
    public LocalDate datavenda;
    public Produto produtovendido;
    public int quantidadevendida;

    public LocalDate getDatavenda() {
        return datavenda;
    }
    public void setDatavenda(LocalDate datavenda) {
        this.datavenda = datavenda;
    }
    public Produto getProdutovendido() {
        return produtovendido;
    }
    public void setProdutovendido(Produto produtovendido) {
        this.produtovendido = produtovendido;
    }
    public int getQuantidadevendida() {
        return quantidadevendida;
    }
    public void setQuantidadevendida(int quantidadevendida) {
        this.quantidadevendida = quantidadevendida;
    }
    
}
