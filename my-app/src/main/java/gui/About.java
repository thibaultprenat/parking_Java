package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
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

        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[] { 131, 100, 154, 115, 119, 0 };
        gbl_contentPanel.rowHeights = new int[] { 123, 81, 42, 0 };
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
            JPanel panel = new JPanel();
            GridBagConstraints gbc_panel = new GridBagConstraints();
            gbc_panel.fill = GridBagConstraints.BOTH;
            gbc_panel.insets = new Insets(0, 0, 5, 0);
            gbc_panel.gridx = 0;
            gbc_panel.gridy = 1;
            contentPanel.add(panel, gbc_panel);
            panel.setLayout(new BorderLayout(0, 0));
            {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setIcon(new ImageIcon(getClass().getResource("/resources/assets/parking.png")));
                panel.add(label, BorderLayout.NORTH);
            }
        }

    }
}
