
package com.classes.valores;
import java.io.IOException;
import java.net.URI;
import java.io.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ArmazenarMoedas {
    private List<String> moedas;

    public ArmazenarMoedas() {
        this.moedas = new ArrayList<    >();
    }

    public List<String> getMoedasDoArquivo(String nomeArquivo) {
        List<String> moedasLidas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                moedasLidas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return moedasLidas;
    }
    public String converterEmDuasCasasDecimais(double valorASerConvertido) {
        // Define o padrão de formatação para garantir o zero à esquerda
        DecimalFormat formatacao = new DecimalFormat("0.00");

        // Configura os símbolos de formatação para usar vírgula como separador decimal
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        formatacao.setDecimalFormatSymbols(symbols);

        return formatacao.format(valorASerConvertido);
    }
    public int pegaIndiceDaMoeda(String valorBuscado) {
        List<String> elementos = new ArrayList<>();
        ArmazenarMoedas dados = new ArmazenarMoedas();
        elementos =dados.getMoedasDoArquivo("moedas.txt");
        int posicao = 1;


        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).equals(valorBuscado)) {
                posicao = i;
                break;
            }else {
                System.out.println("Elemento '" + valorBuscado + "' não encontrado na nossa base de dados.");
            }

        }
        return posicao;

    }
    public double conversorDeMoedas(String busca1, String busca2) {
        String endereco = "https://v6.exchangerate-api.com/v6/1ca33c9ad1767dfd29763c85/pair/" + busca1 + "/" + busca2;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            // Parse do JSON usando Gson
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();

            return conversionRate;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao buscar a taxa de conversão da API: " + e.getMessage(), e);
        }
    }

    public void adicionarMoeda(String nomeMoeda) {
        if(nomeMoeda.length() == 3){
        moedas.add(nomeMoeda);
        }else {
            System.out.println("Valor invalido deve contém 3 caracteres, tente novamente");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("moedas.txt", true));
            for (String moeda : moedas) {
                writer.newLine();
                writer.write(moeda);
            }
            writer.close();
            System.out.println("Moeda salva na base de dados, em " + "moedas.txt");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }


}
