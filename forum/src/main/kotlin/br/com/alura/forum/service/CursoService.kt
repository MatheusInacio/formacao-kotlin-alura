package br.com.alura.forum.service


import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.CursoRepository
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getReferenceById(id)
    }

}