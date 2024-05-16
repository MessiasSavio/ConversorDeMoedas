package com.classes.principal;

import com.classes.valores.ArmazenarMoedas;
import com.classes.valores.Formatacao;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Scanner leitura1 = new Scanner(System.in);
        Scanner respostaConversor = new Scanner(System.in);
        Scanner moeda1 = new Scanner(System.in);
        Scanner moeda2 = new Scanner(System.in);
        ArmazenarMoedas casaDeCambio =  new ArmazenarMoedas();

        List<String> moedasLidas = casaDeCambio.getMoedasDoArquivo("moedas.txt");

        Formatacao formatacao = new Formatacao();

        int busca = 0;
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (busca != 7) {
            System.out.println("""
                    *******************************************************************************************************************
                    Bem-Vindo(a)!
                    Digite o número de umas das opções abaixo:
                        1) Converter Moedas;
                        2) Ver Moedas Disponíveis;
                        3) Cadatrar Uma Moeda;
                        4) Ver cotação de moeda aleatória em Real (BRL);
                        5) Ver Cotação do Dólar (USD) em Real (BRL);
                        6) Ver Cotação do Euro (EUR) em Real (BRL);
                        7) Sair.
                    """);
            busca = leitura1.nextInt();
            switch (busca) {
                case 1:
                    int resposta = 0;
                    while (resposta != 3) {
                        System.out.println("""
                                *******************************************************************************************************************
                                Você optou por converter moedas. Diante disto você pode:
                                1. Ver a lista de moedas disponíveis com a inicial de 3 Digitos;
                                2. Converter moedas (É necessário saber o código de 3 digitos da Moeda);
                                3. Voltar ao menu inicial.
                                                   
                                Digite abaixo uma das três opções abaixo:
                                """);
                        resposta = respostaConversor.nextInt();

                        switch (resposta) {
                            case 1:
                                System.out.println("Moedas cadastradas em nosso sistema:");
                                System.out.println(casaDeCambio.getMoedasDoArquivo("moedas.txt"));
                                break;
                            case 2:
                                double quantidade = 0;
                                boolean entradaValida = false;
                                while (!entradaValida) {
                                    System.out.println("Digite abaixo a quantidade de dinheiro que deseja converter: ");
                                    Scanner opcao = new Scanner(System.in);
                                    String entrada = opcao.nextLine();

                                    try {
                                        quantidade = Double.parseDouble(entrada);
                                        entradaValida = true; // Se não houver exceção, a entrada é válida
                                    } catch (NumberFormatException e) {
                                        System.out.println("Por favor, digite um número válido.");
                                    }
                                }

                                String valorMoeda1 = "";
                                boolean entradaValida1 = false;

                                while (!entradaValida1) {
                                    System.out.println("Digite o código de 3 dígitos da primeira moeda:");
                                    valorMoeda1 = moeda1.nextLine();
                                    // Verifica se o código da moeda tem 3 caracteres
                                    if (valorMoeda1.length() != 3) {
                                        System.out.println("O código da moeda deve ter exatamente 3 dígitos.");
                                        continue; // Pula para a próxima iteração do loop
                                    }
                                    // Verifica se o código da moeda está contido na lista de moedas válidas
                                    if (!moedasLidas.contains(valorMoeda1.toUpperCase())) {
                                        System.out.println("O código da moeda não é válido.");
                                        System.out.println("Moedas Disponíveis");
                                        System.out.println(moedasLidas);
                                        continue; // Pula para a próxima iteração do loop
                                    }
                                    // Se chegarmos aqui, a entrada é válida
                                    entradaValida1 = true;
                                }
                                String valorMoeda2 = "";
                                boolean entradaValida2 = false;
                                while (!entradaValida2) {
                                    System.out.println("Digite o código de 3 dígitos da segunda moeda:");
                                    valorMoeda2 = moeda2.nextLine();
                                    // Verifica se o código da moeda tem 3 caracteres
                                    if (valorMoeda2.length() != 3) {
                                        System.out.println("O código da moeda deve ter exatamente 3 dígitos.");
                                        continue; // Pula para a próxima iteração do loop
                                    }
                                    // Verifica se o código da moeda está contido na lista de moedas válidas
                                    if (!moedasLidas.contains(valorMoeda2.toUpperCase())) {
                                        System.out.println("O código da moeda não é válido.");
                                        System.out.println("Moedas Disponíveis");
                                        System.out.println(moedasLidas);
                                        continue; // Pula para a próxima iteração do loop
                                    }
                                    // Se chegarmos aqui, a entrada é válida
                                    entradaValida2 = true;
                                }

                                   System.out.println(String.format(
                                           "A cotação atual de " + formatacao.converterEmDuasCasasDecimais(quantidade) + " " + valorMoeda1.toUpperCase() + " em " + valorMoeda2.toUpperCase() + " é " +
                                                   formatacao.converterEmDuasCasasDecimais(casaDeCambio.
                                                           conversorDeMoedas(valorMoeda1, valorMoeda2) * quantidade)));
                                break;
                            case 3:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("Entrada Inválida, tente novamente!");
                                break;
                        }
                    }

                case 2:
                    System.out.println("Moedas Cadastradas em nosso sistema:");
                    System.out.println(casaDeCambio.getMoedasDoArquivo("moedas.txt"));
                    break;
                case 3:
                    System.out.println("""
                            Daremos inicio ao cadastro da sua moeda, porém ela deve está
                            dispónivel na lista do link abaixo:
                            https://www.exchangerate-api.com/docs/supported-currencies
                            
                            Diante disto você pode cadastrar uma moeda de 3 caracteres, mais se ela
                            não se encontrar na lista dispónibilida do site, ela não funcionará.
                            
                            Vamos por a mão na massa, Digite o código de 3 digitos que deseja cadastrar:
                            """);
                    Scanner nomeCadastro = new Scanner(System.in);
                    String nome = nomeCadastro.nextLine();
                    while (nome.length() !=3){
                        System.out.println("Código inválido deve contém 3 caracteres. Digite o código de 3 digitos que deseja cadastrar:");
                        nome = nomeCadastro.nextLine();

                    }
                    if (nome.length() == 3) {
                        casaDeCambio.adicionarMoeda(nome.toUpperCase());
                    }
                    break;
                case 4:

                    // Obtenha o tamanho da lista moedasLidas
                    int tamanhoDaLista = moedasLidas.size();

                    // Declare a variável para armazenar o número inteiro
                    int numeroInteiro;

                    // Crie uma instância de Random
                    Random random = new Random();

                    // Gere um número aleatório dentro do intervalo permitido pelo tamanho da lista
                    numeroInteiro = random.nextInt(tamanhoDaLista);
                    String moedaEscolhida = moedasLidas.get(numeroInteiro);
                    System.out.println(String.format("Número da Sorte "+numeroInteiro+ ". A cotação atual de R$1,00 BRL em "+ moedaEscolhida + " é "+
                            formatacao.converterEmDuasCasasDecimais(casaDeCambio.conversorDeMoedas("BRL", moedaEscolhida))));
                    break;
                case 5:
                    System.out.println(String.format("A cotação atual de $1,00 Dólar em Reais é: R$" +formatacao.converterEmDuasCasasDecimais(casaDeCambio.conversorDeMoedas("USD", "BRL"))));
                    break;
                case 6:
                    System.out.println(String.format("A cotação atual de $1,00 Euro em Reais é: R$" +formatacao.converterEmDuasCasasDecimais(casaDeCambio.conversorDeMoedas("EUR", "BRL"))));
                    break;
                case 7:
                    System.out.println("Você digitou o número 7. Você acaba de sair do programa") ;
                    break;
                default:
                    System.out.println("Entrada Inválida, tente novamente!");
                    break;
            }

            /*if(busca == 5) {
                System.out.println(String.format("A cotação atual de $1,00 Dólar em Reais é: R$" +formatacao.converterEmDuasCasasDecimais(casaDeCambio.conversorDeMoedas("USD", "BRL"))));
            } else if (busca == 6) {
                System.out.println(String.format("A cotação atual de $1,00 Euro em Reais é: R$" +formatacao.converterEmDuasCasasDecimais(casaDeCambio.conversorDeMoedas("EUR", "BRL"))));
            }*/
        }



        }
}
