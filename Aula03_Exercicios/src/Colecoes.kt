fun main(){
    // Exercícios de fixação - Coleções
    // --------------------------------

    // Exercício 01: Crie um programa que:
    //               1. Peça ao usuário 5 números inteiros.
    //               2. Guarde-os em uma List.
    //               3. Use uma função que receba a lista e retorne apenas os números pares.
    //               4. Imprima os pares encontrados ou uma mensagem caso não exista nenhum.


    println("\nExercício 01 - List");
    println("---------------------");

    var lista = mutableListOf<Int>();

    println("\nInforme 5 números para armazená-los em uma lista...");

    for(i in 1..5){
        print("Número ${i}: ");
        var num = readln().toIntOrNull();

        if(num != null){
            lista.add(num);
        }
    }

    var listaPares = verificaPar(lista);

    if(listaPares.size != 0) {
        println("\nNúmero(s) par(es) informado(s): ");
        for (num in listaPares) {
            println(num);
        }
    } else {
        println("\nVocê não digitou nenhum número par...");
    }


    println("\n--------------------------------------------------------------");



    // Exercício 02: Crie um programa que:
    //               1. Leia uma frase digitada pelo usuário.
    //               2. Divida a frase em palavras (dica: split(" ")).
    //               3. Guarde as palavras em uma estrutura que seja possível contar quantas palavras únicas a frase tem.
    //               4. Conte quantas palavras únicas existem.
    //               5. Mostre o resultado.


    println("\nExercício 02 - Set");
    println("---------------------");

    print("Digite uma frase: ");
    val frase = readlnOrNull();

    if(!frase.isNullOrBlank()){
        val palavras: Set<String> = frase.split(" ").toSet();
        println("\nA frase digitada possui ${palavras.size} palavra(s) única(s) :)");

    } else {
        println("\nVocê não digitou nenhuma frase...");
    }
}


//função para verificar quais números são pares - exercício 01
fun verificaPar(numeros: List<Int>): List<Int>{
    var listaPares = mutableListOf<Int>();

    for(num in numeros){
        if(num % 2 == 0){
            listaPares.add(num);
        }
    }
    return listaPares;
}