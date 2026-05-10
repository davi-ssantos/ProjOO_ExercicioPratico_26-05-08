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