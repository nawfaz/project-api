package write.useCases

import org.springframework.stereotype.Component
import write.domain.UUIDGenerator
import write.domain.Utilisateur
import write.domain.UtilisateurRepository
import write.useCases.AjouterUnUtilisateurCommand
import java.util.*

class AjouterUnUtilisateurCommandHandler(
    private val utilisateurRepository: UtilisateurRepository,
    private val uuidGenerator: UUIDGenerator
) {
    fun handle(ajouterUnUtilisateurCommand: AjouterUnUtilisateurCommand): UUID {
        val id = uuidGenerator.generate()
        val utilisateur = Utilisateur(id, ajouterUnUtilisateurCommand.nom)
        utilisateurRepository.ajouter(utilisateur)

        return id
    }
}

@Component
private class UUIDIdentityGenerator() : UUIDGenerator {
    override fun generate(): UUID = UUID.randomUUID()
}