/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author IP5 PRO 16ACH6
 */
public class TuringFXController implements Initializable {
    @FXML
    private TextArea txtProgramma;
    @FXML 
    private TextField txtInput;
    @FXML 
    private TextField txtOutput;
    @FXML 
    private TextField txtAlfabeto;
    @FXML
    private Button btnEsegui;
    @FXML
    private Button btnPasso;
    @FXML
    private Button btnInizio;
    @FXML 
    private TextField txtPassoPasso;
    @FXML 
    private TextField txtStatoIniziale;
    
    private Turing turing;
    private boolean continua;
    //private Alfabeto alfabeto;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        continua=false;
        this.btnPasso.setDisable(true);
        this.btnInizio.setDisable(false);
        /*
        this.txtProgramma.textProperty().addListener((observable, oldValue, newValue) -> {
        System.out.println("textfield changed from " + oldValue + " to " + newValue);
        if(newValue!=null){
            this.azzeraCampi();
        }
});*/
    }    
    
    @FXML
     private void gestioneBottoni(ActionEvent event){
        Object obj=event.getSource();
        if(obj==btnEsegui){
            turing=null;
            System.out.println("Hai cliccato su Esegui programma");
            this.txtOutput.setText("");
            this.txtPassoPasso.setText("");
            if(controllaCampi()){
                
                this.btnPasso.setDisable(true);
                this.btnInizio.setDisable(false);
                int statoIniziale;
                statoIniziale=Integer.parseInt(txtStatoIniziale.getText().trim());
                String programma=txtProgramma.getText();
                try {
                    turing=new Turing(programma);
                } catch (TuringSyntaxError ex) {
                    //Logger.getLogger(TuringFXController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                if(turing!=null){
                    String input=this.txtInput.getText();
                    String output = "";
                    try {
                        output = turing.eseguiTutto(input,statoIniziale);
                    } catch (IOException ex ) {
                        //Logger.getLogger(TuringFXController.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex.getMessage() );
                    } 
                    int i;
                    for(i=0;i<output.length();i++){
                        if(output.charAt(i)!='-')break;
                    }
                    output=output.substring(i-2);
                    
                    this.txtOutput.setText(output);   
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ricontrolla i campi di input. C'è quancola che non va");
            }
        }
        if(obj==btnPasso){
            System.out.println("Hai cliccato su Esegui programma Passo-Passo");
            continua=turing.eseguiIstruzione();
            String v=turing.getTupla();
            if(v!=null){
                System.out.println(v);
                this.txtPassoPasso.setText(v);
           }else{
                System.out.println("Fine programma");
                this.txtPassoPasso.setText("Fine programma");
                btnInizio.setDisable(false);
                btnPasso.setDisable(true);
            }
            if(continua){
                 System.out.println("Risultato : "+turing.getOutput());
                 this.txtOutput.setText(turing.getOutput());
            }
           
        }
         if(obj==btnInizio){
             turing=null;
             this.txtOutput.setText("");
            System.out.println("Hai cliccato su Inizio esecuzione");
            if(controllaCampi()){
                int statoIniziale;
                statoIniziale=Integer.parseInt(txtStatoIniziale.getText().trim());
                String programma=txtProgramma.getText();
                String input=this.txtInput.getText();
                 try {
                     turing=new Turing(programma,input,statoIniziale);
                 } catch (TuringSyntaxError | IOException ex) {
                     //Logger.getLogger(TuringFXController.class.getName()).log(Level.SEVERE, null, ex);
                     JOptionPane.showMessageDialog(null, ex.getMessage());
                 }
                 //Logger.getLogger(TuringFXController.class.getName()).log(Level.SEVERE, null, ex);
                if(turing!=null){
                    this.txtOutput.setText("---"+this.txtInput.getText()+"-".repeat(this.txtInput.getText().length()));
                    
                    System.out.println("Input modificato:"+"---"+this.txtInput.getText()+"-".repeat(this.txtInput.getText().length()));
                    int i=turing.getIstruzioneInEsecuzione();
                   String v=turing.getTupla();

                   if(v!=null){
                       System.out.println(v);
                       this.txtPassoPasso.setText(v);
                       
                   }else{
                       System.out.println("Fine programma");
                       this.txtPassoPasso.setText("Fine programma");
                       btnInizio.setDisable(false);
                        btnPasso.setDisable(true);
                   }
                   btnInizio.setDisable(true);
                    btnPasso.setDisable(false);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Ricontrolla i campi di input. C'è quancola che non va");
            }
        }
     }
     
     private boolean controllaCampi() {
         if(this.txtAlfabeto.getText().isBlank()||this.txtInput.getText().isBlank() 
                 || this.txtProgramma.getText().isBlank()
                 || this.txtStatoIniziale.getText().isBlank())
         {
             JOptionPane.showMessageDialog(null,"Alcuni campi sono vuoti");
             return false;
         }
         int num=0;
         try{
             num=Integer.parseInt(txtStatoIniziale.getText().trim());
         }catch(NumberFormatException e){
             JOptionPane.showMessageDialog(null,"Il campo Stato Iniziale non contiene un numero");
             return false;
         }
         return controllaAlfabeto();
         //return true;
     }
     
     private boolean controllaAlfabeto(){
         //this.txtAlfabeto.setText(txtAlfabeto.getText()+"-");
         if(!this.txtAlfabeto.getText().isBlank() && !txtInput.getText().isBlank()){
             String alfabeto=txtAlfabeto.getText();
             String input=txtInput.getText();
             for(int i=0;i<input.length();i++){
                 String s=input.substring(i,i+1);
                 if(!alfabeto.contains(s)){ 
                     JOptionPane.showMessageDialog(null,"L'alfabeto non coincide con i caratteri di Input");
                     return false; 
                 }
             }return true;
         }else {
             JOptionPane.showMessageDialog(null,"I campi Alfabeto e/o Input sono vuoti");
             return false;
         }
     }
     
     
     
     private void azzeraCampi(){
         this.txtAlfabeto.setText("");
         this.txtInput.setText("");
         this.txtOutput.setText("");
         this.txtStatoIniziale.setText("");   
     }
    
}
