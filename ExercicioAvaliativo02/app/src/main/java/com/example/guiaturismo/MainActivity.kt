package com.example.guiaturismo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.guiaturismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        
        val dados = resources.getStringArray(R.array.destinos);
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dados);
        binding.listaDestinos.adapter = adapter;


        binding.listaDestinos.setOnItemClickListener {parent, view, position, id ->
            var destino = dados[position];
            var intent = Intent(this, DetalhesActivity::class.java);

            if(destino.equals("Alemanha")){
                intent.putExtra("bandeira_destino", R.drawable.bandeira_alemanha);
                intent.putExtra("nome_pais", "ALEMANHA");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_alemanha);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_alemanha_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_alemanha);
                startActivity(intent);
            }

            if(destino.equals("Brasil")){
                intent.putExtra("bandeira_destino", R.drawable.bandeira_brasil);
                intent.putExtra("nome_pais", "BRASIL");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_brasil);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_brasil_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_brasil);
                startActivity(intent);
            }

            if(destino.equals("Egito")){
                intent.putExtra("bandeira_destino", R.drawable.bandeira_egito);
                intent.putExtra("nome_pais", "EGITO");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_egito);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_egito_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_egito);
                startActivity(intent);
            }

            if(destino.equals("Finlândia")){
                intent.putExtra("bandeira_destino", R.drawable.bandeira_finlandia);
                intent.putExtra("nome_pais", "FINLÂNDIA");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_finlandia);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_finlandia_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_finlandia);
                startActivity(intent);
            }

            if(destino.equals("França")){
                intent.putExtra("bandeira_destino", R.drawable.bandeira_franca);
                intent.putExtra("nome_pais", "FRANÇA");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_franca);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_franca_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_franca);
                startActivity(intent);
            }

            if(destino.equals("Grécia")){
                intent.putExtra("bandeira_destino", R.drawable.bandeira_grecia);
                intent.putExtra("nome_pais", "GRÉCIA");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_grecia);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_grecia_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_grecia);
                startActivity(intent);
            }

            if(destino.equals("Holanda")){
                intent.putExtra("bandeira_destino", R.drawable.bandeira_holanda);
                intent.putExtra("nome_pais", "HOLANDA");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_holanda);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_holanda_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_holanda);
                startActivity(intent);
            }

            if(destino.equals("Índia")){
                intent.putExtra("bandeira_destino", R.drawable.bandeira_india);
                intent.putExtra("nome_pais", "ÍNDIA");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_india);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_india_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_india);
                startActivity(intent);
            }

            if(destino.equals("Itália")){
                intent.putExtra("bandeira_destino", R.drawable.bandeira_italia);
                intent.putExtra("nome_pais", "ITÁLIA");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_italia);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_italia_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_italia);
                startActivity(intent);
            }

            if(destino.equals("Japão")) {
                intent.putExtra("bandeira_destino", R.drawable.bandeira_japao);
                intent.putExtra("nome_pais", "JAPÃO");
                intent.putExtra("ponto_turistico", R.drawable.ponto_turistico_japao);
                intent.putExtra("titulo_detalhes_destino", R.string.pacote_japao_titulo);
                intent.putExtra("detalhes_destino", R.string.pacote_japao);
                startActivity(intent);
            }
        }
    }
}