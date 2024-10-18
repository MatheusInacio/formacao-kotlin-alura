package br.com.alura.model

import java.math.BigDecimal

data class Aluguel(

    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    val valorAluguel: BigDecimal = gamer.plano.obterValor(this)
    var id = 0

    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo} por ${gamer.nome} pelo valor R$ " + String.format("%.2f", valorAluguel)
    }
}
