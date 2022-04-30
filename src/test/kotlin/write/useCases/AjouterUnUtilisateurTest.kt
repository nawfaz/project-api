package write.useCases

import write.domain.UUIDGenerator
import write.domain.Utilisateur
import write.domain.UtilisateurRepository
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.util.*
import kotlin.test.assertEquals

class AjouterUnUtilisateurTest {
    @Test
    fun `Devrait appeler le repository pour ajouter un utilisateur`() {
        //Given
        val nom = "nom"
        val expectedId = UUID.fromString("8e7cd645-14cc-42b4-8db5-3cc8821d440d")
        val ajouterUnUtilisateurCommand = AjouterUnUtilisateurCommand(nom)
        val utilisateurRepository = FakeUtilisateurRepository()
        val uuidGenerator = FakeUUIDGenerator()
        val ajouterUnUtilisateurCommandHandler =
            AjouterUnUtilisateurCommandHandler(utilisateurRepository, uuidGenerator)


        //When
        val id = ajouterUnUtilisateurCommandHandler.handle(ajouterUnUtilisateurCommand)

        //Then
        println(id)
        assertThat(utilisateurRepository.hasBeenCalled).isTrue
        assertEquals(id, expectedId)

    }

    class FakeUtilisateurRepository : UtilisateurRepository {
        var hasBeenCalled = false
        override fun ajouter(utilisateur: Utilisateur): UUID {
            hasBeenCalled = true
            return utilisateur.id
        }
    }

    class FakeUUIDGenerator : UUIDGenerator {
        override fun generate(): UUID {
            return UUID.fromString("8e7cd645-14cc-42b4-8db5-3cc8821d440d")
        }
    }
}