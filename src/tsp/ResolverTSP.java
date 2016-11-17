/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author arthurhoch
 */
public class ResolverTSP {
    
    
    private List<Nodo> nodos;
    private int nodoInicio;
    
    ResolverTSP(List<Nodo> nodos, int nodoInicio) {
        this.nodos = nodos;
        this.nodoInicio = nodoInicio;
        inicializarNodos();
    }
    
    private void inicializarNodos() {
        for (Nodo nodo : nodos) {
            nodo.calcularDistancia(nodos);
        }
    }
    
    public List<Nodo> melhorSolucaoInicial() {
        List<Nodo> blackList= new LinkedList<>();
        List<Nodo> melhorSolucao = new LinkedList<>();

        Nodo nodoAtual =  nodos.get(nodoInicio);
        Nodo newNodo  =  nodos.get(nodoInicio);

        melhorSolucao.add(nodoAtual);
        blackList.add(newNodo);
        
        do {
            
            newNodo = nodoAtual.menorDistancia(blackList);
            blackList.add(newNodo);
            nodoAtual = newNodo;
            melhorSolucao.add(nodoAtual);
            
        } while(nodoAtual.distanciaDe(nodoAtual.menorDistancia(blackList)) != 0.0 );
        
        melhorSolucao.add(nodos.get(nodoInicio));
        
        return melhorSolucao;
    }
    
    public Double calcularDistancia(List<Nodo> solucao) {
        
        Double distancia = 0.0;
        
        Nodo get = null;
        
        for (int i = 0; i < solucao.size()-1; i++) {
            get = solucao.get(i);
            distancia += get.distanciaDe(solucao.get(i+1));
        }
        
        return distancia;
    }
    
    public List<Nodo> trocarEm(List<Nodo> solucaoEntrada, int em) {
        
        List<Nodo> solucao = new LinkedList<>(solucaoEntrada);
        
        List<Nodo> melhorSolucao = new LinkedList<>(solucaoEntrada);
        
        for (int i = 1; i < solucaoEntrada.size()-em-1; i++) {
            Nodo get = solucaoEntrada.get(i);
            solucao.set(i, solucaoEntrada.get(i+em));
            solucao.set(i+em, get);
            
            if(calcularDistancia(solucao) < calcularDistancia(melhorSolucao))
                melhorSolucao = new LinkedList<>(solucao);
            
            solucao = new LinkedList<>(solucaoEntrada);
            
        }
        
        return melhorSolucao;
    }
    
    public List<Nodo> calcularMelhorSolucao(List<Nodo> solucao) { 
        
        List<Nodo> melhorSolucao = new LinkedList<>(solucao);

        
        for(int i=1; i < solucao.size()-1; i++) {
            melhorSolucao = trocarEm(melhorSolucao, i);
        }
        
        return melhorSolucao;
    }
}
