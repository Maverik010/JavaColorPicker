import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Component;
// import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class wybor_kolorow extends JFrame{

    public static void addComponentsToPane(Container pane){
        /*

        DODANIE KOMPONENTÓW DO KONTENERA

        */

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        addAButton("Wybierz Kolor", pane);
        addALabel("To jest przykładowy tekst", pane);
    }

    public void wcisniecieGuzika(JButton przycisk){

        /*

        AKCJA WYKONOWANA NA PRZYCISKU

        */

        Color c = JColorChooser.showDialog(null, "Wybierz kolor", przycisk.getForeground());
        if (c != null)
            przycisk.setForeground(c);
    }

    private static void addALabel(String text, Container container){

        /*

        FUNKCJA TWORZĄCA NAPIS W KONTENERZE

        */
        JLabel przykladowyTekst = new JLabel("To jest przykładowy tekst.");
        przykladowyTekst.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(przykladowyTekst);
    }

    private static void addAButton(String text, Container container){
        
        /*

        FUNKCJA TWORZĄCA PRZYCISK W KONTENERZE
        
        */

        JButton przyciskWyboru = new JButton (text);
        przyciskWyboru.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(przyciskWyboru);
        
        // PRZYPISANIE FUNKCJI DO AKCJI NA GUZIKU
        przyciskWyboru.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                wcisniecieGuzika();
            }
        });
    }

    private static void createAndShowGUI() {
        /*

        WYŚWIETLENIE U UŁOŻENIE ELEMENTÓW W KONTENERZE - RAMCE

        */

        JFrame frame = new JFrame("Wybór kolorów");
        frame.setTitle("Wybór kolorów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DODANIE OBIEKTÓW DO RAMKI
        addComponentsToPane(frame.getContentPane());

        //WYŚWIETLENIE OKNA
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        //UTWORZENIE PROCESU DO NASŁUCHIWANIA EVENTÓW
        //TWORZENIE I WYŚWIETLENIE INTERFACEU APLIKACJI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    }
