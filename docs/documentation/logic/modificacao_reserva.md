## 2. Modificação de uma Reserva

### Requisito(s) atendido(s)
RF-02, RF-03, RF-04

### Fluxo
1. O usuário solicita a modificação de uma reserva existente informando o novo intervalo de tempo via `cli`;
2. O `cli` chama `SistemaDeReservas.modificarReserva()`;
3. `SistemaDeReservas` busca a reserva em `RepositorioSalas` pelo id;
4. `SistemaDeReservas` chama `PoliticaDeReserva.validar()` para o novo intervalo - se houver conflito, interrompe o fluxo;
5. `Reserva.modificar()`  é chamado com o novo intervalo, atualiza o status para `MODIFICADA` e dispara `notificarObservadores()` com o evento `CRIACAO`.
### Classes envolvidas
`SistemaDeReservas`, `PoliticaDeReserva`, `Reserva`, `RepositorioSalas`, `UsuarioObservador`, `ServicoRelatorio`, `Evento`, `TipoEvento`