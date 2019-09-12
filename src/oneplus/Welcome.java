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
package oneplus;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.net.MalformedURLException;
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
    
    public static void main(String args[]) { 
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
           label.setHorizontalAlignment(SwingConstants.CENTER);
           try{

               URL imageURL = new URL("https://cdn.dribbble.com/users/299266/screenshots/1700676/1_dribbble.gif");
               
               label.setIcon(new ImageIcon(imageURL));
           }
           catch (MalformedURLException ex){
           }        
           JFrame frame = new JFrame("Welcome to OnePlus Tool");
           frame.setIconImage(new ImageIcon("Icon.png").getImage());
           frame.add(label, BorderLayout.CENTER);
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
        new OPVisual5T().setVisible(true);
        }
        
        if(response == "Xiaomi MI A2/6X Tool") {
        if (runnable != null) runnable.run();
        JOptionPane.showMessageDialog(null, response+ " is not ready yet! :( ");   
        System.exit(0);
        }
        
        if(response == null) {
        System.exit(0);
   }
        });
    };
  }
    

