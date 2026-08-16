import kotlin.math.*
import kotlin.random.Random

fun main(){
    println("\nExercícios - cálculos");
    println("------------------------------------");


    // Exercício 01 - Dados os pontos cartesianos P1 = (x1, y1) representando a localização do(a) jogador(a) e P2 = (x2, y2) representando a posição do inimigo, crie um programa que calcule a distância entre estes dois pontos.

    println("\nJogando...");

    val x1 = Random.nextInt(1, 11).toDouble();
    val x2 = Random.nextInt(1, 11).toDouble();
    val y1 = Random.nextInt(1, 11).toDouble();
    val y2 = Random.nextInt(1, 11).toDouble();

    var distancia = sqrt((x2 - x1).pow(2.0) + (y2 - y1).pow(2.0));

    if(distancia <= 5.0){
        println("\n[ENTRAR NO MODO DE ATAQUE]");
        println("O inimigo está próximo a você!");
    }
    else {
        println("\nFique atento(a)... e esteja pronto(a) para o ataque!");
    }


    println("------------------------------------");


    // Exercício 02 - Peça ao usuário uma palavra e verifique se ela é um palíndromo (ou seja, lida de trás para frente é igual à original).
    //               Exemplos: "arara", "ovo".

    println("\nDescubra se uma palavra é um palíndromo...");

    print("Palavra: ");
    val palavra = readlnOrNull();


    if(palavra != null) {
        val tamanho = (palavra.length) - 1;

        var i = 0;
        var ehPalindromo = true;

        while(i <= tamanho) {
            if (palavra[i] != palavra[tamanho - i]) {
                ehPalindromo = false;
            }
            i++;
        }

        if(ehPalindromo){
            println("\nA palavra '${palavra}' é um palíndromo! :)");
        } else {
            println("\nA palavra '${palavra}' não é um palíndromo... :)");
        }

    } else {
        println("\nVocê não digitou nenhuma palavra...");
    }


    println("------------------------------------");


    // Exercício 03 - Gere duas coordenadas aleatórias (x, y) de 1 até 8 (como em um tabuleiro de xadrez).
    //               Se (x + y) for par, mostre "Casa preta". Se for ímpar, mostre "Casa branca".

    println("\nInforme as coordenadas para a próxima jogada (valores de 1 a 8)...");

    print("X: ");
    val x = readln().toIntOrNull();

    print("Y: ");
    val y = readln().toIntOrNull()


    if(x != null && y != null){
        if((x < 1 || x > 8) || (y < 1 || y > 8)){
            println("\nPelo menos um dos valores está inválido...");
        }
        else {
            val soma = x + y;

            if (soma % 2 == 0) {
                println("\nCasa preta :)");
            } else {
                println("\nCasa branca :)");
            }
        }
    } else {
        println("\nPelo menos um dos valores ficou nulo...");
    }
}