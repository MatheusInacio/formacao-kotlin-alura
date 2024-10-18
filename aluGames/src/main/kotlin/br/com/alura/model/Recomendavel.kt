package br.com.alura.model

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}