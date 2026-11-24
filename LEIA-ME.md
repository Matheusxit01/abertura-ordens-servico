# abertura-ordens-servico

1. Crie o banco no MySQL: `CREATE DATABASE ordens_servico;` (arquivo banco.sql)
2. Em `src/main/resources/application.properties`, troque `SUA_SENHA` pela senha do seu MySQL.
3. Abra esta pasta no VS Code (File > Open Folder). Precisa das extensões "Extension Pack for Java" e "Spring Boot Extension Pack".
4. Rode `AberturaordensservicoApplication.java` (Run) ou `mvn spring-boot:run` no terminal.
5. Teste em http://localhost:8080/teste
6. Importe `Abertura_de_Ordens_de_Servico.postman_collection.json` no Postman.
