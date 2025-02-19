/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */

package es.cide.dam.programacio.yaaz;

public class Lucha {
    public static void luchar(supervivient supervivivent, zombie zombieActual, novaCiutat ciutat, int posicio) { // Método que simula un combate entre un superviviente y un zombie
        while (supervivivent.getSalut() > 0 && zombieActual.getSalut() > 0) { // Mientras el superviviente y el zombie actual tengan salud, lucharán
            // Turno del superviviente.
            int atacSuperviviente = supervivivent.ataca() - zombieActual.defensat(); // Calcula el daño que inflige al zombie restando el ataque menos la defensa

            if (atacSuperviviente > 0) { // Si el ataque supera la defensa del zombie, se le resta la salud correspondiente
                System.out.println(supervivivent.getNom() + " le quita " + atacSuperviviente + " de daño al "+zombieActual.getNom()); 
                zombieActual.setSalut(zombieActual.getSalut() - atacSuperviviente); 
                System.out.println("Y el "+zombieActual.getNom()+" se queda con " + zombieActual.getSalut() + " de vida");
            } else { // Si el ataque no supera la defensa, el zombie bloquea el ataque
                System.out.println(supervivivent.getNom() + " ha atacado pero el "+zombieActual.getNom()+" ha parado el ataque!");
            }

            // Turno del zombie
            if (zombieActual.getSalut() > 0) { // Si el zombie sigue vivo, ataca al superviviente
                int atacZombie = zombieActual.ataca() - supervivivent.defensat(); // Calcula el daño que inflige al superviviente restando el ataque menos la defensa

                if (atacZombie > 0) { // Si el ataque supera la defensa del superviviente, se le resta la salud correspondiente
                    System.out.println("El "+zombieActual.getNom()+" le quita " + atacZombie + " de daño a " + supervivivent.getNom());
                    supervivivent.setSalut(supervivivent.getSalut() - atacZombie);
                    System.out.println(supervivivent.getNom() + " se queda con " + supervivivent.getSalut() + " de vida");
                } else { // Si el ataque no supera la defensa, el superviviente bloquea el ataque.
                    System.out.println("El "+ zombieActual.getNom()+ " ha atacado pero " + supervivivent.getNom() + " ha parado el ataque!");
                }
            }
        }

        // Después del combate, recoge el artefacto
        artefacte artefacto = ciutat.getArtefacte(posicio); // Se recoge el artefacto de la ciudad
        if (artefacto != null) { // Si el artefacto no es nulo (es decir si hay un artefacto), se muestra el artefacto encontrado y se aplica el efecto
            System.out.println(supervivivent.getNom() + " ha encontrado un " + artefacto.tipoArtefacto()); // Se muestra el nombre del artefacto encontrado
            aplicarEfectoArtefacto(supervivivent, artefacto); // Se aplica el efecto del artefacto al superviviente
        } else {
            System.out.println(supervivivent.getNom() + " no ha encontrado ningún artefacto."); // Si no se encuentra ningún artefacto, se muestra un mensaje.
        }
    }



    public static void aplicarEfectoArtefacto(supervivient supervivivent, artefacte artefacto) { // Método que aplica el efecto del artefacto al superviviente
        if (artefacto instanceof armaDAcer) {  // Si el artefacto es un arma de acero, se suma el contenido del artefacto al ataque del superviviente
            supervivivent.setAtac((int)(supervivivent.getAtaque() + artefacto.getValorArtefacte())); // Se suma el ataque al valor del artefacto
            System.out.println("El ataque de " + supervivivent.getNom() + " ha aumentado en " + artefacto.getValorArtefacte() + " puntos" + " y ahora es de: " + supervivivent.getAtaque());
        } else if (artefacto instanceof armaDeFoc) { // Si el artefacto es un arma de fuego, se multiplica el contenido del artefacto por el ataque del superviviente
            supervivivent.setAtac((int) (supervivivent.getAtaque() * artefacto.getValorArtefacte())); // Se multiplica el ataque por el valor del artefacto
            System.out.println("El ataque de " + supervivivent.getNom() + " se ha multiplicado por " + artefacto.getValorArtefacte() + " y ahora es de: " + supervivivent.getAtaque());
        } else if (artefacto instanceof farmaciola) { // Si el artefacto es una farmacia, se suma el contenido del artefacto a la salud del superviviente
            supervivivent.setSalut((int) (supervivivent.getSalut() + artefacto.getValorArtefacte())); // Se suma la salud al valor del artefacto
            System.out.println("La salud de " + supervivivent.getNom() + " ha aumentado en " + artefacto.getValorArtefacte() + " puntos" + " y ahora es de: " + supervivivent.getSalut());
        } else if (artefacto instanceof escud) { // Si el artefacto es un escudo, se suma el contenido del artefacto a la defensa del superviviente
            supervivivent.setDefensa((int)(supervivivent.getDefensa() * artefacto.getValorArtefacte())); // Se multiplica la defensa por el valor del artefacto
            System.out.println("La defensa de " + supervivivent.getNom() + " se ha multiplicado por " + artefacto.getValorArtefacte() + " y ahora es de: " + supervivivent.getDefensa());
        }
    }

    

    
}
