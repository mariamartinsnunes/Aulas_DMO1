class ItemPedido {
    var codigoProduto: Int = -1;
    var nomeProduto: String = "";
    var precoProduto: Double = 0.0;
    var tipoProduto: String = "";
    var pesoProduto: Double = 0.0;


    constructor(codigoProduto: Int, nomeProduto: String, precoProduto: Double, tipoProduto: String, pesoProduto: Double){
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.tipoProduto = tipoProduto;
        this.pesoProduto = pesoProduto;
    }

    override fun toString(): String {
        return " ID: $codigoProduto - $nomeProduto\n Preço: R$${String.format("%.2f", precoProduto)} | Tipo: $tipoProduto | Peso: $pesoProduto\n";
    }
}