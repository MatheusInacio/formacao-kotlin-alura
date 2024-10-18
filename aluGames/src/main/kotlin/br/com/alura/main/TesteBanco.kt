package br.com.alura.main

import br.com.alura.dados.Banco
import br.com.alura.dados.JogosDAO
import br.com.alura.model.Jogo
import java.math.BigDecimal

fun main() {
    val jogo = Jogo(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        BigDecimal(5.99),
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val jogo2 = Jogo(
        "Dandara",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293",
        BigDecimal(
            9.99
        ),
        "Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania."
    )

    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
//    jogoDAO.adicionarJogo(jogo2)
//    jogoDAO.adicionarJogo(jogo)


    val listaJogos: List<Jogo> = jogoDAO.getLista()
    println(listaJogos)

    manager.close()
}