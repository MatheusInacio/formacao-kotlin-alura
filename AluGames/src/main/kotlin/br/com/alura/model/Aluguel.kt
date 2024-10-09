package br.com.alura.model

import java.math.BigDecimal
import java.time.LocalDate
import java.time.Period

data class Aluguel(

    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    val valorAluguel: BigDecimal = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo} por ${gamer.nome} pelo valor R$ " + String.format("%.2f", valorAluguel)
    }
}
