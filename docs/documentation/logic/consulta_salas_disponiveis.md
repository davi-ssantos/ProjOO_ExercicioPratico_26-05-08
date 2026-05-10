## 4. Consulta de Salas Disponíveis
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