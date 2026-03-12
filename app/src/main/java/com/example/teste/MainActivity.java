package com.example.teste;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Date;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public EditText codigo;
    public EditText assunto;
    public EditText data;
    public  EditText descricao;

    public  int cod;
    public String assunt;
    public Date dat;
    public String desc;

    public Registro registro;

    public Boolean resultadoVerificacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//fim do método

    //coletar dados do formulario
    public void coletarDadosFormulario(View view){
        this.codigo = findViewById(R.id.codigo);//coletando o dado da tela e passando para variável código
        this.assunto = findViewById(R.id.date);//coletando o dado da tela e passando para variável código
        this.data = findViewById(R.id.assunto);//coletando o dado da tela e passando para variável código
        this.descricao = findViewById(R.id.descricao);//coletando o dado da tela e passando para variável código

        this.resultadoVerificacao = this.verificarVazio(codigo, assunto, data, descricao);//verificando se os campos estão vazios
        if(this.resultadoVerificacao == true){
            this.preencherCampos();
        }else{
            this.cod    = Integer.parseInt(this.codigo.getText().toString());
            this.assunt = this.assunto.getText().toString();
            this.desc   = this.descricao.getText().toString();
        }
    }//fim do coletarDados

    public Boolean verificarVazio(EditText codigo, EditText assunto, EditText data, EditText descricao){
        if(codigo.getText().toString().isEmpty() ||
                assunto.getText().toString().isEmpty() ||
        data.getText().toString().isEmpty() ||
                descricao.getText().toString().isEmpty()){
            return true;
        } //fim do if
        return false;

    }//fim do método

    //Método que envia a mensagem de campo em branco

    public void preencherCampos(){
        Toast.makeText(getApplicationContext(), "Preencha os Campos com Dados Válidos!", Toast.LENGTH_SHORT);
    }//

    public Boolean converterData(EditText dataCampo){

        //Realizar a conversão de EDITTEXT - objeto para um dado tipo data
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());//defino o padrão de data que eu quero visualizar
        dataFormatada.setLenient(false);//Evitando datas invalidas, por exemplo: 31/02/2026
        //Guarda o dado do Edittext em um campo String
        String dataTexto = dataCampo.getText().toString();
        try {
            this.dat = (Date) dataFormatada.parse(dataTexto);
            return true;//conversão funcionou
        }catch (ParseException e){
            Toast.makeText(this, "Data Invalida", Toast.LENGTH_SHORT).show();
        }//fim do catch
        return false;
    }//fim do método

    //esse método o que cadastra no banco de dados
    public void cadastrar(View view){
        this.coletarDadosFormulario(view);//chamando o método de coleta de dados
        if(this.resultadoVerificacao != true && this.converterData(this.data) != false){
            this.registro = new Registro(this.cod, this.assunt, this.dat, this.desc);//crio o Objeto registro

            this.db.collection("/registro").add(this.registro).addOnSuccessListener(
                    documentReference -> {
                        Toast msg = Toast.makeText(getApplicationContext(),"Cadastrado com sucesso!", Toast.LENGTH_SHORT);
                        msg.setGravity(Gravity.CENTER, 0, 50);
                        msg.show();
                    }).addOnFailureListener(e->{Log.e("Firebase", "Erro", e);});
        }
    }

}//fim da class