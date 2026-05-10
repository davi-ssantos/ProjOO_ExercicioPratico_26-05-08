# Lógica de Negócio

Este documento descreve os fluxos principais do sistema de reserva de salas, detalhando como as classes e padrões de projeto interagem para atender cada requisito funcional.

O sistema permite que estudantes e professores consultem disponibilidade de salas, façam reservas e recebam notificações sobre alterações ou conflitos. Toda interação do usuário é com `SistemaDeReservas`, que orquestra os subsistemas internos de forma transparente.

---
## 1. Criação de uma Reserva

### Requisito(s) atendido(s)
RF-02, RF-03

### Fluxo
1. O usuário solicita uma reserva informando sala, data e horário via `cli`;
2. O `cli` chama `SistemaDeReservas.criarReserva()`;
3. `SistemaDeReservas` consulta o `RepositorioSalas` para buscar as reservas existentes no intervalo solicitado;
4. `SistemaDeReservas` chama `PoliticaDeReserva.validar()` passando a reserva nova e as reservas existentes no intervalo:
	- Se a política rejeitar, o fluxo é interrompido e o usuário é notificado do conflito;
	- Se a política aprovar, o fluxo continua.
5. `SistemaDeReservas` monta a lista de observadores - `UsuarioObservador` para o usuário solicitante e `ServicoRelatorio`;
6. `SistemaDeReservas` instancia a `Reserva` passando os observadores no construtor - o status inicial é `CONFIRMADA`;
7. `Reserva.confirmar()` é chamado, que internamente chama `notificarObservadores()` disparando o evento `CRIACAO` para todos os observadores registrados;
8. A reserva é adicionada ao `RepositorioSalas`.

### Classes envolvidas
`SistemaDeReservas`, `PoliticaDeReserva`, `Reserva`, `RepositorioSalas`, `UsuarioObservador`, `ServicoRelatorio`, `Evento`, `TipoEvento`

---
## 2. Modificação de uma Reserva

### Requisito(s) atendido(s)
RF-02, RF-03, RF-04

### Fluxo
1. O usuário solicita a modificação de uma reserva existente informando o novo intervalo de tempo via `cli`;
2. O `cli` chama `SistemaDeReservas.modificarReserva()`;
3. `SistemaDeReservas` busca a reserva em `RepositorioSalas` pelo id;
4. `SistemaDeReservas` chama `PoliticaDeReserva.validar()` para o novo intervalo - se houver conflito, interrompe o fluxo;
5. `Reserva.modificar()`  é chamado com o novo intervalo, atualiza o status para `MODIFICADA` e dispara `notificarObservadores()` com o evento `MODIFICACAO.
### Classes envolvidas
`SistemaDeReservas`, `PoliticaDeReserva`, `Reserva`, `RepositorioSalas`, `UsuarioObservador`, `ServicoRelatorio`, `Evento`, `TipoEvento`

---
## 3. Cancelamento de uma Reserva

### Requisito(s) atendido(s)
RF-02, RF-04

### Fluxo
1. O usuário solicita a modificação de uma reserva via `cli`;
2. O `cli` chama `SistemaDeReservas.cancelarReserva()`;
3. `SistemaDeReservas` busca a reserva em `RepositorioSalas` pelo id;
4. `Reserva.modificar()`  é chamado, atualiza o status para `CANCELADA` e dispara `notificarObservadores()` com o evento `CANCELAMENTO`;
5. A reserva é removida de `RepositorioSalas`;
### Classes envolvidas
`SistemaDeReservas`, `Reserva`, `RepositorioSalas`, `UsuarioObservador`, `ServicoRelatorio`, `Evento`, `TipoEvento`

---
## 4. Geração de Relatório Diário
### Requisito(s) atendido(s)
RF-05

### Fluxo
1. O usuário solicita o relatório diário via `cli`;
2. O `cli` chama `SistemaDeReservas.gerarRelatorioDiario()`;
3. `SistemaDeReservas` instancia `VisitorRelatorioDiario` com a data atual;
4. `SistemaDeReservas` busca todas as reservas do dia no `RepositorioSalas` via `listarReservasPorData()`;
5. Para cada reserva, chama `reserva.aceitar(visitor)` - o visitor verifica se a reserva é do dia e acumula ela na lista interna;
6. `VisitorRelatorioDiario.gerarRelatorio()` formata e retorna o relatório como texto, exibido pelo `cli`.
### Classes envolvidas
`SistemaDeReservas`, `VisitorRelatorioDiario`, `Reserva`, `RepositorioSalas`

---
## 5. Consulta de Salas Disponíveis
### Requisito(s) atendido(s)
RF-01

### Fluxo
1. O usuário solicita as salas disponíveis em um intervalo via `cli`;
2. O `cli` chama `SistemaDeReservas.listarSalasPorIntervalo()`;
3. `SistemaDeReservas` consulta o `RepositorioSalas`;
4. `RepostorioSalas` delega ao `SalaProxy`as buscas de salas não carregadas em memória - o proxy carrega do arquivo se necessário;
5. O sistema filtra as salas sem reservas conflitantes no intervalo e retorna a lista ao `cli`.
### Classes envolvidas
`SistemaDeReservas`, `RepositorioSalas`, `SalaProxy`, `Sala`

---
São estes todos os fluxos lógicos por trás das interações possíveis e requisitadas entre o usuário e `SistemaDeReservas` via `cli.