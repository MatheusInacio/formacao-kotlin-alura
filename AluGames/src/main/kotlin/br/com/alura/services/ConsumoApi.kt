package br.com.alura.services

import br.com.alura.model.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaJogo(id: String):InfoJogo {

        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        //client.sendAsync(request, BodyHandlers.ofString())
        //  .thenApply { obj: HttpResponse<*> -> obj.body() }
        //.thenAccept(System.out::println)
        //.join()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        println(json)

        val gson = Gson()

        return gson.fromJson(json, InfoJogo::class.java)

    }

}