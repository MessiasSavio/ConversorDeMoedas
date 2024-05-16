package com.classes.valores;
import java.text.DecimalFormat;

public class Formatacao {
    public String converterEmDuasCasasDecimais(double valorASerConvertido) {
        DecimalFormat formatacao = new DecimalFormat("#.00");
        return formatacao.format(valorASerConvertido);
    }
}
