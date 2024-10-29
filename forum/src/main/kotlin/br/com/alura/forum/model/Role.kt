package br.com.alura.forum.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority


@Entity
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val nome: String
) : GrantedAuthority {

    override fun getAuthority() = nome
}