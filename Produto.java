public class Produto {
  public int codigoproduto, Qtdestoque, valor;
  public String nom;
  
  public int getCodigoproduto () {
     return codigoproduto;
}
  public void setCodigoproduto (int codigoproduto) {
     this.codigoproduto = codigoproduto;
}
  public int Qtdestoque () {
     return Qtdestoque;
}
  public void Qtdestoque (int Qtdestoque) {
     this.Qtdestoque = Qtdestoque;
}
  public int getValor() {
     return valor;
}
  public void setValor(int valor) {
     this.valor = valor;
}
  public String getNome() {
     return nome;
}
  public void setNome(String nome) {
     this.nome = nome;
  }
  
  public void procuraElemento(){
    for (int i=0; i==getCodigoproduto(); i++)
          System.out.println(x:"ja existe");
  }

  @Override
  public String toString() {
    return String.format(format: "%d", getQtdestoque());
  }
}
