package br.com.alura.model

import java.time.LocalDate
import java.time.Period

data class Aluguel(

    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo

) {
    val valorDoAluguel = jogo.preco * periodo.emDias

    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo} por ${gamer.nome} pelo valor R$ " + String.format("%.2f", valorDoAluguel)
    }
}
