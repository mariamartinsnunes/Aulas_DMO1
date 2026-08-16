import kotlin.random.Random

fun main() {
    println("\nExercícios - estruturas de repetição");
    println("------------------------------------");


    // Exercício 01 - Peça ao usuário quantos números ele deseja somar. Em seguida, utilize um for para ler todos os valores e mostre a soma ao final.

    print("\nInforme quantos números deseja somar: ");
    val qnt = readln().toIntOrNull();

    if (qnt != null) {
        var soma = 0.0;

        for (i in 1..qnt) {
            print("Número ${i}: ");
            var num = readln().toDoubleOrNull();

            if(num != null) {
                soma += num;
            } else {
                println("\nO campo está nulo...");
            }
        }

        println("\nA soma dos números informados é ${soma} :)");

    } else {
        println("\nO valor informado para a quantidade de números a serem somados é nulo...");
    }


    println("------------------------------------");


    // Exercício 02 - Escreva um programa que peça ao usuário um número N e imprima um triângulo com N linhas usando o caractere #.

    print("\nInforme um número inteiro: ");
    val n = readln().toIntOrNull();

    if (n != null) {
        for (i in 1..n) {
            for (j in 1..i) {
                print("#");
            }
            println();
        }
    } else {
        println("\nO valor recebido é nulo...");
    }


    println("------------------------------------");


    // Exercício 03 - Implemente um jogo em que o computador escolhe um número aleatório entre 1 e 100 e o usuário deve adivinhar qual é.
    // O usuário tem no máximo 10 tentativas.
    //               A cada tentativa, informe se o número é maior ou menor.
    //               Se acertar, exiba uma mensagem de parabéns.
    //               Se esgotar as tentativas, revele o número correto.


    println("\nTente adivinhar o número inteiro escolhido pelo computador...");
    val valor = Random.nextInt(1,101);

    var acertou = false;

    for(i in 1..10){
        print("Tentativa ${i}: ");
        var numero = readln().toIntOrNull();

        if(numero != null) {
            if(numero > valor){
                println("\nO número correto é menor que ${numero}...");
            }
            else if(numero < valor){
                println("\nO número correto é maior que ${numero}...");
            }
            else {
                acertou = true;
                break;
            }
        } else {
            println("\nO campo está nulo... perdeu uma tentativa :(");
        }
    }

    if(acertou){
        println("\nParabéns!! Você acertou o número :)");
    } else {
        println("\nEsgotaram suas tentativas... O número correto era ${valor}");
    }
}