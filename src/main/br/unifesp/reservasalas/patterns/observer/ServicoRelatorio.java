package main.br.unifesp.reservasalas.patterns.observer;

public class ServicoRelatorio implements Observador {

    @Override
    public void notificar(Evento evento) {
        System.out.println("[RELATÓRIO] Evento registrado: " +
                evento.getTipo().toString() +
                " | Sala: " + evento.getReserva().getSala().getNome() +
                " | Usuário: " + evento.getReserva().getUsuario().getNome() +
                " | Horário: " + evento.getTimestamp());
    }
}