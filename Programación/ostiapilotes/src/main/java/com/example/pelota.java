package com.example;

public class pelota {
    private int x, y; 
    private int dx , dy; 
    private final int RADI; 


    public pelota(){
        //Constructor
        this.x = 50;// Coordenades inicials del cercle
        this.y = 50;// Coordenades inicials del cercle
        this.dx =2;// Velocitat del moviment en X 
        this.dy =2;// Velocitat del moviment en Y
        this.RADI = 20;// Radi del cercle
    }
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
    public int getRADI() {
        return RADI;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
