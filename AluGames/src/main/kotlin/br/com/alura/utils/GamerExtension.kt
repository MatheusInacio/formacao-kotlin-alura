package br.com.alura.utils

import br.com.alura.model.Gamer
import br.com.alura.model.GamerEntity
import br.com.alura.model.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.id, this.nome, this.email, this.dataNascimento, this.usuario, this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}