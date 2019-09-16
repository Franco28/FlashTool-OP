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
package mototool;

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
import java.util.Locale;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
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
 * @author Franco
 */
public class MotoTool extends Application {
   
    static String OS = System.getProperty("os.name").toLowerCase();
    static String LOCALE = System.getProperty("user.language");

    @Override
    public void start(Stage primaryStage) {
        String path = MotoTool.class.getResource("moto.mp3").toString();
        Media media = new Media(path);
        MediaPlayer mp = new MediaPlayer(media);
        
          //Detect OS Language
    Locale locale = Locale.getDefault();
    String lang = locale.getDisplayLanguage();
    String country = locale.getDisplayCountry();

    //Detect OS Language : Spanish
    if (isSpanish()){
            if(isWindows()){
        System.out.println("Lenguaje de " +OS+ " es " +LOCALE);
        System.out.println("Esto es: " +OS);
        try {
            System.out.println("Configurando " +OS+ " look and feel...");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            System.out.println("Listo! :) ");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
            if (runnable != null) runnable.run();
            System.out.println("No se pudo configurar el LookAndFeel");
        } 

        final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
        if (runnable != null) runnable.run();
                
            EventQueue.invokeLater(() -> {
            JLabel label = new JLabel();
            JFrame frame = new JFrame("Bienvenido a Moto Tool 1.0.0.0.RC1 " +OS+ " " +LOCALE);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            Socket sock= new Socket();
            InetSocketAddress addr=new InetSocketAddress("www.google.com",80);
           try{
               sock.connect(addr,3000);  
               mp.play();
               System.out.println("Reproduciendo Hello Moto :)...");
               URL imageURL = new URL("https://raw.githubusercontent.com/Franco28/FlashTool-OP/MotoTool/images/motosplash.gif");              
               label.setIcon(new ImageIcon(imageURL));
           }
           catch (MalformedURLException ex){
           System.out.println("No se pudo cargar la imágen de bienvenida");            
           } catch (IOException ex) {   
               frame.setTitle("Error con la conexión de red, el splash no funcionará y la herramienta no se cargará... " +ex);
               JOptionPane.showMessageDialog(null,"Verifique su conexión a Internet e intente nuevamente....","Error",JOptionPane.ERROR_MESSAGE);
           }
           frame.setIconImage(new ImageIcon(MotoTool.class.getResource("Icon.png")).getImage());
           frame.add(label, BorderLayout.CENTER);
           frame.setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());
           frame.setBackground(Color.RED);
           frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
           frame.setMinimumSize(new Dimension(800, 600));
           frame.setLocationRelativeTo(null);
           frame.setResizable(false);
           frame.setVisible(true);
            
        Object response = JOptionPane.showInputDialog(null,
                "Elija un Tool", 
                "Bienvenido a Moto Tool",
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                new String[] { "Moto Z3 Play Tool"},
                "Moto Z3 Play Tool");      
        
        if(response == "Moto Z3 Play Tool") {
        frame.setVisible(false);
        new MotoVisual().setVisible(true);
 }
                        
        if(response == null) {
        if (runnable != null) runnable.run();
        System.exit(0);
        }
        }); 
        }else if (isMac()) {
            JOptionPane.showOptionDialog(null, 
            OS+ " Este sistema operativo no está soportado por ahora!", 
            "No listo todavía!",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        } else if (isUnix()) {
            JOptionPane.showOptionDialog(null, 
            OS+ " Este sistema operativo no está soportado por ahora!", 
            "No listo todavía!",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        } else if (isSolaris()) {
            JOptionPane.showOptionDialog(null, 
            OS+ " Este sistema operativo no está soportado por ahora!", 
            "No listo todavía!",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        } else {
            JOptionPane.showOptionDialog(null, 
            OS+ " Este sistema operativo no está soportado por ahora!", 
            "No listo todavía!",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        }
    }
    
     //Detect OS Language : English    
    if (isEnglish()){
     if (isWindows()) {
        System.out.println("Language of the " +OS+ " is " +LOCALE);
        System.out.println("This is: " +OS);
        try {
            System.out.println("Setting " +OS+ " look and feel...");
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
            JFrame frame = new JFrame("Welcome To OnePlus Tool 1.0.3.9.RC1 " +OS+ " " +LOCALE);
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
        } else if (isMac()) {
            JOptionPane.showOptionDialog(null, 
            OS+ " it´s not available yet!", 
            "No ready yet",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        } else if (isUnix()) {
            JOptionPane.showOptionDialog(null, 
            OS+ " it´s not available yet!", 
            "No ready yet",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        } else if (isSolaris()) {
            JOptionPane.showOptionDialog(null, 
            OS+ " it´s not available yet!", 
            "No ready yet",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        } else if (isSpanish()) {
        System.exit(0);
        } else {
            JOptionPane.showOptionDialog(null, 
            OS+ " This OS it´s not supported!", 
            "No ready yet",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            new String[]{"Okey :("},
            null);
        System.exit(0);
        }
    }                          
    };
    
    
    public static boolean isSpanish(){
        return LOCALE.contains("es");
    }
    
    public static boolean isEnglish(){
        return LOCALE.contains("en");
    }
    
    public static boolean isWindows() {
        return OS.contains("win");
    }
     
    public static boolean isMac() {
        return OS.contains("mac");
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

    public static boolean isSolaris() {
        return OS.contains("sunos");
    }
    public static String getOS(){
        if (isWindows()) {
            return "win";
        } else if (isMac()) {
            return "osx";
        } else if (isUnix()) {
            return "uni";
        } else if (isSolaris()) {
            return "sol";
        } else {
            return "err";
        }
    }
    
    public static String getLocale() {
        if (isSpanish()) {
            return "es";
        }else if (isEnglish()) {
            return "en";
        }else {
            return "err";
        }
    }
        
       

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
