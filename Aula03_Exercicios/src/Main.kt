fun main(){
    mensagem("Malu");

    println(calculo(2, 3));
    println(calculo2(7, 2));

    println("Média do aluno 1: ${media(5.0, 3.5)}");
    println("Média do aluno 2: ${media(9.5, 2.4, 6.7)}");

    val nome = "Luiza";
    println("Tamanho do nome '${nome}': ${nome.tamanho()}");



    //-----------------------------------------------------------------


    //conjuntos

    val lista = mutableListOf(40, 50, 60);
    lista.add(45);
    lista.remove(40);

    println("\nLista");
    for(i in lista){
        println(i);
    }


    val set = mutableSetOf(1, 8, 1, 9, 1, 10, 1);
    set.add(8);

    println("\nSet");
    for(s in set){
        println(s);
    }


    val map = mutableMapOf(1 to "one", 2 to "two", 3 to "three");

    println("\nMap");
    for(m in map){
        println("${m.key} -> ${m.value}");
    }
}


fun mensagem (nome: String){
    println("${nome} está aprendendo Kotlin :)");
}

//função que recebe valores e retorna algo
fun calculo (num1: Int, num2: Int): Int{
    return (num1 + num2) * 2;
}

//função de única expressão
fun calculo2 (num1: Int, num2: Int) = (num1 + num2) * 2;

//quantidade variável de argumentos (vararg)
fun media(vararg notas: Double): Double{
    var contador: Double = 0.0;
    var somatoria: Double = 0.0;

    for(nota in notas){
        contador += 1;
        somatoria += nota;
    }
    return somatoria / contador;
}

//função de extensão
fun String.tamanho(): Int{
    return this.length;
}