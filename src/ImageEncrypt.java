import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static java.awt.Color.blue;

public class ImageEncrypt {
    public static void main(String[] args) {
            JFrame f = new JFrame();
            f.setTitle("Encrypt Image");
            f.setSize(400,200);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          // f.setDefaultLookAndFeelDecorated(true);
            JButton b = new JButton();
            b.setText("Open Image");


            JLabel labelM = new JLabel("enter key: ");

            JTextField t = new JTextField(10);
          //  t.setText("enter key:");
            f.setLayout(new FlowLayout());
            b.addActionListener(e -> {
                String text = t.getText();
                int i =  Integer.parseInt(text);
                operate(i);
            });

            f.add(labelM);
            f.add(t);
            f.add(b);
            f.setVisible(true);

    }

    private static void operate(int key) {
        JFileChooser filechosed = new JFileChooser();
        filechosed.showOpenDialog(null);
        File file = filechosed.getSelectedFile();

        try {
            FileInputStream fis = new FileInputStream(file);
            byte [] data = new byte[fis.available()];
            fis.read(data);
            int i =0 ;
            for (byte b : data){
                data[i] = (byte) (b^key);
                i++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"done");


        }
        catch (Exception e){
        e.printStackTrace();
        }
    }

}
