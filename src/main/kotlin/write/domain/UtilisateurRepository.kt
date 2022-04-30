package write.domain

import java.util.*

interface UtilisateurRepository {
    fun ajouter(utilisateur: Utilisateur): UUID
}