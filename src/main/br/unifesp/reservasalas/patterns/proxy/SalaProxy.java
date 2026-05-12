package main.br.unifesp.reservasalas.patterns.proxy;

import main.br.unifesp.reservasalas.domain.Sala;
import main.br.unifesp.reservasalas.domain.SalaEstudoIndividual;
import main.br.unifesp.reservasalas.enums.TipoSala;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SalaProxy {

    private String              arquivoSalas;
    private Map<String, Sala>   salasCarregadas;

    public SalaProxy(String arquivoSalas) {
        this.arquivoSalas = arquivoSalas;
        this.salasCarregadas = new HashMap<>();
    }

    public Sala buscarSala(String id) {
        if (salasCarregadas.containsKey(id)) {
            return salasCarregadas.get(id);
        }
        return carregarDoArquivo(id);
    }

    private Sala carregarDoArquivo(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoSalas))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes[0].equals(id)) {
                    Sala sala = new SalaEstudoIndividual(partes[0], partes[1],
                            Integer.parseInt(partes[2]));
                    salasCarregadas.put(id, sala);
                    return sala;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar sala do arquivo: " + e.getMessage());
        }
        return null;
    }

    public void salvarNoArquivo(Sala sala) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSalas, true))) {
            writer.write(sala.getId() + "," + sala.getNome() + "," + sala.getCapacidade());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar sala no arquivo: " + e.getMessage());
        }
    }
}