package br.com.alura.dados

import br.com.alura.model.*
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager) : DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {
    override fun toEntity(plano: Plano): PlanoEntity {
        return if (plano is PlanoAssinatura) {
            PlanoAssinaturaEntity(
                plano.tipo, plano.mensalidade, plano.jogosIncluidos, plano.percentualDescontoReputacao, plano.id
            )
        } else {
            PlanoAvulsoEntity(plano.tipo, plano.id)
        }
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return if (entity is PlanoAssinaturaEntity) {
            PlanoAssinatura(
                entity.tipo, entity.mensalidade, entity.jogosIncluidos, entity.percentualDescontoReputacao, entity.id
            )
        } else {
            PlanoAvulso(entity.tipo, entity.id)
        }

    }
}
