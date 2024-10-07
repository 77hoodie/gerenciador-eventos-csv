package com.example;

import java.util.ArrayList;
import java.util.List;


public class Evento {
    public enum TicketCategory {
        LON("Longe do palco", 50),
        PROX("Próximo ao palco", 100),
        VIP("VIP", 200),
        CAM("Camarote", 300);

        private final String description;
        private final int price;

        TicketCategory(String description, int price) {
            this.description = description;
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public int getPrice() {
            return price;
        }
    }

    private String nome;
    private String data;
    private String local;
    private int capacidadeMaxima;
    private int vagasDisponiveis;
    private List<String> participantes;
    private List<TicketCategory> categorias;

    public Evento(String nome, String data, String local, int capacidadeMaxima) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMaxima = capacidadeMaxima;
        this.vagasDisponiveis = capacidadeMaxima;
        this.participantes = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public List<String> getParticipantes() {
        return participantes;
    }


    
    public void inscreverParticipante(String nomeParticipante, TicketCategory categoria) {
        if (vagasDisponiveis > 0) {
            participantes.add(nomeParticipante);
            categorias.add(categoria);
            vagasDisponiveis--;
            System.out.println("Participante inscrito com sucesso.");
        } else {
            System.out.println("Evento esgotado.");
        }
    }

    public String detalhes() {
        return String.format("Nome: %s, Data: %s, Local: %s, Vagas: %d", nome, data, local, vagasDisponiveis);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", local='" + local + '\'' +
                '}';
    }

}