class Pedido {

    var codigoPedido: Int = -1;
    var subtotal: Double = 0.0;
    var frete: Double = 0.0;
    var desconto: Double = 0.0;
    var valorTotal: Double = 0.0;

    var cliente: Cliente = Cliente("", "", "");
    var listaItens = mutableListOf<ItemPedido>();


    constructor(codigoPedido: Int){
        this.codigoPedido = codigoPedido;
    }


    fun addItemPedido(item: ItemPedido) {
        listaItens.add(item);
    }


    fun calcularSubtotal() {
        for(item in listaItens) {
            this.subtotal += item.precoProduto;
        }
    }


    fun aplicarDesconto(){
        if (subtotal >= 100.0){
            desconto = 0.05;
        }
        if (subtotal >= 250){
            desconto = 0.1;
        }
        if (subtotal >= 500){
            desconto = 0.2;
        }
    }


    fun calcularFrete(){
        var somaPesos: Double = 0.0;

        for(item in listaItens) {
            if(item.tipoProduto.equals("Físico")){
                somaPesos += item.pesoProduto;
            }
        }
        this.frete = somaPesos * 5;
    }


    fun calcularValorTotal(){
        this.valorTotal = subtotal - (subtotal * desconto) + frete;
    }


    override fun toString(): String {
        return " ID Pedido: $codigoPedido\n Subtotal: R$${String.format("%.2f", subtotal)}\n Frete: ${String.format("%.1f", frete)}\n Desconto: ${desconto * 100}%\n Valor Total: R$${String.format("%.2f", valorTotal)}\n ";
    }
}