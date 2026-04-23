package com.example.teste;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ConsultarActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RegistroAdapter adapter;//Referencia a classe REGISTROADAPTER
    private List<Registro> lista = new ArrayList<>();
    private FirebaseFirestore db;




    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        recycler = findViewById(R.id.recyclerRegistro);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RegistroAdapter(lista);
        recycler.setAdapter(adapter);


    } //Fim do oncreate
}//fim da ConsultarActivity
