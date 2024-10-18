package br.com.alura.model

import br.com.alura.utils.formatoComDuasCasasDecimais
import com.google.gson.annotations.Expose
import java.math.BigDecimal

data class Jogo(
    @Expose
    val titulo: String,
    @Expose val capa: String,
) : Recomendavel {
    var id = 0
    var descricao: String? = null
    var preco: BigDecimal = BigDecimal(0)
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            println("Nota inválida. Insira uma nota entre 1 e 10")
        } else {
            listaNotas.add(nota)
        }
    }

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String) :
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String? , id: Int = 0) :
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: $preco \n" +
                "Reputação: $media\n" +
                "Id: $id"
    }

}