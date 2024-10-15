package br.com.alura.model

import java.math.BigDecimal
import javax.persistence.*
import javax.persistence.GenerationType.*

@Entity
@Table(name = "jogos")
class JogoEntity(
    val titulo: String = "Titulo do jogo",
    val capa: String = "capa do jogo",
    val preco: BigDecimal = BigDecimal(0.0),
    val descricao: String? = null,
    @Id @GeneratedValue(strategy = IDENTITY)
    val id: Int = 0
) {
}