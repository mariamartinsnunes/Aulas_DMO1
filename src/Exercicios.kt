fun main(){
    // Ex01: Leia uma palavra do usuário e exiba-a em maiúsculas e em minúsculas

    print("\nDigite uma palavra: ");
    val palavra = readln();

    println("Maiúsculas: ${palavra.uppercase()}");
    println("Minúsculas: ${palavra.lowercase()}");


    // ---------------------------------------------------------------------------


    // Ex02: Peça dois números inteiros e mostre a soma deles

    print("\nDigite um número: ");
    val num1 = readln().toIntOrNull();

    print("Digite outro número: ");
    val num2 = readln().toIntOrNull();

    if(num1 != null && num2 != null) {
        val soma = num1 + num2;
        println("A soma dos números ${num1} e ${num2} é ${soma}");
    } else {
        println("Um dos números informados é nulo...");
    }


    // ---------------------------------------------------------------------------


    // Ex03: Leia um número inteiro e mostre se ele é par ou ímpar

    print("\nDigite um número: ");
    val num = readln().toIntOrNull();

    if(num != null) {
        if (num % 2 == 0) {
            println("O número informado é par! :)");
        } else {
            println("O número informado é ímpar! :)");
        }
    }


    // ---------------------------------------------------------------------------


    // Ex04: Solicite três notas (decimais) e calcule a média

    print("\nNota 01: ");
    val n1 = readln().toFloatOrNull();

    print("Nota 02: ");
    val n2 = readln().toFloatOrNull();

    print("Nota 03: ");
    val n3 = readln().toFloatOrNull();


    if(n1 != null && n2 != null && n3 != null){
        val media = (n1 + n2 + n3) / 3;

        if(media >= 6){
            println("O aluno está aprovado :)");
        } else if(media >= 4 || media < 6) {
            println("O aluno está em recuperação...");
        } else {
            println("O aluno está reprovado :(");
        }
    }


    // ---------------------------------------------------------------------------


    // Ex05: Crie um programa que leia um valor em graus Celsius e pergunte se o usuário quer
    //converter para Fahrenheit ou Kelvin.

    print("\nDigite o valor em graus Celsius: ");
    val valor = readln().toFloatOrNull();

    if(valor != null){
        print("Deseja converter para Fahrenheit(1) ou para Kelvin(2)? : ");
        val escolha = readln().toIntOrNull();

        if(escolha != null){
            if(escolha == 1){
                val valorF = (valor * (9/5)) + 32;
                println("Valor em Fahrenheit: ${valorF}");

            } else if(escolha == 2){
                val valorK = valor + 273.45;
                println("Valor em Kelvin: ${valorK}");

            } else {
                println("A escolha é inválida...");

            }
        } else {
            println("O valor informado está nulo...");
        }

    } else {
        println("O valor está nulo...");
    }
}