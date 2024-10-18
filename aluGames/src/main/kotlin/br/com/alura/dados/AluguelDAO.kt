package br.com.alura.dados

import br.com.alura.model.Aluguel
import br.com.alura.model.AluguelEntity
import javax.persistence.EntityManager
import br.com.alura.utils.toEntity
import br.com.alura.utils.toModel

class AluguelDAO(manager: EntityManager) : DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java) {

    override fun toEntity(objeto: Aluguel): AluguelEntity {
        return AluguelEntity(objeto.gamer.toEntity(), objeto.jogo.toEntity(), objeto.periodo)
            .apply {
                valorDoAluguel = objeto.valorAluguel
                id = objeto.id
            }
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(entity.gamer.toModel(), entity.jogo.toModel(), entity.periodo)
            .apply {
                id = entity.id
            }
    }

}