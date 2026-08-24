fun main(){
    println("\n --- Sistemas de Pedidos para uma Loja Virtual ---");
    println(" ------------------------------------------------- \n");


    println(" Informe sues dados para iniciar a compra... ");
    println(" ----------------------");

    print(" CPF: ");
    val cpf = readLine().toString();

    print(" Nome: ");
    val nome = readln().toString();

    print(" Email: ");
    val email = readln().toString();

    val cliente = Cliente(cpf, nome, email);


    println("\n ------------------------------------------------- \n");


    var novoPedido = Pedido(123);
    novoPedido.cliente = cliente;

    var mensagemEmail: Boolean = false;


    println(" Inclua os produtos que deseja no carrinho...");

    println("\n Produtos disponíveis na loja: ");
    var opcao: Int = -1;

    do{
        println(" 1 - Livro Físico");
        println(" 2 - Livro Digital");
        println(" 3 - Console");
        println(" 4 - Filme Digital");
        println(" 5 - Jogo de Tabuleiro");
        println(" 6 - Jogo Digital em Mídia Física");
        println(" 7 - Jogo Digital para Download");
        println(" 0 - Finalizar compra\n");

        print(" Digite o código do produto: ");
        var opcao = readln().toIntOrNull();


        if(opcao != null) {
            println("\n Adicionando produto ao carrinho...\n\n");

            when (opcao) {
                1 -> {
                    var novoItem = ItemPedido(1, "Livro Físico", 50.25, "Físico", 0.28);
                    novoPedido.addItemPedido(novoItem);
                }

                2 -> {
                    var novoItem = ItemPedido(2, "Livro Digital", 15.90, "Digital", 0.0);
                    novoPedido.addItemPedido(novoItem);
                    mensagemEmail = true;
                }

                3 -> {
                    var novoItem = ItemPedido(3, "Console", 1500.00, "Físico", 4.50);
                    novoPedido.addItemPedido(novoItem);
                }

                4 -> {
                    var novoItem = ItemPedido(4, "Filme", 26.85, "Digital", 0.0);
                    novoPedido.addItemPedido(novoItem);
                }

                5 -> {
                    var novoItem = ItemPedido(5, "Jogo de Tabuleiro", 98.57, "Físico", 0.74);
                    novoPedido.addItemPedido(novoItem);
                }

                6 -> {
                    var novoItem = ItemPedido(6, "Jogo Digital em Mídia Física", 350.90, "Físico", 0.12);
                    novoPedido.addItemPedido(novoItem);
                }

                7 -> {
                    var novoItem = ItemPedido(7, "Jogo Digital para Download", 485.60, "Digital", 0.0);
                    novoPedido.addItemPedido(novoItem);
                    mensagemEmail = true;
                }

                0 -> {
                    println(" -------------------- ");
                    println(" Finalizando a compra...");

                    novoPedido.calcularSubtotal();

                    print("\n Possui algum cupom de desconto? (1. sim)(2. não): ");
                    var cupom = readln().toIntOrNull();

                    if(cupom != null && cupom == 1) {
                        println(" Aplicando desconto com base no subtotal dos produtos...\n");
                        novoPedido.aplicarDesconto();
                    }

                    novoPedido.calcularFrete();
                    novoPedido.calcularValorTotal();
                }

                else -> println("\n Código inválido...\n");
            }

        } else {
            println("\n ERRO :/\n");
        }

    } while(opcao != 0);


    println("\n ------------------------------------------------- \n");


    println(" Informações do cliente: ");
    println(" ----------------------- ");
    println(cliente);


    println("\n Lista de itens: ");
    println(" ---------------- ");

    for(item in novoPedido.listaItens){
        println(item);
    }


    println("\n Detalhes do pedido: ");
    println(" ------------------ ");
    println(novoPedido);


    if(mensagemEmail){
        println(" Os produtos digitais adquiridos serão enviados para o email '${cliente.email}' 10 minutos após o pagamento!!! :)");
    }
}