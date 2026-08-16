fun main(){
    println("\nExercícios - estruturas condicionais");
    println("------------------------------------");


    // Exercício 01 - Peça ao usuário para digitar um número inteiro e informe se ele é par ou ímpar, utilizando o if como expressão.

    print("\nDigite um número inteiro: ");
    val num = readln().toIntOrNull();

    if(num != null){
        if(num % 2 == 0){
            println("\nO número ${num} é par :)");
        } else {
            println("\nO número ${num} é ímpar :)");
        }
    } else {
        println("\nO valor recebido é nulo...");
    }


    println("------------------------------------");


    // Exercício 02 - Escreva um programa que leia três números inteiros e indique qual o menor valor dentre eles.

    print("\nDigite um número inteiro: ");
    val n1 = readln().toIntOrNull();

    print("Digite outro número inteiro: ");
    val n2 = readln().toIntOrNull();

    print("Digite mais um número: ");
    val n3 = readln().toIntOrNull();


    if(n1 != null && n2 != null && n3 != null){
        var menor = n1;

        if(menor > n2){
            menor = n2;
        }

        if(menor > n3){
            menor = n3;
        }

        println("\nO menor número dentre os três informados é ${menor}!");

    } else {
        println("\nPelo menos um dos valores recebidos é nulo...");
    }


    println("------------------------------------");


    // Exercício 03 - Peça dois números e uma operação (+, -, *, /). Mostre o resultado da operação escolhida. Se a operação for inválida, exiba uma mensagem de erro.

    print("\nDigite um número: ");
    val num1 = readln().toDoubleOrNull();

    print("Digite outro número: ");
    val num2 = readln().toDoubleOrNull();


    if(num1 != null && num2 != null) {
        var resultado = 0.0;

        println("\nOperações: ");
        println("1. adição (+)");
        println("2. subtração (-)");
        println("3. multiplicação (*)");
        println("4. divisão (/)");

        print("\nEscolha uma das operações: ");
        val op = readln().toIntOrNull();

        when (op) {
            1 -> {
                resultado = num1 + num2;
                println("O resultado da adição é ${resultado}");
            }
            2 -> {
                resultado = num1 - num2;
                println("O resultado da subtração é ${resultado}");
            }
            3 -> {
                resultado = num1 * num2;
                println("O resultado da multiplicação é ${resultado}");
            }
            4 -> {
                if(num2 != 0.0){
                    resultado = num1 / num2;
                    println("O resultado da divisão é ${resultado}");

                } else {
                    println("Não é possível dividir um número por 0...");
                }
            }

            else -> println("Operação inválida...");
        }

    } else {
        println("Pelo menos um dos valores recebidos é nulo...");
    }
}