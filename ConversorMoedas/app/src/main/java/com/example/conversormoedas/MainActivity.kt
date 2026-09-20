package com.example.conversormoedas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAXA_DOLAR = 5.14
        const val TAXA_EURO = 5.89
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val moedaOrigem = findViewById<Spinner>(R.id.spinner_moeda_origem);
        val moedaDestino = findViewById<Spinner>(R.id.spinner_moeda_destino);

        val bandeiraOrigem = findViewById<ImageView>(R.id.img_bandeira01);
        val bandeiraDestino = findViewById<ImageView>(R.id.img_bandeira02);

        val valor = findViewById<EditText>(R.id.text_number_valor);
        val resultado = findViewById<TextView>(R.id.text_resultado);

        val bntConverter = findViewById<Button>(R.id.btn_converter);


        // Eu pesquisei essa parte: '.onItemSelectedListener = object : AdapterView.OnItemSelectedListener'
        // Só com o when, as bandeiras não mudavam

        moedaOrigem.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val moedaTextoOrigem = moedaOrigem.selectedItem.toString();

                when (moedaTextoOrigem){
                    "REAL" -> bandeiraOrigem.setImageResource(R.drawable.img_bandeira_brasil);
                    "DÓLAR" -> bandeiraOrigem.setImageResource(R.drawable.img_bandeira_eua);
                    "EURO" -> bandeiraOrigem.setImageResource(R.drawable.img_bandeira_europa);
                    else -> println("Opção inválida");
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        moedaDestino.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val moedaTextoDestino = moedaDestino.selectedItem.toString();

                when (moedaTextoDestino){
                    "REAL" -> bandeiraDestino.setImageResource(R.drawable.img_bandeira_brasil);
                    "DÓLAR" -> bandeiraDestino.setImageResource(R.drawable.img_bandeira_eua);
                    "EURO" -> bandeiraDestino.setImageResource(R.drawable.img_bandeira_europa);
                    else -> println("Opção inválida");
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }


        bntConverter.setOnClickListener {
            val moedaTextoOrigem = moedaOrigem.selectedItem.toString();
            val moedaTextoDestino = moedaDestino.selectedItem.toString();

            val valorDigitado = valor.text.toString().toDoubleOrNull();

            if(valorDigitado != null) {
                var conversao = 0.0;

                if (moedaTextoOrigem.equals("REAL") && moedaTextoDestino.equals("DÓLAR")) {
                    conversao = valorDigitado / TAXA_DOLAR;
                    resultado.text = "$" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("REAL") && moedaTextoDestino.equals("EURO")) {
                    conversao = valorDigitado / TAXA_EURO;
                    resultado.text = "€" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("DÓLAR") && moedaTextoDestino.equals("REAL")) {
                    conversao = valorDigitado * TAXA_DOLAR;
                    resultado.text = "R$" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("DÓLAR") && moedaTextoDestino.equals("EURO")) {
                    conversao = (valorDigitado * TAXA_DOLAR) / TAXA_EURO;
                    resultado.text = "€" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("EURO") && moedaTextoDestino.equals("REAL")) {
                    conversao = valorDigitado * TAXA_EURO;
                    resultado.text = "R$" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("EURO") && moedaTextoDestino.equals("DÓLAR")) {
                    conversao = (valorDigitado * TAXA_EURO) / TAXA_DOLAR;
                    resultado.text = "$" + String.format("%.2f", conversao);
                }

            } else {
                valor.error = "Digite um valor válido";
            }
        }
    }
}