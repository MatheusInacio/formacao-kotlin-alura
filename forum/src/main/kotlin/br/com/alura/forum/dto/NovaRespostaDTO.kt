package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

class NovaRespostaDTO(
    @field:NotEmpty
    var mensagem: String,
    var idAutor: Long,
)
