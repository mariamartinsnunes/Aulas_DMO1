fun main(){

    //sem contrutor

    /*val p1 = Pessoa();
    p1.nome = "Malu";
    p1.cpf = "111.111.111-11";
    p1.email = "malu@gmail.com";

    println("Nome: ${p1.nome}");
    println("CPF: ${p1.cpf}");
    println("Email: ${p1.email}");*/

    // ---------------------------------------------------------

    //com construtor
    //val p2 = Pessoa("222.222.222-22", "Luiza", "luiza@gmail.com");

    // ---------------------------------------------------------

    //herança e interface

    val c1 = Crianca("333.333.333-33", "Ana", "não tem");
    c1.denteDeLeite = "12 dentes de leite";
    c1.reuPrimario = true;

    println("Nome: ${c1.nome}");
    println("CPF: ${c1.cpf}");
    println("Email: ${c1.email}");
    println("Quantidade de dentes de leite: ${c1.denteDeLeite}");
    println("Tem o réu primário?  ${c1.reuPrimario}");
    println("Onde habita: ${c1.habitat}");

    println(c1.andar());
    println(c1.respiracao());
    println(c1.mover());
    println(c1.som());

    // ---------------------------------------------------------

    //classe abstrata
    val a1 = Adolescente();
    a1.idioma = "Português";

    println(a1.idioma);
    println(a1.praticas());

}