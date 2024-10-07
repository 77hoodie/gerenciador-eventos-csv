package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

class AppTest {

    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testCadastrarEvento() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
        gerenciador.cadastrarEvento(evento);
        assertNotNull(gerenciador.buscarEventoPorNome("Evento Teste"));
    }

    @Test
    void testListarEventos() {
    GerenciadorEventos gerenciador = new GerenciadorEventos();
    Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
    gerenciador.cadastrarEvento(evento);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    gerenciador.listarEventos();

    System.setOut(originalOut);

    String expectedOutput = "Nome: Evento Teste, Data: 2023-10-01, Local: Local Teste, Capacidade: 100";
    assertTrue(outContent.toString().contains(expectedOutput));
}

    @Test
    void testBuscarEventoPorNome() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
        gerenciador.cadastrarEvento(evento);
        Evento eventoBuscado = gerenciador.buscarEventoPorNome("Evento Teste");
        assertNotNull(eventoBuscado);
        assertEquals("Evento Teste", eventoBuscado.getNome());
    }

    @Test
    void testInscreverParticipante() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
        gerenciador.cadastrarEvento(evento);
        evento.inscreverParticipante("Participante Teste", Evento.TicketCategory.VIP);
        assertTrue(evento.getParticipantes().contains("Participante Teste"));
    }

    @Test
    void testExportarEventosParaCSV() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
        gerenciador.cadastrarEvento(evento);
        String filePath = "test.csv";
        gerenciador.exportarEventosParaCSV(filePath);
        File file = new File(filePath);
        assertTrue(file.exists());
        file.delete();
    }

    @Test
    void testNumeroMaximoDeEventos() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        for (int i = 1; i <= 10; i++) {
            Evento evento = new Evento("Evento Teste " + i, "2023-10-01", "Local Teste", 100);
            gerenciador.cadastrarEvento(evento);
        }
        Evento eventoLimite = new Evento("Evento Teste 11", "2023-10-01", "Local Teste", 100);
        assertThrows(IllegalStateException.class, () -> {
            gerenciador.cadastrarEvento(eventoLimite);
        });
    }

    class Teste {
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testCadastrarEvento() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
        gerenciador.cadastrarEvento(evento);
        assertNotNull(gerenciador.buscarEventoPorNome("Evento Teste"));
    }

    @Test
    void testListarEventos() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
        gerenciador.cadastrarEvento(evento);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        gerenciador.listarEventos();

        System.setOut(originalOut);

        String expectedOutput = "Evento Teste, 2023-10-01, Local Teste, 100";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    void testBuscarEventoPorNome() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
        gerenciador.cadastrarEvento(evento);
        Evento eventoBuscado = gerenciador.buscarEventoPorNome("Evento Teste");
        assertNotNull(eventoBuscado);
        assertEquals("Evento Teste", eventoBuscado.getNome());
    }

    @Test
    void testInscreverParticipante() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
        gerenciador.cadastrarEvento(evento);
        evento.inscreverParticipante("Participante Teste", Evento.TicketCategory.VIP);
        assertTrue(evento.getParticipantes().contains("Participante Teste"));
    }

    @Test
    void testExportarEventosParaCSV() {
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        Evento evento = new Evento("Evento Teste", "2023-10-01", "Local Teste", 100);
        gerenciador.cadastrarEvento(evento);
        String filePath = "test.csv";
        gerenciador.exportarEventosParaCSV(filePath);
        File file = new File(filePath);
        assertTrue(file.exists());
        file.delete(); // Clean up the test file
    }
}    
}
