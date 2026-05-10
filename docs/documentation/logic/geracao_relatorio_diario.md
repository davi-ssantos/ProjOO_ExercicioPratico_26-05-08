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