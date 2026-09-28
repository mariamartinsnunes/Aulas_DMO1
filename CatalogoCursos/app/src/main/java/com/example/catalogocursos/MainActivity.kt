package com.example.catalogocursos

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.catalogocursos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dados = resources.getStringArray(R.array.cursos);
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dados);

        binding.listaCursos.adapter = adapter;

        binding.listaCursos.setOnItemClickListener { parent, view, position, id ->
            var cursoSelecionado = dados[position];

            if(cursoSelecionado.equals("Sistemas para Internet")){
                binding.descricaoCurso.text = getString(R.string.desc_tsi);
            }
            if(cursoSelecionado.equals("Engenharia Mecânica")){
                binding.descricaoCurso.text = getString(R.string.desc_eng);
            }
            if(cursoSelecionado.equals("Análise e Desenvolvimento de Sistemas")){
                binding.descricaoCurso.text = getString(R.string.desc_ads);
            }
            if(cursoSelecionado.equals("Licenciatura em Matemática")){
                binding.descricaoCurso.text = getString(R.string.desc_mat);
            }
        }
    }
}