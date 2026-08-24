class Cliente {
    var cpf: String = "";
    var nome: String = "";
    var email: String = "";


    constructor(cpf: String, nome: String, email: String) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    override fun toString(): String {
        return " CPF: $cpf\n Nome : $nome\n Email: $email\n";
    }
}