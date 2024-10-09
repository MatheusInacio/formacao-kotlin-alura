package br.com.alura.model

import java.math.BigDecimal

data class InfoJogoJson(
    val titulo: String,
    val capa: String,
    val preco: BigDecimal,
    val descricao: String
)
