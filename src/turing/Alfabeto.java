/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing;


/**
 *
 * @author IP5 PRO 16ACH6
 */
public class Alfabeto {
    private String alfabeto;

    public String getAlfabeto() {
        return alfabeto;
    }

    public Alfabeto(String programma)  {
       
        String []istruzioni;
        alfabeto="";
        istruzioni=programma.split("\n");
        
        int i=1;
        for(i=0;i<istruzioni.length;i++){
            String istruzione=istruzioni[i];
            istruzione=istruzione.substring(1,istruzione.length());
            istruzione=istruzione.substring(0,istruzione.length()-1);
            //System.out.println("Istruzione da eseguire: "+istruzione);
            String vettore[]=istruzione.split(",");
            
            if(!alfabeto.contains(vettore[1]))
                    alfabeto+=vettore[1];
            
            if(!alfabeto.contains(vettore[3]))
                    alfabeto+=vettore[3];
        }
    }
  }
    
    

