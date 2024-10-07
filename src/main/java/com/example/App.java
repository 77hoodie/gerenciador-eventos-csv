package com.example;

import java.util.Scanner;

public final class App {
    private App() {
    }

    /**
     * Main method.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar evento");
            System.out.println("2. Listar eventos");
            System.out.println("3. Inscrever participante");
            System.out.println("4. Buscar evento");
            System.out.println("5. Exportar eventos para CSV");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do evento: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a data do evento: ");
                    String data = scanner.nextLine();
                    System.out.print("Digite o local do evento: ");
                    String local = scanner.nextLine();
                    System.out.print("Digite a capacidade máxima do evento: ");
                    int capacidadeMaxima = scanner.nextInt();
                    scanner.nextLine();
                    Evento evento = new Evento(nome, data, local, capacidadeMaxima);
                    gerenciador.cadastrarEvento(evento);
                    break;

                case 2:
                    gerenciador.listarEventos();
                    break;

                case 3:
                    System.out.print("Digite o nome do evento para inscrição: ");
                    String nomeEventoInscricao = scanner.nextLine();
                    Evento eventoInscricao = gerenciador.buscarEventoPorNome(nomeEventoInscricao);
                    if (eventoInscricao != null) {
                        System.out.print("Digite o nome do participante: ");
                        String nomeParticipante = scanner.nextLine();
                        System.out.println("Escolha a categoria do ingresso:");
                        System.out.println("1. Longe do palco (R$50)");
                        System.out.println("2. Próximo ao palco (R$100)");
                        System.out.println("3. VIP (R$200)");
                        System.out.println("4. Camarote (R$300)");
                        int categoriaOpcao = scanner.nextInt();
                        scanner.nextLine();
                        Evento.TicketCategory categoria;
                        switch (categoriaOpcao) {
                            case 1:
                                categoria = Evento.TicketCategory.LON;
                                break;
                            case 2:
                                categoria = Evento.TicketCategory.PROX;
                                break;
                            case 3:
                                categoria = Evento.TicketCategory.VIP;
                                break;
                            case 4:
                                categoria = Evento.TicketCategory.CAM;
                                break;
                            default:
                                System.out.println("Opção inválida. Ingresso padrão 'Longe do palco' selecionado.");
                                categoria = Evento.TicketCategory.LON;
                        }
                        eventoInscricao.inscreverParticipante(nomeParticipante, categoria);
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do evento para busca: ");
                    String nomeEventoBusca = scanner.nextLine();
                    Evento eventoBuscado = gerenciador.buscarEventoPorNome(nomeEventoBusca);
                    if (eventoBuscado != null) {
                        System.out.println(eventoBuscado.detalhes());
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o caminho do arquivo CSV: ");
                    String filePath = scanner.nextLine();
                    gerenciador.exportarEventosParaCSV(filePath);
                    System.out.println("Eventos exportados com sucesso!");
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }    
}