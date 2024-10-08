package br.com.alura.model

data class Jogo(
    val titulo: String,
    val capa: String,
    var descricao: String? = null,
    var preco: Double = 0.0
) {

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Meu br.com.alura.model.Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }
}