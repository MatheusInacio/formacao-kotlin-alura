package br.com.alura.utils

import br.com.alura.model.InfoJogoJson
import br.com.alura.model.Jogo
import br.com.alura.model.JogoEntity

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao, this.id)
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao, this.id)
}