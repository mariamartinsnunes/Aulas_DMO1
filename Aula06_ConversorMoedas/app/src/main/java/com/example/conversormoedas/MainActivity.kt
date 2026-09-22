package com.example.conversormoedas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversormoedas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
        const val TAXA_DOLAR = 5.14
        const val TAXA_EURO = 5.89
    }
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Eu pesquisei essa parte: '.onItemSelectedListener = object : AdapterView.OnItemSelectedListener'
        // Só com o when, as bandeiras não mudavam

        binding.moedaOrigem.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val moedaTextoOrigem = binding.moedaOrigem.selectedItem.toString();

                when (moedaTextoOrigem){
                    "REAL" -> binding.bandeiraOrigem.setImageResource(R.drawable.img_bandeira_brasil);
                    "DÓLAR" -> binding.bandeiraOrigem.setImageResource(R.drawable.img_bandeira_eua);
                    "EURO" -> binding.bandeiraOrigem.setImageResource(R.drawable.img_bandeira_europa);
                    else -> println("Opção inválida");
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        binding.moedaDestino.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val moedaTextoDestino = binding.moedaDestino.selectedItem.toString();

                when (moedaTextoDestino){
                    "REAL" -> binding.bandeiraDestino.setImageResource(R.drawable.img_bandeira_brasil);
                    "DÓLAR" -> binding.bandeiraDestino.setImageResource(R.drawable.img_bandeira_eua);
                    "EURO" -> binding.bandeiraDestino.setImageResource(R.drawable.img_bandeira_europa);
                    else -> println("Opção inválida");
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        binding.btnConverter.setOnClickListener {
            val moedaTextoOrigem = binding.moedaOrigem.selectedItem.toString();
            val moedaTextoDestino = binding.moedaDestino.selectedItem.toString();

            val valorDigitado = binding.valor.text.toString().toDoubleOrNull();

            if(valorDigitado != null) {
                var conversao = 0.0;

                if (moedaTextoOrigem.equals("REAL") && moedaTextoDestino.equals("DÓLAR")) {
                    conversao = valorDigitado / TAXA_DOLAR;
                    binding.resultado.text = "$" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("REAL") && moedaTextoDestino.equals("EURO")) {
                    conversao = valorDigitado / TAXA_EURO;
                    binding.resultado.text = "€" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("DÓLAR") && moedaTextoDestino.equals("REAL")) {
                    conversao = valorDigitado * TAXA_DOLAR;
                    binding.resultado.text = "R$" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("DÓLAR") && moedaTextoDestino.equals("EURO")) {
                    conversao = (valorDigitado * TAXA_DOLAR) / TAXA_EURO;
                    binding.resultado.text = "€" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("EURO") && moedaTextoDestino.equals("REAL")) {
                    conversao = valorDigitado * TAXA_EURO;
                    binding.resultado.text = "R$" + String.format("%.2f", conversao);
                }
                if (moedaTextoOrigem.equals("EURO") && moedaTextoDestino.equals("DÓLAR")) {
                    conversao = (valorDigitado * TAXA_EURO) / TAXA_DOLAR;
                    binding.resultado.text = "$" + String.format("%.2f", conversao);
                }

            } else {
                binding.valor.error = "Digite um valor válido";
            }
        }
    }
}