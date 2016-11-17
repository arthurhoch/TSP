/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author m96600
 */
public class TSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Arquivo arquivo = new Arquivo("arquivo_dados_tsp.txt");
        arquivo.ler();
        List<Nodo> nodos = arquivo.getNodos();

        int nodoInicio = 0;
        
        ResolverTSP resolver = new ResolverTSP(nodos, nodoInicio);
        
        
        List<Nodo> solucaoInicial = resolver.melhorSolucaoInicial();
        for (Nodo nodo : solucaoInicial) {
            System.out.println(nodo.toString());
        }
        System.out.println(resolver.calcularDistancia(solucaoInicial));
        
        System.out.println("------");
        
        List<Nodo> melhorSolucao = resolver.calcularMelhorSolucao(solucaoInicial);
        for (Nodo nodo : melhorSolucao) {
            System.out.println(nodo.toString());
        }
        System.out.println(resolver.calcularDistancia(melhorSolucao));
        
        
    }
}
