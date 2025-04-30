/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.programacio.examen;

import java.awt.*;
//import javax.swing.ImageIcon; //Importam la llibreria necesaria per poder utilitzar imatges

class NauEspacial {
     int x, y; // Posició de la nau espacial
    final int ample = 20; // Ample de la nau espacial
    final int alt = 30; // Alt de la nau espacial
    //Image imatgeNau; //Per ficar la imatge

    

    public NauEspacial(int x, int y) {
        this.x = x;
        this.y = y;
        //imatgeNau = new ImageIcon(getClass().getResource("/images/a.png")).getImage(); //Indicam on está la imatge

    }

    public void moureEsquerra() {
        x -= 5; // Mou la nau cap a l'esquerra
    }

    public void moureDreta() {
        x += 5; // Mou la nau cap a la dreta
    }
    public void moureAdalt() {
        y -= 5; // Mou la nau cap amunt
    }
    public void moureAabaix() {
        y += 5; // Mou la nau cap abaix
    }

    public void dibuixar(Graphics g) {
        g.setColor(Color.white); // Color de la nau espacial
        g.fillRect(x, y, ample, alt); // Dibuixa la nau com un rectangle
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAmple() {
        return ample;
    }

    public int getAlt() {
        return alt;
    }
}