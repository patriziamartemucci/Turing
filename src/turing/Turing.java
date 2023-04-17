/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing;

import java.io.IOException;
import java.util.Arrays;


/**
 *
 * @author IP5 PRO 16ACH6
 */
public class Turing {
    String programma;
    String istruzioni[];
    //char mat[][];
    char matInput[];
    char matOutput[];
    int statoPartenza[];
    int statoArrivo[];
    char matDirezione[];
    char inputChar[];
    //char[] charArray;
    String output;
    String input;
    int inputInEsecuzione;
    int istruzioneInEsecuzione;
    String istruzioneAttuale;
  
    
    int stato; 
    char out,in;
    char direzione;

    public String getOutput() {
        return output;
    }

    public int getInputInEsecuzione() {
        return inputInEsecuzione;
    }

    public int getIstruzioneInEsecuzione() {
        return istruzioneInEsecuzione;
    }

    public char carattereInInput(){
        return inputChar[inputInEsecuzione];
    }
    public Turing(String programma) throws TuringSyntaxError{
        this.programma=programma;
        try{
            preparaMatriceIstruzioni();
        }catch(TuringSyntaxError e){
            throw e;
        }
        
    }
    
    public Turing(String programma,String input,int statoPartenza ) throws TuringSyntaxError, IOException {
        this(programma);
        output="";
        char charArray[] = new char[input.length()*3];
        Arrays.fill(charArray, '-');
        String str = new String(charArray);
        this.input="---"+input+str;
        inputChar=this.input.toCharArray();
        stato=statoPartenza;
        //controlla che lo stato iniziale sia presente nel programma
        boolean statoTrovato=false;
        for(int i=0;i<this.statoPartenza.length;i++){
            if(statoPartenza==this.statoPartenza[i]){
                statoTrovato=true;
            }
        }
        if(!statoTrovato) {
            throw new IOException("Stato di partenza non presente nel programma");
        } 
        direzione=' ';
        inputInEsecuzione=3;//è come j sotto
        istruzioneInEsecuzione=prossimaIstruzione(stato);
        
    }
    
    private int prossimaIstruzione(int statoAttuale){
        int j=inputInEsecuzione;
        in=inputChar[j];
        for(int i=0;i<istruzioni.length;i++){
                if(this.statoPartenza[i]==statoAttuale && this.matInput[i]==in){//mat[i][1]==in){
                    return i;
                }
            }
       return -1; 
    }
    
    public String getTupla(){
        //String v[];
        String s="(";
        //v = new String[5];
        if(this.istruzioneInEsecuzione>=0){
            /*
            for(int j=0;j<5;j++){
                v[j]=mat[this.istruzioneInEsecuzione][j];
               
            }
            
            v[0]=""+this.statoPartenza[this.istruzioneInEsecuzione];
            v[1]=""+this.matInput[this.istruzioneInEsecuzione];
            v[2]=""+this.statoArrivo[this.istruzioneInEsecuzione];
            v[3]=""+this.statoArrivo[this.istruzioneInEsecuzione];
            v[4]=""+this.matDirezione[this.istruzioneInEsecuzione];
            */
             s=s+this.statoPartenza[this.istruzioneInEsecuzione]+","+
                     this.matInput[this.istruzioneInEsecuzione]+","+
                     this.statoArrivo[this.istruzioneInEsecuzione]+","+
                     this.matOutput[this.istruzioneInEsecuzione]+","+
                     this.matDirezione[this.istruzioneInEsecuzione]+")";
                     //mat[this.istruzioneInEsecuzione][4]+")";
             return s;
        }
        else return null;
    } 
    //da qui continua (al posto del while....)
    public boolean eseguiIstruzione(){
        int j=inputInEsecuzione;
        boolean trovato=false;
        if(j<input.length() && j>=0){
            in=inputChar[j];
            for(int i=0;i<istruzioni.length;i++){
                if(this.statoPartenza[i]==stato && matInput[i]==in){//mat[i][1]==in){
                    out=matOutput[i];//mat[i][3];
                    inputChar[j]=out;
                    stato=this.statoArrivo[i];
                    direzione=matDirezione[i];//mat[i][4];
                    trovato=true;
                    
                    break;
                }
            }
            if(trovato==true){
                output=generaOutput();
                if(direzione=='>'){
                    j++;
                }else{
                    j--;
                }
            }
        }
        //output=String.valueOf(inputChar);
        //output=generaOutput();
        inputInEsecuzione=j;
        istruzioneInEsecuzione=prossimaIstruzione(stato);
        return trovato;
    }
    private String generaOutput(){
        String s="";
        for(int i=0;i<inputInEsecuzione;i++){
            s=s+inputChar[i];
        }
        s=s+"|"+inputChar[inputInEsecuzione]+"|";
        for(int i=inputInEsecuzione+1;i<inputChar.length;i++){
            s=s+inputChar[i];
        }
        return s;
    }
    public String eseguiTutto(String input,int statoPartenza)throws IOException{
        output="";
        char charArray[] = new char[input.length()*3];
        Arrays.fill(charArray, '-');
        String str = new String(charArray);
        input="---"+input+str;
        inputChar=input.toCharArray();
        stato=statoPartenza;
        direzione=' ';
        boolean statoTrovato=false;
        for(int i=0;i<this.statoPartenza.length;i++){
            if(statoPartenza==this.statoPartenza[i]){
                statoTrovato=true;
            }
        }
        if(!statoTrovato) {
            throw new IOException("Stato di partenza non presente nel programma");
        } 
        int j=3;//salta i prmi 3 trattini
        boolean trovato=true;
        while(j<input.length() && j>=0 && trovato){
            in=inputChar[j];
            trovato=false;
            for(int i=0;i<istruzioni.length;i++){
                if(this.statoPartenza[i]==stato && matInput[i]==in){
                    out=matOutput[i];
                    inputChar[j]=out;
                    stato=this.statoArrivo[i];
                    //direzione=mat[i][4];
                    direzione=matDirezione[i];
                    trovato=true;
                    break;
                }
            }
            
            if(trovato==true){
                //output=generaOutput();
                if(direzione=='>'){
                    j++;
                }else{
                    j--;
                }
            }
        }
        output=String.valueOf(inputChar);
        
        return output;
    }
    
    private void preparaMatriceIstruzioni() throws TuringSyntaxError{
        
        istruzioni=programma.split("\n");
        /*
        for(int i=0;i<istruzioni.length;i++){
        System.out.println(istruzioni[i]);
        }
         */
        int i=1;
        for (String istruzione : istruzioni) {
            if(!istruzione.startsWith("(") || !istruzione.endsWith(")"))
                throw new TuringSyntaxError("Errore di sintassi: mancano le parentesi di apertura e/o chiusura nella riga "+i);
            //System.out.println("Istruzione da eseguire: "+istruzione);
            i++;
        }
        
        //mat=new char[istruzioni.length][5];
        this.matInput=new char[istruzioni.length];
        this.matOutput=new char[istruzioni.length];
        this.statoPartenza=new int[istruzioni.length];
        this.statoArrivo=new int[istruzioni.length];
        this.matDirezione=new char[istruzioni.length];
        
        
        for(i=0;i<istruzioni.length;i++){
            String istruzione=istruzioni[i];
            istruzione=istruzione.substring(1,istruzione.length());
            istruzione=istruzione.substring(0,istruzione.length()-1);
            //System.out.println("Istruzione da eseguire: "+istruzione);
            String vettore[]=istruzione.split(",");
            if(vettore.length<5){
                throw new TuringSyntaxError("Errore di sintassi: gli argomenti dell'istruzione non sono 5. Riga "+(i+1));
            }/*
            for(int j=0;j<5;j++){
                if(vettore[j].isBlank())
                    throw new TuringSyntaxError("Errore di sintassi: gli argomenti dell'istruzione non sono 5. Riga "+(i+1));
                mat[i][j]=vettore[j].charAt(0);
              //  System.out.print(mat[i][j]+"\t");
            }*/
            /*
            System.out.print(vettore[0]+"\t"+vettore[1]+"\t"
                    +vettore[2]+"\t"+vettore[3]+"\t"+vettore[4]);
            System.out.println();
            */
            try{
                if(vettore[0].isBlank())
                    throw new TuringSyntaxError("Errore di sintassi: stato di partenza non è un numero. Riga "+(i+1));
                this.statoPartenza[i]=Integer.parseInt(vettore[0].trim());
            }catch(NumberFormatException e){
                throw new TuringSyntaxError("Errore di sintassi: stato di partenza non è un numero. Riga "+(i+1));
            }
            //System.out.println("Stato partenza: "+this.statoPartenza[i]);
            if(vettore[1].isBlank() || vettore[1].length()>1){
                throw new TuringSyntaxError("Errore di sintassi: l'input non è di un solo carattere. Riga "+(i+1));
            }
            this.matInput[i]=vettore[1].charAt(0);
            //System.out.println("Input: "+this.matInput[i]);
            
            try{
                if(vettore[2].isBlank())
                    throw new TuringSyntaxError("Errore di sintassi: stato di arrivo non è un numero. Riga "+(i+1));
                this.statoArrivo[i]=Integer.parseInt(vettore[2].trim());
            }catch(NumberFormatException ex){
                throw new TuringSyntaxError("Errore di sintassi: stato di arrivo non è un numero. Riga "+(i+1));
            }
            //System.out.println("Stato arrivo: "+this.statoArrivo[i]);
            if(vettore[3].isBlank() || vettore[3].length()>1){
                throw new TuringSyntaxError("Errore di sintassi: l'output non è di un solo carattere. Riga "+(i+1));
            }
            this.matOutput[i]=vettore[3].charAt(0);
            if(vettore[4].isBlank() || vettore[4].length()>1 || 
                    (!(vettore[4].equals(">")) && !(vettore[4].equals("<")))){
                throw new TuringSyntaxError("Errore di sintassi: la direzione deve essere \">\" oppure \"<\". Riga "+(i+1));
            }
            this.matDirezione[i]=vettore[4].charAt(0);
            
        }
    }     
}
