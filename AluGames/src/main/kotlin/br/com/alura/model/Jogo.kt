package br.com.alura.model

data class Jogo(
    val titulo: String,
    val capa: String
) {
    var descricao:String? = null
    override fun toString(): String {
        return "Meu br.com.alura.model.Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }
}