package turing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IP5 PRO 16ACH6
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean continua;
        //programma per eliminare le a in una stringa do a e b
        Turing turing=null;
        try {
            turing = new Turing(
                    "(0,b,1,x,>)\n" +
                            "(0,a,0,a,>)\n" +
                            "(0,-,6,-,<)\n" +
                            "(1,a,1,a,>)\n" +
                            "(1,b,1,b,>)\n" +
                            "(1,-,2,-,>)\n" +
                            "(2,b,2,b,>)\n" +
                            "(2,-,3,b,<)\n" +
                            "(3,b,3,b,<)\n" +
                            "(3,-,4,-,<)\n" +
                            "(4,a,5,a,<)\n" +
                            "(4,x,6,x,>)\n" +
                            "(4,b,5,b,<)\n" +
                            "(5,a,5,a,<)\n" +
                            "(5,b,5,b,<)\n" +
                            "(5,x,0,x,>)\n" +
                            "(6,x,6,x,>)\n" +
                            "(6,a,6,a,>)\n" +
                            "(6,-,7,-,<)\n" +
                            "(7,x,7,-,<)\n" +
                            "(7,a,7,-,<)\n" +
                            "(7,-,8,-,>)");
        }  catch (TuringSyntaxError ex) {
            //Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Turing1: Errore: "+ex.getMessage());
        }
        if(turing !=null)
            try {
                System.out.println("OUTPUT: "+turing.eseguiTutto("baaabbaaabababa",0));
        } catch (IOException ex) {
            //Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Turing1: "+ex.getMessage());
        }
        
        //programma per eliminare gli zeri non significativi
        Turing turing2=null;
        try {
            turing2=new Turing(
                    "(0,0,0,-,>)\n" +
                            "(0,-,3,0,>)\n" +
                            "(0,1,1,1,>)\n" +
                            "(0,2,2,2,>)\n" +
                            "(0,3,1,3,>)\n" +
                            "(0,4,1,4,>)\n" +
                            "(0,5,1,5,>)\n" +
                            "(0,6,1,6,>)\n" +
                            "(0,7,1,7,>)\n" +
                            "(0,8,1,8,>)\n" +
                            "(0,9,1,9,>)\n" +
                            "(1,0,1,0,>)\n" +
                            "(1,1,1,1,>)\n" +
                            "(1,2,1,2,>)\n" +
                            "(1,3,1,3,>)\n" +
                            "(1,4,1,4,>)\n" +
                            "(1,5,1,5,>)\n" +
                            "(1,6,1,6,>)\n" +
                            "(1,7,1,7,>)\n" +
                            "(1,8,1,8,>)\n" +
                            "(1,9,1,9,>)\n" +
                            "(1,-,2,-,<)\n" +
                            "(2,-,3,0,>)\n" +
                            "(2,3,3,3,<)"
            );
        }  catch (TuringSyntaxError ex) {
            //Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Turing2: Errore: "+ex.getMessage());
        }
        
        if(turing2!=null)
            try {
                System.out.println("OUTPUT: "+turing2.eseguiTutto("00010200",0));
        } catch (IOException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Turing turing3=null;
        try {
            turing3=new Turing(
                    "(0,0,0,-,>)\n" +
                            "(0,-,3,0,>)\n" +
                            "(0,1,1,1,>)\n" +
                            "(0,2,2,2,>)\n" +
                            "(0,3,1,3,>)\n" +
                            "(0,4,1,4,>)\n" +
                            "(0,5,1,5,>)\n" +
                            "(0,6,1,6,>)\n" +
                            "(0,7,1,7,>)\n" +
                            "(0,8,1,8,>)\n" +
                            "(0,9,1,9,>)\n" +
                            "(1,0,1,0,>)\n" +
                            "(1,1,1,1,>)\n" +
                            "(1,2,1,2,>)\n" +
                            "(1,3,1,3,>)\n" +
                            "(1,4,1,4,>)\n" +
                            "(1,5,1,5,>)\n" +
                            "(1,6,1,6,>)\n" +
                            "(1,7,1,7,>)\n" +
                            "(1,8,1,8,>)\n" +
                            "(1,9,1,9,>)\n" +
                            "(1,-,2,-,<)\n" +
                            "(2,-,3,0,>)\n" +
                            "(2,3,3,3,<","00010200",0
            );
        } catch (TuringSyntaxError ex) {
            //Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Turing3: Errore: "+ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(turing3!=null){
            
            do{
                continua=turing3.eseguiIstruzione();

            }while(continua);
            
            System.out.println("Risultato3: "+turing3.getOutput());
    
        }
    
    Turing turing4=null;
        try {
            turing4 = new Turing(
                    "(0,b,1,x,>)\n" +
                            "(0,a,0,a,>)\n" +
                            "(0,-,6,-,<)\n" +
                            "(1,a,1,a,>)\n" +
                            "(1,b,1,b,>)\n" +
                            "(1,-,2,-,>)\n" +
                            "(2,b,2,b,>)\n" +
                            "(2,-,3,b,<)\n" +
                            "(3,b,3,b,<)\n" +
                            "(3,-,4,-,<)\n" +
                            "(4,a,5,a,<)\n" +
                            "(4,x,6,x,>)\n" +
                            "(4,b,5,b,<)\n" +
                            "(5,a,5,a,<)\n" +
                            "(5,b,5,b,<)\n" +
                            "(5,x,0,x,>)\n" +
                            "(6,x,6,x,>)\n" +
                            "(6,a,6,a,>)\n" +
                            "(6,-,7,-,<)\n" +
                            "(7,x,7,-,<)\n" +
                            "(7,a,7,-,<)\n" +
                            "(7,-,8,-,>)","baaab",0);
        } catch (TuringSyntaxError ex) {
            System.out.println("Turing4: Errore: "+ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    if(turing4!=null){
        System.out.println("Input: baaab");
        int i=turing4.getIstruzioneInEsecuzione();
        System.out.println("Istruzione in esecuzione: "+i);
        String v=turing4.getTupla();
        if(v!=null){
            System.out.println(v);
       }else{
            System.out.println("Fine programma");
        }
       System.out.println("Input: "+turing4.carattereInInput());


       do{
           continua=turing4.eseguiIstruzione();
           i=turing4.getIstruzioneInEsecuzione();
            System.out.println("Istruzione in esecuzione: "+i);
           v=turing4.getTupla();
           if(v!=null){
               System.out.println(v);
          }else{
               System.out.println("Fine programma");
           }
           System.out.println("Input: "+turing4.carattereInInput());
       }while(continua);
       System.out.println("Input: baaab");
       System.out.println("Risultato4 : "+turing4.getOutput());
    }
    }
}
