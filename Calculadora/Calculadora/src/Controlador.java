/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DAVINCI
 */

public class Controlador {
    Calculadora c;
    String signo;
    double numero1;
    boolean numero2;
    public Controlador(Calculadora c) {
        this.c = c;
    }
    
    public void limpiar(){
        c.setText("0");
    }
    
     public void resultado(){
      
    double numero2 = Double.parseDouble(c.getText());
    double resultado = 0;

    if (signo.equals("+")) {
        resultado = numero1 + numero2;
    } else if (signo.equals("-")) {
        resultado = numero1 - numero2;
    } else if (signo.equals("*")) {
        resultado = numero1 * numero2;
    } else if (signo.equals("/")) {
        resultado = numero1 / numero2;
    }

    c.setText(String.valueOf(resultado));
    

     }
     
     public void eventoDecimal(){
         
     }
     
     public void eventoOperacion(String signo){
       numero1 = Double.parseDouble(c.getText());
       this.signo = signo;
       numero2 = true;
    }
     
     public void añadirNumero(String numero) {
    String numeroActual = c.getText();

    if (numero2 || numeroActual.equals("0") || numeroActual.equals("+") ||numeroActual.equals("-") || numeroActual.equals("/") || numeroActual.equals("*") ) {
        
        c.setText(numero);
        numero2 = false;
    } else {
         
        c.setText(numeroActual + numero);
    }
}
}
