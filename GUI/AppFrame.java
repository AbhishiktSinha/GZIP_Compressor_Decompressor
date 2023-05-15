package GUI;

import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import CompDecomp.*;

public class AppFrame extends JFrame implements ActionListener
{
    JButton compButton;
    JButton decompButton;

    AppFrame()
    {
        ImageIcon icon = new ImageIcon("gzip.png");
        this.setSize(720, 480);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setTitle("GZIP Compressor and Decompressor");
        this.setFont(new Font("Arial", Font.ITALIC, 13));
        this.setIconImage(icon.getImage());

        compButton = new JButton("Select file to compress");
        compButton.addActionListener(this);

        compButton.setBounds(240, 100, 200, 50);
        compButton.setFocusable(false);
        compButton.setBackground(new Color(133, 177, 229));
        compButton.setFont(new Font("Droid Sans", Font.PLAIN, 13));
        compButton.setForeground(Color.DARK_GRAY);
        compButton.setBorder(BorderFactory.createEtchedBorder());
        compButton.setVisible(true);

        decompButton = new JButton("Select file to decompress");
        decompButton.addActionListener(this);

        decompButton.setBounds(240, 200, 200, 50);
        decompButton.setFocusable(false);
        decompButton.setBackground(new Color(133, 177, 229));
        decompButton.setFont(new Font("Droid Sans", Font.PLAIN, 13));
        decompButton.setForeground(Color.DARK_GRAY);
        decompButton.setBorder(BorderFactory.createEtchedBorder());
        decompButton.setVisible(true);

        this.add(compButton);
        this.add(decompButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == compButton)
        {
            JFileChooser selector = new JFileChooser();
            int response = selector.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(selector.getSelectedFile().getAbsolutePath());

                try
                {
                    Compressor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if(e.getSource() == decompButton)
        {
            JFileChooser selector = new JFileChooser();
            int response = selector.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(selector.getSelectedFile().getAbsolutePath());

                try
                {
                    Decompresssor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
