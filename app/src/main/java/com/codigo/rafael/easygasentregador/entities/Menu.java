package com.codigo.rafael.easygasentregador.entities;

import java.io.Serializable;

/**
 * Created by Rafael Carlos Oliveira on 02/10/2017.
 */

public class Menu implements Serializable {

    private String titulo;
    private String bairro;
    private double distancia;
    private int foto;
    private String valor;

    public Menu() {
    }

    public Menu(String titulo, String bairro, double distancia, int foto, String valor) {
        this.titulo = titulo;
        this.bairro = bairro;
        this.distancia = distancia;
        this.foto = foto;
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "titulo='" + titulo + '\'' +
                ", bairro='" + bairro + '\'' +
                ", distancia=" + distancia +
                ", foto=" + foto +
                ", valor='" + valor + '\'' +
                '}';
    }
}
