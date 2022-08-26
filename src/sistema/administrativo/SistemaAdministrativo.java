package sistema.administrativo;

import javax.swing.JFrame;

public class SistemaAdministrativo {

  
    public static void main(String[] args) {
       
       Ventana marco = new Ventana();
       marco.setVisible(true);
       marco.setTitle("Sistema administrativo de clientes y recursos"); 
       marco.setSize(450, 350);
       marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
