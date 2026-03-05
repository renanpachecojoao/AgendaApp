package com.example.teste;

import java.util.Date;

public class Registro {
    //Declarando variaveis
    private int codigo;
    private String assunto;
    private Date dataEvento;
    private String descricao;
    //criar um construtor sem parâmetro

    public Registro(){
        this.codigo = 0;
        this.assunto = "";
        this.dataEvento = new Date();//0000/00/00
        this.descricao ="";

    }//fim do construtorPadrao

    public Registro(int codigo, String assunto, Date dataEvento, String descricao){
        this.codigo = codigo;
        this.assunto= assunto;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }//fim do método

    //get e sets
    public int getCodigo(){
       return this.codigo;
    }//fim consultar codigo

    public  String getAssunto(){
        return  this.assunto;
    }//fim consultarAssunto

    public  Date getDataEvento(){
        return this.dataEvento;
    }//fim do método

    public String getDescricao(){
        return this.descricao;
    }//fim do método


    public void setCodigo(){
        this.codigo = codigo;
    }//fim do setCodigo

    public void setAssunto(){
        this.assunto = assunto;
    }//fim do setAssunto

    public void setDataEvento(){
        this.dataEvento = dataEvento;
    }// fim do setDataenvento

    public void setDescricao(){
        this.descricao = descricao;
    }//fim do setDescrição

}//fim da class
