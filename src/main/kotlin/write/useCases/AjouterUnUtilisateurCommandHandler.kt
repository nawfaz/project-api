package write.useCases

import write.domain.UUIDGenerator
import write.domain.Utilisateur
import write.domain.UtilisateurRepository
import write.useCases.AjouterUnUtilisateurCommand
import java.util.*

class AjouterUnUtilisateurCommandHandler(
    val utilisateurRepository: UtilisateurRepository,
    val uuidGenerator: UUIDGenerator
) {
    fun handle(ajouterUnUtilisateurCommand: AjouterUnUtilisateurCommand): UUID {
        val id = uuidGenerator.generate()
        val utilisateur = Utilisateur(id, ajouterUnUtilisateurCommand.nom)
        utilisateurRepository.ajouter(utilisateur)

        return id
    }
}