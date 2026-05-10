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