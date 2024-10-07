# gerenciador-eventos-csv
Gerenciador de eventos feito em java que permite cadastrar eventos, listar eventos, importa-lós para .csv e outras funcionalidades. Utiliza as bibliotecas OpenCSV para a exportação dos arquivos e JUnit para testes unitários. O projeto foi gerenciado no Maven.

Requisitos:
Java JDK 8+, 
JUnit 5

No terminal:
1. Cadastrar evento: Digite o nome do evento, a data, o local e a quantidade máxima de participantes (máximo de 10 eventos)
2. Listar eventos cadastrados: Apenas lista os eventos
3. Cadastrar participantes: Cadastra um participante para um evento de escolha
4. Buscar evento por nome: Busca um evento de acordo com o nome
5. Exportar evento para .csv: Exporta o evento no formato .csv. Escolher o caminho do arquivo é opcional, pode-se apenas digitar o nome do mesmo
6. Sair: Sai do programa
