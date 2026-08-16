fun main(){
    var num1 = 12;
    var num2: Int = num1;
    num1 = 55;

    println("Hello World");
    println(num1);
    println(num2);

    // -------------------------------------

    // Leitura de dados
    print("\nDigite sua idade: ");
    var idade = readln().toIntOrNull();

    if(idade != null) {
        println("No ano que vem sua idade será ${idade + 1}");
    } else {
        println("Idade digitada de forma incorreta");
    }
}