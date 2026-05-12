package main.br.unifesp.reservasalas.patterns.visitor;

import main.br.unifesp.reservasalas.domain.Reserva;

import java.util.ArrayList;
import java.util.List;

public class VisitorHistoricoSala implements VisitorRelatorio {

    private String          salaId;
    private List<Reserva>   historico;

    public VisitorHistoricoSala(String salaId) {
        this.salaId     = salaId;
        this.historico  = new ArrayList<>();
    }

    public String getSalaId() { return salaId; }

    @Override
    public void visitar(Reserva reserva) {
        if (reserva.getSala().getId().equals(salaId)) {
            historico.add(reserva);
        }
    }

    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Histórico da Sala: ").append(salaId).append(" ===\n");
        for (Reserva reserva : historico) {
            sb.append("Usuário: ").append(reserva.getUsuario().getNome())
                    .append(" | Início: ").append(reserva.getInicio())
                    .append(" | Fim: ").append(reserva.getFim())
                    .append(" | Status: ").append(reserva.getStatus())
                    .append("\n");
        }
        return sb.toString();
    }
}