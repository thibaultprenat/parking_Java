package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import buisness.Parking;
import exeption.PasAssezDobservateurException;

public class ParkingUI {
    private JFrame frame;
    private Parking parking = Parking.getInstance();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ParkingUI window = new ParkingUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;
            }
        });
    }

    public ParkingUI() throws PasAssezDobservateurException, ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 828, 491);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));

        JMenuBar menuBar = new JMenuBar();
        frame.getContentPane().add(menuBar, BorderLayout.NORTH);

        JMenu monFichier = new JMenu("Fichier");
        menuBar.add(monFichier);

        JMenuItem monNewMenuItem_1 = new JMenuItem("Imprimer");
        monFichier.add(monNewMenuItem_1);
        monNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);

        JMenuItem monNewMenuItem_2 = new JMenuItem("Quitter");
        monNewMenuItem_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSED));
            }
        });
        monFichier.add(monNewMenuItem_2);

        JMenuItem monNewMenuItem_3 = new JMenuItem("A propos");
        monNewMenuItem_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About about = new About();
            }
        });
        monFichier.add(monNewMenuItem_3);
    }
}
