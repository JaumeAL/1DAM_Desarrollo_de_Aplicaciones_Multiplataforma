class Biblioteca:
    def __init__(self):
        self.llibrets = []

    def afegir_llibre(self, titol, autor, any_publicacio):
        llibre = {"titol": titol, "autor": autor, "any_publicacio": any_publicacio}
        self.llibrets.append(llibre)

    def cercar_llibre(self, titol):
        for llibre in self.llibrets:
            if llibre["titol"].lower() == titol.lower():
                return llibre
        return None

    def eliminar_llibre(self, titol):
        llibre = self.cercar_llibre(titol)
        if llibre:
            self.llibrets.remove(llibre)
            return True
        return False

    def llistar_llibres(self):
        return self.llibrets
