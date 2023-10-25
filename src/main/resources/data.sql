INSERT INTO usuario (email, username, password, role)
  VALUES ('maria.silva@email.com', 'maria.silva', '$2a$12$w.FQ1PgShIBxXIB4pQlK8umffJRQqH/gnN7gRrWf/H8mFi7o3eW0e', 'ADMIN');
INSERT INTO usuario (email, username, password, role)
  VALUES ('joao.santos@email.com', 'joao.santos', '$2a$12$4P/6ESIz0eau1nUaGGcW8u0qTIvIJkhtzTE1S7m90KQCcfSG7q7oi', 'ADMIN');
INSERT INTO usuario (email, username, password, role)
  VALUES ('ana.pereira@email.com', 'ana.pereira', '$2a$12$w.FQ1PgShIBxXIB4pQlK8umffJRQqH/gnN7gRrWf/H8mFi7o3eW0e', 'CLIENTE');
INSERT INTO usuario (email, username, password, role)
  VALUES ('pedro.oliveira@email.com', 'pedro.oliveira', '$2a$12$4P/6ESIz0eau1nUaGGcW8u0qTIvIJkhtzTE1S7m90KQCcfSG7q7oi', 'CLIENTE');
INSERT INTO usuario (email, username, password, role)
  VALUES ('laura.costa@email.com', 'laura.costa', '$2a$12$Nl.NZ9BT2wGCVI7bfNG9curdE1TBz9LN9O710/kAzONjUtMDk56Me', 'CLIENTE');
INSERT INTO usuario (email, username, password, role)
  VALUES ('luis.rodrigues@email.com', 'luis.rodrigues', '$2a$12$Nl.NZ9BT2wGCVI7bfNG9curdE1TBz9LN9O710/kAzONjUtMDk56Me', 'CLIENTE');
INSERT INTO usuario (email, username, password, role)
  VALUES ('sofia.almeida@email.com', 'sofia.almeida', '$2a$12$Inbks.9Y53HeXaDD4TBQcOtvI.b1UCQuGTDEv9xLaHbcQeIxTFJIu', 'CLIENTE');
INSERT INTO usuario (email, username, password, role)
  VALUES ('miguel.ferreira@email.com', 'miguel.ferreira', '$2a$12$Inbks.9Y53HeXaDD4TBQcOtvI.b1UCQuGTDEv9xLaHbcQeIxTFJIu', 'CLIENTE');
INSERT INTO usuario (email, username, password, role)
  VALUES ('carolina.sousa@email.com', 'carolina.sousa', '$2a$12$I2P7QEGKF7Zr3Oft0B6Wjuy0C7A0imImCNkIYHGIFjGq.PgkryUDC', 'CONVIDADO');
INSERT INTO usuario (email, username, password, role)
  VALUES ('tiago.santos@email.com', 'tiago.santos', '$2a$12$I2P7QEGKF7Zr3Oft0B6Wjuy0C7A0imImCNkIYHGIFjGq.PgkryUDC', 'CONVIDADO');


-- Tarefa 1
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('d633013e-6ea8-48e0-b2a1-0c42adeb3431', 'Comprar mantimentos', 'Preciso comprar leite, pão, ovos e frutas para o café da manhã.', FALSE, '2023-10-17 09:00:00', 'ALTA', 1);

-- Tarefa 2
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('017af59e-e6a3-4a26-81ca-07ecfe81f681', 'Reunião de equipe', 'Participar da reunião de equipe para discutir o projeto X.', FALSE, '2023-10-18 14:30:00', 'MEDIA', 2);

-- Tarefa 3
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('a482e4f2-d275-47ef-bc72-afaf26a32a2f', 'Fazer exercícios', 'Realizar uma sessão de treino de força na academia.', TRUE, '2023-10-19 18:00:00', 'ALTA', 3);

-- Tarefa 4
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('ca6c3621-fcaf-4e80-8985-07a75bc62502', 'Preparar jantar', 'Cozinhar um prato de massa com molho de tomate e salada.', FALSE, '2023-10-20 19:15:00', 'BAIXA', 4);

-- Tarefa 5
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('e699ef16-7fb7-4135-8159-e4b13f12a5b3', 'Estudar para o exame', 'Revisar os tópicos de matemática e história para o exame da escola.', FALSE, '2023-10-21 16:00:00', 'MEDIA', 5);

-- Tarefa 6
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('60357ea6-d9b9-48b9-9c3f-718afa9683a1', 'Consertar a torneira vazando', 'Chamar o encanador para consertar a torneira da cozinha.', TRUE, '2023-10-22 10:30:00', 'BAIXA', 6);

-- Tarefa 7
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('9b1dd733-84b3-470d-ac40-88b0b5236a1e', 'Limpar o sótão', 'Organizar itens no sótão e descartar itens não utilizados.', FALSE, '2023-10-23 11:45:00', 'MEDIA', 7);

-- Tarefa 8
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('6602c9c4-8a44-41cb-803d-4d6d096791f1', 'Agendar consulta médica', 'Ligar para o médico e marcar uma consulta para a próxima semana.', TRUE, '2023-10-24 15:00:00', 'ALTA', 8);

-- Tarefa 9
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('8d18a374-8610-4a71-8fba-6d7427081bed', 'Ler um livro', 'Iniciar a leitura do livro "A Arte da Guerra".', FALSE, '2023-10-25 17:30:00', 'BAIXA', 9);

-- Tarefa 10
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('cf541506-ba7f-4708-bde3-117c9dee3584', 'Consertar o pneu furado', 'Trocar o pneu furado do carro na garagem.', FALSE, '2023-10-26 08:15:00', 'ALTA', 10);

-- Tarefa 11
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('ec766d0f-84c2-482a-8d7f-a082b7bd6562', 'Comprar um presente de aniversário', 'Escolher e comprar um presente para o aniversário do amigo.', FALSE, '2023-10-27 10:30:00', 'MEDIA', 1);

-- Tarefa 12
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('d06ef914-8a82-43e7-a941-34f7f9e3f188', 'Enviar relatório mensal', 'Preparar e enviar o relatório de desempenho mensal para o chefe.', TRUE, '2023-10-28 16:45:00', 'BAIXA', 2);

-- Tarefa 13
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('7e42c777-a126-4242-a7f9-cd9a82890b66', 'Assistir ao jogo de futebol', 'Assistir à partida de futebol do time favorito no estádio.', FALSE, '2023-10-29 20:00:00', 'ALTA', 3);

-- Tarefa 14
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('c481b177-0b8e-4edc-8149-bd21a2ce7206', 'Revisar a apresentação', 'Revisar a apresentação de slides para a reunião de negócios.', FALSE, '2023-10-30 14:30:00', 'MEDIA', 4);

-- Tarefa 15
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('b1e35c68-577f-412f-89d4-f215f85a1d04', 'Regar as plantas', 'Regar todas as plantas de casa.', TRUE, '2023-10-31 09:30:00', 'BAIXA', 5);

-- Tarefa 16
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('661faf77-d8cb-4340-bb33-bd7754de28a9', 'Resolver problema no computador', 'Chamar o técnico de informática para resolver o problema no computador.', FALSE, '2023-11-01 11:00:00', 'MEDIA', 6);

-- Tarefa 17
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('dba44fab-44ab-4d9f-b0e1-af77bc1be8b5', 'Comprar ingressos para o cinema', 'Comprar ingressos para o filme que será exibido amanhã à noite.', TRUE, '2023-11-02 17:45:00', 'ALTA', 7);

-- Tarefa 18
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('70820bb7-8f3d-42aa-8b9e-9ee691723b2f', 'Estudar língua estrangeira', 'Dedicar 30 minutos ao estudo de vocabulário em uma língua estrangeira.', FALSE, '2023-11-03 16:15:00', 'BAIXA', 8);

-- Tarefa 19
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('25f3cfc3-10ab-4295-a249-ee51dd3038ac', 'Consertar a cerca do jardim', 'Reparar a cerca do jardim que está danificada.', FALSE, '2023-11-04 13:30:00', 'ALTA', 9);

-- Tarefa 20
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('1e165774-b1c6-43ca-a176-a39099baef0d', 'Planejar as férias', 'Começar a planejar as férias de verão em família.', TRUE, '2023-11-05 10:00:00', 'MEDIA', 10);

-- Tarefa 21
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('0439e28c-95fc-4dca-9755-2b0f075a2384', 'Comprar um presente de aniversário', 'Escolher e comprar um presente para o aniversário da amiga.', FALSE, '2023-11-06 12:30:00', 'BAIXA', 1);

-- Tarefa 22
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('30be1436-0537-427d-a6d4-47317a70ab46', 'Revisar o plano de negócios', 'Revisar e aprimorar o plano de negócios da empresa.', FALSE, '2023-11-07 14:45:00', 'MEDIA', 2);

-- Tarefa 23
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('68fcf8e3-5728-42fe-9da9-803ec3fa1f47', 'Assistir à aula online', 'Participar da aula online sobre gerenciamento de projetos.', TRUE, '2023-11-08 19:00:00', 'BAIXA', 3);

-- Tarefa 24
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('a482bb41-d04f-4613-ade7-56b6032ebdd7', 'Pintar a sala de estar', 'Comprar tintas e pintar as paredes da sala de estar.', FALSE, '2023-11-09 16:30:00', 'ALTA', 4);

-- Tarefa 25
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('a55c6681-00f7-4d53-8882-2059d3431121', 'Preparar um bolo de aniversário', 'Preparar um bolo caseiro para a festa de aniversário.', TRUE, '2023-11-10 11:45:00', 'ALTA', 5);

-- Tarefa 26
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('9a019c12-d5fd-4a72-b522-d45e43ec2fef', 'Consertar a bicicleta', 'Levar a bicicleta para manutenção e reparos.', FALSE, '2023-11-11 10:15:00', 'MEDIA', 6);

-- Tarefa 27
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('ed0456eb-14b0-4256-8b85-25bd57b7c273', 'Organizar a despensa', 'Reorganizar os alimentos na despensa e verificar a validade dos produtos.', FALSE, '2023-11-12 14:00:00', 'BAIXA', 7);

-- Tarefa 28
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('b3f32e4a-a67a-492a-93f4-0c7e875a26a1', 'Enviar convites para o evento', 'Enviar convites para o evento de caridade da comunidade.', TRUE, '2023-11-13 15:30:00', 'ALTA', 8);

-- Tarefa 29
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('6bcb3d4f-62fd-4493-b9f3-bd26160357b5', 'Estudar para o teste de matemática', 'Dedicar tempo ao estudo para o próximo teste de matemática na escola.', FALSE, '2023-11-14 18:00:00', 'MEDIA', 9);

-- Tarefa 30
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('1c1dd1d5-fd94-499b-a1cf-b9feeddf8cd6', 'Consertar a cerca do jardim', 'Reparar a cerca do jardim que está danificada.', TRUE, '2023-11-15 11:45:00', 'BAIXA', 10);

-- Tarefa 31
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('ff51b126-9c94-4a38-b5d6-52430126c1c8', 'Comprar um presente de aniversário', 'Escolher e comprar um presente para o aniversário do pai.', FALSE, '2023-11-16 09:30:00', 'MEDIA', 1);

-- Tarefa 32
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('adea1a32-e55c-4960-a317-efeb4f136374', 'Revisar o relatório de vendas', 'Revisar e atualizar o relatório de vendas da empresa.', TRUE, '2023-11-17 14:00:00', 'BAIXA', 2);

-- Tarefa 33
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('50f244a3-afe6-48ba-91d5-13c3ab36b8bd', 'Participar da reunião de equipe', 'Participar da reunião de equipe para discutir o projeto em andamento.', FALSE, '2023-11-18 10:15:00', 'ALTA', 3);

-- Tarefa 34
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('5e28fc42-2da6-4d9f-90db-00550536c2da', 'Assistir ao concerto', 'Assistir ao concerto da banda favorita no final de semana.', FALSE, '2023-11-19 19:45:00', 'MEDIA', 4);

-- Tarefa 35
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('6c5a11a0-6f34-40f9-a81d-5382b5e2a48b', 'Estudar para o exame', 'Revisar os tópicos de ciências para o exame na escola.', TRUE, '2023-11-20 12:30:00', 'ALTA', 5);

-- Tarefa 36
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('9f4360e3-9668-4ea0-97b1-19b39518270d', 'Consertar o vazamento da pia', 'Chamar o encanador para consertar o vazamento da pia da cozinha.', FALSE, '2023-11-21 15:00:00', 'BAIXA', 6);

-- Tarefa 37
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('f1b9c3e4-b493-4d5b-b73f-9fd0fee7156c', 'Limpar o sótão', 'Organizar itens no sótão e descartar itens não utilizados.', FALSE, '2023-11-22 10:00:00', 'MEDIA', 7);

-- Tarefa 38
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('1736cc5a-3fc0-4447-830c-9442280a225a', 'Agendar consulta médica', 'Ligar para o médico e marcar uma consulta para a próxima semana.', TRUE, '2023-11-23 14:45:00', 'ALTA', 8);

-- Tarefa 39
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('1baecb73-068f-498c-a5d8-0c3d80eb15c6', 'Ler um livro', 'Iniciar a leitura do livro "A Arte da Guerra".', FALSE, '2023-11-24 16:00:00', 'BAIXA', 9);

-- Tarefa 40
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('f8dcf560-1640-4927-a04b-569c19f02cd1', 'Consertar o pneu furado', 'Trocar o pneu furado do carro na garagem.', FALSE, '2023-11-25 08:30:00', 'ALTA', 10);

-- Tarefa 41
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('78bd7d12-5598-4725-9143-fa87a31716d6', 'Comprar leite', 'Ir ao supermercado e comprar leite', TRUE, '2023-11-26 09:30:00', 'MEDIA', 1);

-- Tarefa 42
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('6b08f6da-48a6-466b-bf5c-2416b7c50543', 'Fazer exercícios', 'Correr por 30 minutos no parque', FALSE, '2023-11-27 10:45:00', 'BAIXA', 2);

-- Tarefa 43
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('20b0b351-b0e4-4def-9f63-5371e6b6df69', 'Preparar jantar', 'Cozinhar um prato de massa com molho de tomate e salada.', TRUE, '2023-11-28 19:30:00', 'MEDIA', 3);

-- Tarefa 44
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('652e8c33-37ff-49b6-8e5b-9ed4550de6c6', 'Estudar para o exame', 'Revisar os tópicos de matemática e história para o exame da escola.', FALSE, '2023-11-29 16:15:00', 'BAIXA', 4);

-- Tarefa 45
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('0fb35189-19f6-455a-9ecb-81a6deb41a30', 'Consertar a torneira vazando', 'Chamar o encanador para consertar a torneira da cozinha.', FALSE, '2023-11-30 12:00:00', 'ALTA', 5);

-- Tarefa 46
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('aeb17d3a-d23e-45ae-b649-493c996949fb', 'Limpar a garagem', 'Organizar ferramentas e limpar a garagem', TRUE, '2023-12-01 14:30:00', 'MEDIA', 6);

-- Tarefa 47
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('a62eb538-d1c7-442d-8100-472593eeb0b9', 'Escrever um artigo', 'Iniciar a escrita de um artigo sobre um tópico de interesse.', FALSE, '2023-12-02 11:15:00', 'BAIXA', 7);

-- Tarefa 48
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('a7255bd9-3439-40f0-9c5f-bf6af94d6657', 'Comprar um presente de aniversário', 'Escolher e comprar um presente para o aniversário do cônjuge.', FALSE, '2023-12-03 16:45:00', 'ALTA', 8);

-- Tarefa 49
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('0152c7db-9b12-4420-b423-4d3ce3be1137', 'Estudar para o teste de história', 'Dedicar tempo ao estudo para o próximo teste de história na escola.', TRUE, '2023-12-04 17:30:00', 'MEDIA', 9);

-- Tarefa 50
INSERT INTO todo_item (uuid, titulo, descricao, concluido, data_hora, prioridade, usuario_id)
VALUES
    ('24ca5778-6a7a-4f1f-a808-4c43af8583a3', 'Planejar a festa de aniversário', 'Começar a planejar a festa de aniversário para o filho.', FALSE, '2023-12-05 20:00:00', 'BAIXA', 10);
