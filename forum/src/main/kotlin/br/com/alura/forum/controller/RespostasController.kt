package br.com.alura.forum.controller

import br.com.alura.forum.dto.NovaRespostaDTO
import br.com.alura.forum.service.RespostaService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostasController(private val service: RespostaService) {

//    @GetMapping
//    fun listar(@PathVariable id: Long): List<Resposta> {
//        return service.listar(id)
//    }

    @PostMapping
    fun cadastrar(@PathVariable id: Long, @RequestBody @Valid dto: NovaRespostaDTO) {
        service.cadastrar(dto, id)
    }

}