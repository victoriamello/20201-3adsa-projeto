package com.example.projetosprint;

public class LivroCompra implements Vendas {
        private String nome;
        private String autor;
        private Double valor;
        private Integer quantidade;

    public LivroCompra ( String nome, String autor, Double valor, Integer quantidade ) {
        this.nome = nome;
        this.autor = autor;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
            return nome;
        }

        public String getAutor() {
            return autor;
        }

    public Double getValor () {
        return valor;
    }

    public Integer getQuantidade () {
        return quantidade;
    }

    public Double getValorVenda(){
        return quantidade * valor;
    }

}

