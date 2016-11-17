/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author m96600
 */
public class Arquivo {
    
    private String caminhoArquivo;
    private List<Nodo> nodos;

    public Arquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        this.nodos = new LinkedList<>();
    }
    
    public void ler() throws FileNotFoundException, IOException {
        
        String line;
        
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        
        while( ( line = br.readLine() ) != null) {
            
            String data[] = line.split(" ");
            nodos.add(new Nodo( Integer.parseInt(data[0]), Double.parseDouble(data[1]), Double.parseDouble(data[2])));
        }
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }
}
