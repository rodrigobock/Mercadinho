# Mercadinho
Projeto desenvolvido para a disciplina de programação 4 no campus IFC Blumenau.

# Requisitos para execução

- JDK 1.8
- Glassfish 6


# INSTRUÇÕES

- Modificar jdbc:user & jdbc:password para usuário e senha do seu localhost MySQL => src\main\resources\META-INF\persistence.xml. Modificar a URL se necessário.
- Executar classe main CriarTabelas para criação de tabelas e valores padrão, com o <property name="jakarta.persistence.schema-generation.database.action" value="drop-and-create"/>, após criação deixar como "none".
- Foi criado um acesso de Administrador, caso queira modificar o acesso apenas trocar o valor da constante _login_ no CriarTabelas.
