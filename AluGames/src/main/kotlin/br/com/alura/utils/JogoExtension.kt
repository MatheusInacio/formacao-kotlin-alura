package br.com.alura.utils

import br.com.alura.model.InfoJogoJson
import br.com.alura.model.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}