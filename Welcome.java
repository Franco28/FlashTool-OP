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

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
    JFrame f = new JFrame("Select a Tool");
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Object response = JOptionPane.showInputDialog(null,
                "Choose One Tool", 
                "OnePlus Tool",
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                new String[] { "OnePlus 5 Tool", "OnePlus 5T Tool", "Xiaomi MI A2/6X Tool" },
                "OnePlus 5 Tool");       

        if(response == "OnePlus 5 Tool") {
        new OPVisual().setVisible(true);
   }
        
        if(response == "OnePlus 5T Tool") {
        if (runnable != null) runnable.run();
        JOptionPane.showMessageDialog(null, response+ " is not ready yet! :( ");   
        System.exit(0);
        }
        
        if(response == "Xiaomi MI A2/6X Tool") {
        if (runnable != null) runnable.run();
        JOptionPane.showMessageDialog(null, response+ " is not ready yet! :( ");   
        System.exit(0);
        }
        
    };
  }
    

