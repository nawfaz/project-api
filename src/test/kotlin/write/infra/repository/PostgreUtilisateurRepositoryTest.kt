package write.infra.repository

import org.junit.jupiter.api.Test
import write.domain.Utilisateur
import write.domain.UtilisateurRepository
import java.util.*
import kotlin.test.assertEquals

class PostgreUtilisateurRepositoryTest {
    @Test
    fun `devrait ajouter un utilisateur dans la  base de donnees`(){
        //Given
        val nom = "nom"
        val uuid = UUID.fromString("8e7cd645-14cc-42b4-8db5-3cc8821d440d")
        val utilisateur = Utilisateur(uuid, nom)

        val postgreUtilisateurRepository = PostgreUtilisateurRepository()

        //When
        val id = postgreUtilisateurRepository.ajouter(utilisateur)

        //Then
        assertEquals(id, uuid)

    }
}

class PostgreUtilisateurRepository: UtilisateurRepository {
    override fun ajouter(utilisateur: Utilisateur): UUID {
        TODO("Not yet implemented")
    }

}
