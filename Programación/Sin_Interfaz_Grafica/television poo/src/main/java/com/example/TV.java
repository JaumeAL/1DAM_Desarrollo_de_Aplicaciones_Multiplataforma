package com.example;

public class TV {
    // atributos
    private boolean isOn;
    private int volume;
    private int channel;

    // constructor
    public TV() {
        // sus valores iniciales
        this.isOn = false;
        this.volume = 0;
        this.channel = 1;
    }

    // Encender la tele
    public void encender() {
        if (!isOn) {
            isOn = true;
            System.out.println("El televisor está encendido");
        } else {
            System.out.println("El televisor ya estaba encendido");
        }
    }

    // Apagar la tele
    public void apagar() {
        if (isOn) {
            isOn = false;
            System.out.println("El televisor está apagado");
        } else {
            System.out.println("El televisor ya estaba apagado");
        }
    }

    // Subir el volumen
    public void subirVolumen() {
        this.volume++;
        if (volume > 100) {
            volume = 100;
        }
        System.out.println("Volumen = " + volume);
    }

    // Bajar el volumen
    public void bajarVolumen() {
        this.volume--;
        if (volume < 0) {
            volume = 0;
            System.out.println("No puedes bajar de 0");
        } else {
            System.out.println("Volumen = " + volume);
        }
    }

    // Subir el canal
    public void subirCanal() {
        this.channel++;
        System.out.println("Canal = " + channel);
    }

    // Bajar el volumen
    public void bajarCanal() {
        this.channel--;
        if (channel < 0) {
            channel = 0;
            System.out.println("No puedes bajar de 0");
        } else {
            System.out.println("Canal = " + channel);
        }
    }

    // Mostrar el canal actual
    public int getChannel() {
        return channel;
    }

    // Ir al canal que quieras
    public void setChannel(int canal) {
        this.channel = canal;
    }

}
