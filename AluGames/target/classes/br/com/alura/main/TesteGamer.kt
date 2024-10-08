package br.com.alura.main

import br.com.alura.model.Gamer

fun main() {

    val gamer1 = Gamer("Matheus", "matheus@gmail.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Jeni",
        "jeni@email.com",
        "19/19/1992",
        "jeniblo"
    )
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "jacqueskywalker"
    }
    println(gamer1)


}