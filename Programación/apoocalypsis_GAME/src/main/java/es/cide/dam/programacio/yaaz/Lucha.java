package es.cide.dam.programacio.yaaz;

public class Lucha {
    public static void luchar(supervivient supervivivent, zombie zombieActual) {
        while (supervivivent.getSalut() > 0 && zombieActual.getSalut() > 0) { // Mientras el superviviente y el zombie actual tengan salud, lucharán.
            // Turno del superviviente.
            int atacSuperviviente = supervivivent.ataca() - zombieActual.defensat(); // Calcula el daño que inflige al zombie restando el ataque menos la defensa.

            if (atacSuperviviente > 0) { // Si el ataque supera la defensa del zombie, se le resta la salud correspondiente.
                System.out.println(supervivivent.getNom() + " le quita " + atacSuperviviente + " de daño al zombie");
                zombieActual.setSalut(zombieActual.getSalut() - atacSuperviviente);
                System.out.println("Y el Zombie se queda con " + zombieActual.getSalut() + " de vida");
            } else { // Si el ataque no supera la defensa, el zombie bloquea el ataque.
                System.out.println(supervivivent.getNom() + " ha atacado pero el zombie ha parado el ataque!");
            }

            // Turno del zombie.
            if (zombieActual.getSalut() > 0) { // Si el zombie sigue vivo, ataca al superviviente.
                int atacZombie = zombieActual.ataca() - supervivivent.defensat(); // Calcula el daño que inflige al superviviente restando el ataque menos la defensa.

                if (atacZombie > 0) { // Si el ataque supera la defensa del superviviente, se le resta la salud correspondiente.
                    System.out.println("El zombie le quita " + atacZombie + " de daño a " + supervivivent.getNom());
                    supervivivent.setSalut(supervivivent.getSalut() - atacZombie);
                    System.out.println(supervivivent.getNom() + " se queda con " + supervivivent.getSalut() + " de vida");
                } else { // Si el ataque no supera la defensa, el superviviente bloquea el ataque.
                    System.out.println("El zombie ha atacado pero " + supervivivent.getNom() + " ha parado el ataque!");
                }
            }
        }
    }
}
