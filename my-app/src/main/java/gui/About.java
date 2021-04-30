package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class About extends JDialog {
    private final JPanel contentPanel = new JPanel();

    public static void main(String[] args) {
        try {
            About dialog = new About();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Création du constructeur de About

    public About() {
        setResizable(false);
        setBounds(100, 100, 639, 320);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setUndecorated(true);

        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[] { 131, 100, 154, 115, 119, 0 };
        gbl_contentPanel.rowHeights = new int[] { 0, 81, 42, 0 };
        gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };

        contentPanel.setLayout(gbl_contentPanel);
        {
            JLabel lblNewLabel = new JLabel("Parking; Gestion Parking");
            GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
            gbc_lblNewLabel.gridwidth = 5;
            gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
            gbc_lblNewLabel.gridx = 0;
            gbc_lblNewLabel.gridy = 1;
            lblNewLabel.setOpaque(true);
            lblNewLabel.setBackground(Color.orange);
            contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        }

        {
            JPanel panel1 = new JPanel();
            GridBagConstraints gbc_panel = new GridBagConstraints();
            gbc_panel.fill = GridBagConstraints.BOTH;
            gbc_panel.insets = new Insets(0, 0, 5, 0);
            gbc_panel.gridx = 0;
            gbc_panel.gridy = 1;
            contentPanel.add(panel1, gbc_panel);
            panel1.setLayout(new BorderLayout(0, 0));
            {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setIcon(new ImageIcon(getClass().getResource("/resources/assets/parking.png")));
                panel1.add(label, BorderLayout.NORTH);
            }

            {
                JLabel lblJudy = new JLabel("Judy", SwingConstants.CENTER);
                panel1.add(lblJudy, BorderLayout.SOUTH);

            }
        }
        {
            JPanel panel2 = new JPanel();
            GridBagConstraints gbc_panel = new GridBagConstraints();
            gbc_panel.fill = GridBagConstraints.BOTH;
            gbc_panel.insets = new Insets(0, 0, 5, 0);
            gbc_panel.gridx = 1;
            gbc_panel.gridy = 1;
            contentPanel.add(panel2, gbc_panel);
            panel2.setLayout(new BorderLayout(0, 0));
            {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setIcon(new ImageIcon(getClass().getResource("/resources/assets/fermer.png")));
                panel2.add(label, BorderLayout.NORTH);
            }

            {
                JLabel lblJudy = new JLabel("Jackie", SwingConstants.CENTER);
                panel2.add(lblJudy, BorderLayout.SOUTH);

            }
        }
        {
            JPanel panel3 = new JPanel();
            GridBagConstraints gbc_panel = new GridBagConstraints();
            gbc_panel.fill = GridBagConstraints.BOTH;
            gbc_panel.insets = new Insets(0, 0, 5, 0);
            gbc_panel.gridx = 3;
            gbc_panel.gridy = 1;
            contentPanel.add(panel3, gbc_panel);
            panel3.setLayout(new BorderLayout(0, 0));
            {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setIcon(new ImageIcon(getClass().getResource("/resources/assets/éclaire.png")));
                panel3.add(label, BorderLayout.NORTH);
            }

            {
                JLabel lblJudy = new JLabel("Judy", SwingConstants.CENTER);
                panel3.add(lblJudy, BorderLayout.SOUTH);

            }
        }
        {
            JPanel panel4 = new JPanel();
            GridBagConstraints gbc_panel = new GridBagConstraints();
            gbc_panel.fill = GridBagConstraints.BOTH;
            gbc_panel.insets = new Insets(0, 0, 5, 0);
            gbc_panel.gridx = 4;
            gbc_panel.gridy = 1;
            contentPanel.add(panel4, gbc_panel);
            panel4.setLayout(new BorderLayout(0, 0));
            {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setIcon(new ImageIcon(getClass().getResource("/resources/assets/bite.png")));
                panel4.add(label, BorderLayout.NORTH);
            }

            {
                JLabel lblJudy = new JLabel("Jackie", SwingConstants.CENTER);
                panel4.add(lblJudy, BorderLayout.SOUTH);

            }
        }
        {
            JLabel label = new JLabel("2021");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.SOUTH;
            gbc_label.insets = new Insets(0, 0, 5, 0);
            gbc_label.gridx = 2;
            gbc_label.gridy = 2;
            contentPanel.add(label, gbc_label);

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
                        dispose();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }

        }

    }
}
