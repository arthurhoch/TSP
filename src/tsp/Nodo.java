/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author m96600
 */
public class Nodo {

    private int numero;

    private final Map<Nodo, Double> distancias;
    private final List<Nodo> distanciasBlackList;

    private double x;
    private double y;

    public Nodo(int numero, double x, double y) {
        this.distancias = new HashMap<>();
        this.distanciasBlackList = new LinkedList<>();
        this.distanciasBlackList.add(this);
        this.numero = numero;
        this.x = x;
        this.y = y;
    }

    public Nodo() {
        this.distancias = new HashMap<>();
        this.distanciasBlackList = new LinkedList<>();
        this.distanciasBlackList.add(this);
    }

    public void calcularDistancia(List<Nodo> nodos) {
        double distancia;
        for (Nodo nodo : nodos) {
            distancia = Math.sqrt((x - nodo.x) * (x - nodo.x) + (y - nodo.y) * (y - nodo.y));
            distancias.put(nodo, distancia);
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanciaDe(Nodo nodo) {
        return distancias.get(nodo);
    }

    public Nodo menorDistancia(List<Nodo> blackList) {

        Double menorDistancia = 0.0;
        Nodo menorNodo = this;

        for (Map.Entry<Nodo, Double> entrySet : distancias.entrySet()) {

            if (menorDistancia > entrySet.getValue() || this.equals(menorNodo)) {
                if (!blackList.contains(entrySet.getKey())) {
                    menorDistancia = entrySet.getValue();
                    menorNodo = entrySet.getKey();
                }
            }
        }

        return menorNodo;
    }

    public Nodo menorDistancia() {

        Double menorDistancia = 0.0;
        Nodo menorNodo = this;

        for (Map.Entry<Nodo, Double> entrySet : distancias.entrySet()) {

            if (menorDistancia > entrySet.getValue() || this.equals(menorNodo)) {
                menorDistancia = entrySet.getValue();
                menorNodo = entrySet.getKey();
            }
        }

        return menorNodo;
    }

    public void removerHash(Nodo nodo) {
        distancias.remove(nodo);
    }

    public void cleanBlackList() {
        distanciasBlackList.clear();
    }

    @Override
    public String toString() {
        return "Nodo{" + "numero=" + numero + ", x=" + x + ", y=" + y + '}';
    }
}
