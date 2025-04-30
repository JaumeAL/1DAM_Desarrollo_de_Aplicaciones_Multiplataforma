/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.programacio.examen;

import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon; //Importam la llibreria necesaria per poder utilitzar imatges

class Asteroide {
    int x, y; // Posició de l'asteroide
    int radi = 25; // Radi de l'asteroide
    private int velocitat; // Velocitat de l'asteroidekf
    Image imatge; //Per ficar la imatge

    public Asteroide(int amplePanell) {
        Random aleatori = new Random();
        radi = aleatori.nextInt(3)+1; // tamany aleatori
        switch (radi) {
            case 1:
                radi = 25;
                break;
            case 2:
                radi = 40;
                break;
            case 3:
                radi = 10;
                break;
            default:
                break;
        }
        x = aleatori.nextInt(amplePanell - radi * 2) + radi; // Posició x aleatòria
        y = 0; // Comença a la part superior del panell
        velocitat = aleatori.nextInt(3) + 1; // Velocitat aleatòria entre 1 i 3
        imatge = new ImageIcon(getClass().getResource("/images/a.png")).getImage(); //Indicam on está la imatge
    }

    public void moure() {
        y += velocitat; // Mou l'asteroide cap avall
    }

    public void dibuixar(Graphics g) {
        g.fillOval(x - radi, y - radi, 2 * radi, 2 * radi); // Dibuixa l'asteroide com un cercle
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadi() {
        return radi;
    }
}
