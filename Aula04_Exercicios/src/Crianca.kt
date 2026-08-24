class Crianca (cpf: String, nome: String, email: String): Pessoa(cpf, nome, email), SerVivo{
    var denteDeLeite: String = "";
    var reuPrimario: Boolean = true;

    //da interface SerVivo
    override var habitat: String = "Em qualquer lugar";


    //da classe Pessoa
    override fun andar(){
        println("Engatinhando...");
    }


    //da interface SerVivo
    override fun respiracao() {
        println("Respira oxigênio");
    }
    override fun mover(){
        println("Aprendendo a andar...");
    }
    override fun som(){
        println("Chora, brinca, sorri, fala...");
    }
}