package main.br.unifesp.reservasalas.patterns.factory;

import main.br.unifesp.reservasalas.domain.Laboratorio;
import main.br.unifesp.reservasalas.domain.Sala;
import main.br.unifesp.reservasalas.domain.SalaEstudoIndividual;
import main.br.unifesp.reservasalas.domain.SalaTrabalhoGrupo;
import main.br.unifesp.reservasalas.enums.TipoSala;

public class FabricaDeSalas {

    public static Sala criarSala(TipoSala tipo, String id, String nome, int capacidade) {
        switch (tipo) {
            case INDIVIDUAL:
                return new SalaEstudoIndividual(id, nome, capacidade);
            case GRUPO:
                return new SalaTrabalhoGrupo(id, nome, capacidade, false);
            case LABORATORIO:
                return new Laboratorio(id, nome, capacidade, 0);
            default:
                throw new IllegalArgumentException("Tipo de sala desconhecido: " + tipo);
        }
    }
}