package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import buisness.Vehicule;

public class AddVehicule extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField immaT;
    private JTextField modelT;
    private JTextField marqT;
    private JTextField propT;
    private Vehicule vehicule;
    final JComboBox<String> comboBox;

    public static void main(String[] args) {
        try {
            AddVehicule dialog = new AddVehicule();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    // création de la fenêtre de addVehicule
    public AddVehicule() {
        setBounds(100, 100, 287, 287);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(5, 2, 0, 0));
        {
            JLabel label = new JLabel("Immatriculation");
            contentPanel.add(label);
            immaT = new JTextField();
            contentPanel.add(immaT);
            immaT.setColumns(10);
        }
        {
            JLabel label = new JLabel("Modèle");
            contentPanel.add(label);
            modelT = new JTextField();
            contentPanel.add(modelT);
            modelT.setColumns(10);
        }
        {
            JLabel label = new JLabel("Marque");
            contentPanel.add(label);
            marqT = new JTextField();
            contentPanel.add(marqT);
            marqT.setColumns(10);
        }
        {
            JLabel label = new JLabel("Propriétaire");
            contentPanel.add(label);
            propT = new JTextField();
            contentPanel.add(propT);
            propT.setColumns(10);
        }
        {
            JLabel label = new JLabel("Type de véhicule");
            contentPanel.add(label);
            comboBox = new JComboBox<String>();
            comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Moto", "Voiture", "Camion" }));
            contentPanel.add(comboBox);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (immaT.getText().length() == 0 || modelT.getText().length() == 0
                                || marqT.getText().length() == 0 || propT.getText().length() == 0) {
                            JOptionPane.showMessageDialog(null, "Tous les champs sont requis", "Erreur",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        String cn = "buisness." + (String) comboBox.getSelectedItem();
                        try {
                            Constructor<?> constructor = Class.forName(cn).getConstructor(String.class, String.class,
                                    String.class, String.class);
                            vehicule = (Vehicule) constructor.newInstance(new Object[] { immaT.getText(),
                                    modelT.getText(), marqT.getText(), propT.getText() });

                            dispose();

                        } catch (InstantiationException | NoSuchMethodException | SecurityException
                                | ClassNotFoundException | IllegalAccessException | IllegalArgumentException
                                | InvocationTargetException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
