package br.com.alura.utils

import br.com.alura.model.Gamer
import br.com.alura.model.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}
