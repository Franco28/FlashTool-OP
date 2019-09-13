/*
 * Copyright 2019 Franco.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Tool Welcome
 * 
 * @author (Franco Mato - franco28) 
 * @version (1.0.2.9.RC1)
 * 
 * 
 */

package oneplus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author franco28
 */
public interface Welcome {
    public static void main(String args[]) throws IOException { 

        try {
            System.out.println("Setting look and feel...");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            System.out.println("Ready! :) ");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
            if (runnable != null) runnable.run();
            System.out.println("Unable to set LookAndFeel");
        }   
                
        final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
        if (runnable != null) runnable.run();
   
            EventQueue.invokeLater(() -> {
            JLabel label = new JLabel();
            JFrame frame = new JFrame("Welcome To OnePlus Tool 1.0.2.9.RC1");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            Socket sock= new Socket();
            InetSocketAddress addr=new InetSocketAddress("www.google.com",80);
           try{
               sock.connect(addr,3000);  
               URL imageURL = new URL("https://raw.githubusercontent.com/Franco28/FlashTool-OP/master/src/oneplus/images/splash.gif");              
               label.setIcon(new ImageIcon(imageURL));
           }
           catch (MalformedURLException ex){
           System.out.println("Unable to read the splash");            
           } catch (IOException ex) {   
               frame.setTitle("Error with network connection, the splash wont´t work and Tool won´t load... " +ex);
               JOptionPane.showMessageDialog(null,"Check your internet connection and try again....","Error",JOptionPane.ERROR_MESSAGE);
           }

           frame.add(label, BorderLayout.CENTER);
           frame.setBackground(Color.RED);
           frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
           frame.setMinimumSize(new Dimension(800, 600));
           frame.setLocationRelativeTo(null);
           frame.setResizable(false);
           frame.setVisible(true);
            
        Object response = JOptionPane.showInputDialog(null,
                "Choose One Tool", 
                "Welcome to OnePlus Tool",
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                new String[] { "OnePlus 5 Tool", "OnePlus 5T Tool", "Xiaomi MI A2/6X Tool" },
                "OnePlus 5 Tool");      
        
        if(response == "OnePlus 5 Tool") {
        frame.setVisible(false);
        new OPVisual().setVisible(true);
   }
        
        if(response == "OnePlus 5T Tool") {
        if (runnable != null) runnable.run();
        JOptionPane.showOptionDialog(null, 
            response+ " is not ready yet! :(, im working on it!", 
            "No ready yet",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        }
        
        if(response == "Xiaomi MI A2/6X Tool") {
        if (runnable != null) runnable.run();
        JOptionPane.showOptionDialog(null, 
            response+ " is not ready yet! :(", 
            "No ready yet",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        }
        
        if(response == null) {
        if (runnable != null) runnable.run();
        System.exit(0);
        }
        });
    };

  }
    

