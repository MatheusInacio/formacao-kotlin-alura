package br.com.alura.forum

import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ForumApplication

fun main(args: Array<String>) {
    runApplication<ForumApplication>(*args)

}
