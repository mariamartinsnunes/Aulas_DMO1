open class Pessoa{
    //propriedades de uma pessoa
    //por padrão, as propriedade/atributos são públicos
    var cpf: String = "";
    var nome: String = "";
    var email: String = "";

    constructor(cpf: String, nome: String, email: String) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }


    open fun andar(){
        println("Andando...");
    }
}