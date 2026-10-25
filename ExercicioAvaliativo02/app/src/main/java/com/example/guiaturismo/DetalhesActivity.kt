package com.example.guiaturismo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.guiaturismo.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();

        binding = ActivityDetalhesBinding.inflate(layoutInflater);
        setContentView(binding.root);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            insets;
        }


        val bandeira = intent.getIntExtra("bandeira_destino", 0);
        if (bandeira != 0) {
            binding.bandeiraDestino.setImageResource(bandeira);
        }

        val nomePais = intent.getStringExtra("nome_pais");
        binding.nomePais.text = nomePais;

        val pontoTuristico = intent.getIntExtra("ponto_turistico", 0);
        if (pontoTuristico != 0) {
            binding.pontoTuristico.setImageResource(pontoTuristico);
        }

        val detalhesTitulo = intent.getIntExtra("titulo_detalhes_destino", 0);
        if (detalhesTitulo != 0) {
            binding.tituloDetalhesDestino.setText(detalhesTitulo);
        }

        val detalhes = intent.getIntExtra("detalhes_destino", 0);
        if (detalhes != 0) {
            binding.detalhesDestino.setText(detalhes);
        }


        binding.telefone.setOnClickListener {
            val numero = "";
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("$numero");
            }
            startActivity(intent);
        }

        binding.email.setOnClickListener {
            val email = "contato@ifsp.edu.br";
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("$email")
                putExtra(Intent.EXTRA_SUBJECT, "Dúvida sobre o Pacote de Viagem");
            }
            startActivity(intent);
        }

        binding.mapa.setOnClickListener {
            val uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=${Uri.encode(nomePais)}");
            val mapIntent = Intent(Intent.ACTION_VIEW, uri);
            startActivity(mapIntent);
        }

        binding.btnVoltar.setOnClickListener {
            finish();
        }
    }
}