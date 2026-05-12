package main.br.unifesp.reservasalas.patterns.visitor;

import main.br.unifesp.reservasalas.domain.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitorRelatorioDiario implements VisitorRelatorio {

    private LocalDate       data;
    private List<Reserva>   relatorio;

    public VisitorRelatorioDiario(LocalDate data) {
        this.data       = data;
        this.relatorio  = new ArrayList<>();
    }

    public LocalDate getData() { return data; }

    @Override
    public void visitar(Reserva reserva) {
        if (reserva.getInicio().toLocalDate().equals(data)) {
            relatorio.add(reserva);
        }
    }

    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Relatório Diário: ").append(data).append(" ===\n");
        for (Reserva reserva : relatorio) {
            sb.append("Sala: ").append(reserva.getSala().getNome())
                    .append(" | Usuário: ").append(reserva.getUsuario().getNome())
                    .append(" | Início: ").append(reserva.getInicio())
                    .append(" | Fim: ").append(reserva.getFim())
                    .append(" | Status: ").append(reserva.getStatus())
                    .append("\n");
        }
        return sb.toString();
    }
}