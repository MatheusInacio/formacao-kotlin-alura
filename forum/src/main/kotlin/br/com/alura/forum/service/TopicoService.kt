package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoDTO
import br.com.alura.forum.dto.NovoTopicoDTO
import br.com.alura.forum.dto.TopicoViewDTO
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.TopicoRepository
import jakarta.persistence.EntityManager
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private var repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico nao encontrado!",
    private val em: EntityManager
) {
    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoViewDTO> {
        val topicos = if (nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { t ->
            topicoViewMapper.map(t)
        }
    }

    fun buscarPorId(id: Long): TopicoViewDTO {
        val topico = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun buscarPorIdReturnTopico(id: Long): Topico {
        val topico = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return topico
    }

    fun cadastrar(topicoNovo: NovoTopicoDTO): TopicoViewDTO {
        var topico = topicoFormMapper.map(topicoNovo)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoDTO): TopicoViewDTO {
        val topico = repository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        repository.save(topico)

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}