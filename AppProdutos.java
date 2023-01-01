import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.InputMismathException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AppProdutos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao;
        Scanner in = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar produtos");
            System.out.println("3 - Listar produtos cadastrados");
            System.out.println("4 - Vendas por periodo");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior
           //1 Primeira verificação: Verificar se existe um produto com o codigo igual ao fornecido pelo usuario(Fazer uma busca).  

            if (opcao == 1) {
                if (opcao == 1) {
                    Produto p = new Produto();
                    System.out.println("Digite o codigo do produto");
                    try{
                        p.setCodigoproduto(in.nextInt())
                        in.nextLine();
                    }catch(InputMismatchException e ){
                        System.out.println("Os codigos devem ser apenas numeros. ");
                        in.nextInt()
                        voltarMenu(in);
                        continue;
                    }
                    
                  //2 Segunda verificação: Verificar se o codigo digitado é inteiro (Tratar a excessão com try/cat)
                    boolean produto_existente = false;

                    for (Produto produto : produtos) {
                        if(p.getCodigoproduto() == produto.getCodigoproduto()){
                            System.out.println(x:"Produto ja cadastrado. ");
                            produto_existente=true;
                        }

                    }
                    if(produto_existente){
                        voltarMenu(in);
                        continue;
                    }
                    System.out.println("Nome do produto: ");
                    p.setNome(in.nextLine());

                    try{
                        System.out.println("Quantidade em estoque: ");
                        p.setQtdestoque(in.nextInt()); 
                    }catch(InputMismatchException e){
                        System.out.println("Digite apenas numeros neste campo. ");
                        in.nextLine();
                        voltarMenu(in);
                        continue;
                    }
                    
                    if(p.getQtdestoque()<=0){
                        System.out.println("A quantidade em estoque deve ser maior que 0. ");
                        voltarMenu(in);
                        continue;
                    }
                    // 1 Primeira verificação: garantir que a quantidade seja maior ou igual a 0
                    // 2 Segunda verificação: igual a verificação de cima
                    try{
                    System.out.println("Preço do produto: ");
                      p.setPreco(in.nextInt());
                    }catch(InputMismatchException e){
                      System.out.println("Digite um valor valido. ");
                      in.nextLine();
                      voltarMenu(in);
                      continue;
                    }
                     if (p.getPreco()<=0){
                        System.out.println("O preco deve ser maior que 0. ");
                        voltarMenu(in);
                        continue;
                    }
                    // 1 Primeira verificação: garantir que a preço seja maior a 0
                    // 2 Segunda verificação: igual a verificação de cima
                    produtos.add(p);
                    voltarMenu(in);
                    continue;
                }

                
                voltarMenu(in);
            } else if (opcao == 2) {
                
                if (produtos.size() == 0){
                    System.out.println("Não existem produtos a serem buscados.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("Digite o codigo do produto desejado: ");
                int escolha = in.nextInt();
                in.nextLine();

                for (Produto produto : produtos) {
                    if(escolha == produto.getCodigoproduto()){
                        System.out.println("Produto encontrado");
                        System.out.println(produto);
                        voltarMenu(in);
                    }
                    else{
                        System.out.println("Nenhum produto encontrado. ");
                    }
                }
                //Retornar "Nenhum produto encontrado" caso a escolha seja nenhum codigo dos produtos cadastrados
                voltarMenu(in);
            
            } else if (opcao == 3) {
                //Se a lista estiver vazia não há o que procurar.

                if (produtos.size() == 0){
                    System.out.println("Não existem produtos a serem listados.");
                    voltarMenu(in);
                    continue;
                }
                //Ordenar pelo nome: usando o metodo sort separado ou na stream
                //Adequar a listagem ao anunciado da prova(Pode ser da quantidade em estoque ou do preço do produto)
        
                produtos.forEach(System.out::println);
               
                voltarMenu(in);

            } else if (opcao == 4) {
                
            }
            else if (opcao == 5){
                //Primeira verificar se existem produtos na lista de produtos
                //Pedir codigo do produto ao usuario
                //Segunda verificar se o codigo fornecido pelo usuario está contido na lista de produtos
          
                Venda v = new Venda();

                System.out.println("Digite o codigo do produto que deseja vender: ");
                int codigo = in.nextInt();
                in.nextLine();
                Produto produto_buscado = busca(produtos, codigo);
                if(busca(produtos, codigo)!=null){
                    System.out.println(x:"produto encontrado");
                    v.setProdutovendido(produtos, codigo);
                }else{
                    voltarMenu(in);
                    continue;
                }
                if(produto_buscado.getQtdestoque()<=0){
                    System.out.println("Quantidade insuficiente");
                }
                //Pedir a quantidade a ser vendida
                //Verificar se a quantidade é maior que 0
                //verificar se a quantidade a ser vendida é menor que a quantidade em estoque do produto
                //Fazer a baixa do estoque  
                Venda v = new Venda();
                System.out.println("Digite data: ");
                String datav = in.nextLine();
                v.setDatavenda(LocalDate.parse(datav));
                System.out.println("Digite o codigo do produto: ");
                int codigop = in.nextInt();
                in.nextLine();
                System.out.println("Quantidade desejada: ");
                int quantidadev = in.nextInt();
                in.nextLine();
                if (quantidadev<=0){
                    System.out.println("Quantidade invalida!");
                    System.out.println("Venda intemrrompida");
                    voltarMenu(in);
                    continue;
                }
                List<Produto> p2 = produtos.stream().
                filter(p -> p.getCodigoproduto()==codigop).
                collect(Collectors.toList());
                if(quantidadev>p2.get(0).getQtdestoque()){
                    System.out.println("Quantidade invalida!");
                    System.out.println("Venda intemrrompida");
                    voltarMenu(in);
                    continue;
                    
                }
                v.setProdutovendido(p2.get(0));
                v.setQuantidadevendida(quantidadev);
                vendas.add(v);
                
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
    public static Produto busca(List<Produto> produtos,int codigo){
        for (Produto produto : produtos) {
            if(codigo == produto.getCodigoproduto()){
                return produto;
            }
        }
        return null;
    }
}