package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnCadastrar, btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        //Chamando class superior
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//modificando a tela, reconheçendo os botões

        this.btnCadastrar = findViewById(R.id.btnCadastrar);//Botão cadastrar - referência
        this.btnConsultar = findViewById(R.id.btnConsultar);//Botão consultrar

        //Ativar os botões

        this.btnCadastrar.setOnClickListener(view->{
            Intent intent = new Intent(MainActivity.this, CadastrarActivity.class);
            startActivity(intent);

        });//fim do botão cadastrar

        this.btnConsultar.setOnClickListener(view->{
            Intent intent = new Intent(MainActivity.this, ConsultarActivity.class);
            startActivity(intent);

        });//fim do botão consulta
    }//Fim do onCreate



}//Fim da Main
