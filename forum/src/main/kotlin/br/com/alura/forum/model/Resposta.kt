package br.com.alura.forum.model

import java.time.LocalDateTime

class Resposta(
    var id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    var autor: Usuario,
    var topico: Topico? = null,
    val solucao: Boolean = false
)