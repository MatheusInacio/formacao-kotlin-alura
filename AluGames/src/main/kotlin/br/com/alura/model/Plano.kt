package br.com.alura.model

import java.math.BigDecimal

sealed class Plano(val tipo: String) {
    open fun obterValor(aluguel: Aluguel): BigDecimal {
        return aluguel.jogo.preco * aluguel.periodo.emDias.toBigDecimal()
    }
}