package br.com.alura.dados

import br.com.alura.model.Gamer
import br.com.alura.model.GamerEntity
import javax.persistence.EntityManager
import br.com.alura.utils.toEntity
import br.com.alura.utils.toModel

class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(objeto: Gamer): GamerEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plano = entity.plano.toModel() }
    }
}