import br.com.alura.model.Gamer
import br.com.alura.model.InfoJogo
import br.com.alura.model.Jogo
import br.com.alura.services.ConsumoApi
import br.com.alura.utils.transformarEmIdade
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*


fun main(args: Array<String>) {

    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluído com sucesso.")
    println("Dados do Gamer:")
    println(gamer)
    println("Idade: " + gamer.dataNascimento?.transformarEmIdade())

    do {

        println("Digite um código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }

        resultado.onFailure {
            println("br.com.alura.model.Jogo inexistente. Tente outro id.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a descrição personalizada para o jogo:")
                val descricao = leitura.nextLine()
                meuJogo?.descricao = descricao
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true))

//    println("Jogos buscados:")
//    println(gamer.jogosBuscados)

    println("\n Jogos ordenados por título:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }
    println(gamer.jogosBuscados)

//    val jogosFiltrados = gamer.jogosBuscados.filter {
//        it?.titulo?.contains("batman", true) ?: false
//    }
//    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)) {
        println(gamer.jogosBuscados)
        println("\n Informe a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("Busca finalizada com sucesso.")

}