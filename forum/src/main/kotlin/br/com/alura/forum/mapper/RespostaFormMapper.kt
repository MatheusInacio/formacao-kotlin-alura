package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NovaRespostaDTO
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper(private val usuarioService: UsuarioService) : Mapper<NovaRespostaDTO, Resposta> {

    override fun map(t: NovaRespostaDTO): Resposta {
        return Resposta(
            mensagem = t.mensagem, autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}