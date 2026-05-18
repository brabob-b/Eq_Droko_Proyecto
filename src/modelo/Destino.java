package modelo;

import java.io.Serializable;
import java.util.LinkedList;

public class Destino implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombreLugar;
    private int diasPermanencia; // mínimo 1
    private LinkedList<String> atractivos;
    private boolean atractivosIncluidos;

    public Destino(String nombreLugar, int diasPermanencia, LinkedList<String> atractivos, boolean atractivosIncluidos) {
        this.nombreLugar = nombreLugar;
        this.diasPermanencia = (diasPermanencia >= 1) ? diasPermanencia : 1;
        this.atractivos = atractivos;
        this.atractivosIncluidos = atractivosIncluidos;
    }

    // Getters
    public String getNombreLugar() { return nombreLugar; }
    public int getDiasPermanencia() { return diasPermanencia; }
    public LinkedList<String> getAtractivos() { return atractivos; }
    public boolean isAtractivosIncluidos() { return atractivosIncluidos; }

    // Setters
    public void setNombreLugar(String nombreLugar) { this.nombreLugar = nombreLugar; }
    public void setDiasPermanencia(int diasPermanencia) { this.diasPermanencia = (diasPermanencia >= 1) ? diasPermanencia : 1; }
    public void setAtractivos(LinkedList<String> atractivos) { this.atractivos = atractivos; }
    public void setAtractivosIncluidos(boolean atractivosIncluidos) { this.atractivosIncluidos = atractivosIncluidos; }

    @Override
    public String toString() {
        return "Destino{" +
                "nombreLugar='" + nombreLugar + '\'' +
                ", diasPermanencia=" + diasPermanencia +
                ", atractivos=" + atractivos +
                ", atractivosIncluidos=" + atractivosIncluidos +
                '}';
    }
}