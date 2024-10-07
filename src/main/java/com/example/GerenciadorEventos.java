package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

public class GerenciadorEventos {
    private ArrayList<Evento> eventos;

    public GerenciadorEventos() {
        eventos = new ArrayList<>();
    }

    public void cadastrarEvento(Evento evento) {
        if (eventos.size() < 10) {
            eventos.add(evento);
            System.out.println("Evento cadastrado com sucesso.");
        } else if (eventos.size() >= 10) {
            throw new IllegalStateException("Limite de eventos atingido.");
        }
    }

    public void listarEventos() {
        for (Evento evento : eventos) {
            System.out.println("Nome: " + evento.getNome() + ", Data: " + evento.getData() + ", Local: " + evento.getLocal() + ", Capacidade: " + evento.getVagasDisponiveis());
        }
    }

    public Evento buscarEventoPorNome(String nome) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nome)) {
                return evento;
            }
        }
        return null;
    }

    public void exportarEventosParaCSV(String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] header = { "Nome", "Data", "Local", "Vagas disponiveis" };
            writer.writeNext(header);

            for (Evento evento : eventos) {
                String[] data = { evento.getNome(), evento.getData(), evento.getLocal(), evento.getVagasDisponiveis() + "" };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }


}
