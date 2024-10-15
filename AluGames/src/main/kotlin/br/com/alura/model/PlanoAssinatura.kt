package br.com.alura.model

import java.math.BigDecimal

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: BigDecimal,
    id: Int = 0
) : Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): BigDecimal {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size + 1

        return if (totalJogosNoMes <= jogosIncluidos) {
            BigDecimal(0)
        } else {
            var valorOriginal = super.obterValor(aluguel)
            if (aluguel.gamer.media > 8) {
                valorOriginal -= valorOriginal.multiply(percentualDescontoReputacao)
            }
            valorOriginal
        }
    }

}