import unittest
from biblioteca import Biblioteca

class TestBiblioteca(unittest.TestCase):
    def setUp(self):
        self.biblio = Biblioteca()
        self.biblio.afegir_llibre("El libro troll", "El Rubius", 2014)
        self.biblio.afegir_llibre("Wigetta", "Vegetta777 i Willyrex", 2015)
        self.biblio.afegir_llibre("Los secretos de YouTube", "Dalas Review", 2016)

    def test_afegir_llibre(self):
        self.biblio.afegir_llibre("Todo lo que nunca te dije", "Patry Jordan", 2020)
        llibre = self.biblio.cercar_llibre("Todo lo que nunca te dije")
        self.assertIsNotNone(llibre)
        self.assertEqual(llibre["autor"], "Patry Jordan")
        self.assertEqual(llibre["any_publicacio"], 2020)

    def test_cercar_llibre_existent(self):

        llibre = self.biblio.cercar_llibre("El libro troll")
        self.assertIsNotNone(llibre)
        self.assertEqual(llibre["autor"], "El Rubius")
        self.assertEqual(llibre["any_publicacio"], 2014)


    def test_eliminar_llibre_existent(self):
        resultat = self.biblio.eliminar_llibre("Wigetta")
        self.assertTrue(resultat)
        llibre = self.biblio.cercar_llibre("Wigetta")
        self.assertIsNone(llibre)

    def test_llistar_llibres(self):
        llibres = self.biblio.llistar_llibres()
        self.assertEqual(len(llibres), 3)
        títols = [llibre["titol"] for llibre in llibres]
        self.assertIn("El libro troll", títols)
        self.assertIn("Wigetta", títols)
        self.assertIn("Los secretos de YouTube", títols)

    def test_eliminar_tots_llibres(self):
        titols = ["El libro troll", "Wigetta", "Los secretos de YouTube"]
        for titol in titols:
            resultat = self.biblio.eliminar_llibre(titol)
            self.assertTrue(resultat)
        llibres = self.biblio.llistar_llibres()
        self.assertEqual(len(llibres), 0)

if __name__ == "__main__":
    unittest.main()
