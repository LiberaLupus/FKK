package sample.Functions;

import javax.swing.*;

public class MessageBox {

    public void MessageBoxOK(String ausgabe){
        Object[] options = {"OK"};
        JOptionPane.showConfirmDialog(null,
                ausgabe,
                "",
                JOptionPane.DEFAULT_OPTION);

        int eingabe = JOptionPane.showConfirmDialog(null,
                "Möchten Sie sich auslogen?",
                "",
                JOptionPane.YES_NO_OPTION);
        System.out.println(eingabe);
        if (eingabe == 0){

        }else{

        }
    }
}
