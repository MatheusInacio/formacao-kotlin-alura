package br.com.alura.main

import br.com.alura.model.Periodo
import br.com.alura.model.PlanoAssinatura
import br.com.alura.model.PlanoAvulso
import br.com.alura.services.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
//    val jogoApi = consumo.buscaJogo("151")
    val listaJogosJson = consumo.buscaJogosJson()

//    println(listaGamers)
//    println(jogoApi)
//    print(listaJogosJson)

    val gamerCaroline = listaGamers.get(3)
    gamerCaroline.plano = PlanoAssinatura("PRATA", 9.90, 3, BigDecimal(0.15))
    val gamerGuilherme = listaGamers.get(2)
    gamerGuilherme.plano = PlanoAvulso("BRONZE")
    val jogoResidentVillage = listaJogosJson.get(10)
    val jogoSpider = listaJogosJson.get(13)
    val jogoTheLastOfUs = listaJogosJson.get(2)
    val jogoAssassins = listaJogosJson.get(4)
    val jogoCyber = listaJogosJson.get(6)
    val jogoGod = listaJogosJson.get(7)
    val jogoSkyrim = listaJogosJson.get(18)

//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
//    val periodo4 = Periodo(LocalDate.of(2023, 8, 2), LocalDate.of(2023, 8, 15))

    gamerGuilherme.recomendarJogo(jogoResidentVillage, 7)
    gamerGuilherme.recomendarJogo(jogoTheLastOfUs, 10)
    gamerGuilherme.recomendarJogo(jogoAssassins, 8)
    gamerGuilherme.recomendarJogo(jogoCyber, 7)
    gamerGuilherme.recomendarJogo(jogoGod, 10)
    gamerGuilherme.recomendarJogo(jogoSkyrim, 8)
    gamerGuilherme.recomendarJogo(jogoSpider, 6)

    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)

    gamerCaroline.recomendarJogo(jogoResidentVillage, 7)
    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 10)

    gamerCaroline.recomendar(7)
    gamerCaroline.recomendar(10)
    gamerCaroline.recomendar(8)
    println(gamerCaroline)

//    println(gamerCaroline.jogosAlugados)
//    println(gamerCaroline.jogosDoMes(8))

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
//    val serializacao = gson.toJson(gamerGuilherme.jogosRecomendados)
//    val arquivo = File("jogosRecomendados-${gamerGuilherme.nome}.json")

    val serializacao = gson.toJson(gamerCaroline.jogosRecomendados)
    val arquivo = File("jogosRecomendados-${gamerCaroline.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)

}