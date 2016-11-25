import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtherButtonPanel extends JPanel {
    JButton outputbutton = new JButton("Outputs");

    JButton settingsbutton = new JButton("Settings");

    public OtherButtonPanel () {

        outputbutton.setMaximumSize(new Dimension(80,100));
        add(outputbutton);
        outputbutton.addActionListener(new ActionListener() {

            public void actionPerformed (ActionEvent e) {
                JFrame outputFrame = new JFrame("Outputs");
                JPanel outputPanel = new OutputPanel();
                outputPanel.setPreferredSize(new Dimension(320,400));
                outputPanel.setVisible(true);

                BoxLayout boxlayout2 = new BoxLayout(outputPanel, BoxLayout.Y_AXIS);
                outputPanel.setLayout(boxlayout2);
                outputPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

                outputFrame.add(outputPanel);

                outputFrame.pack();
                outputFrame.setResizable(false);
                outputFrame.setVisible(true);
                outputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        });

        add(Box.createRigidArea(new Dimension(40,0)));

        settingsbutton.setMaximumSize(new Dimension(80,100));
        add(settingsbutton);
        settingsbutton.addActionListener(new ActionListener() {

            public void actionPerformed (ActionEvent e) {
                JFrame settingsFrame = new JFrame("Settings");
                JPanel settingsPanel = new SettingsPanel();
                settingsPanel.setPreferredSize(new Dimension(250,250));
                settingsPanel.setVisible(true);

                BoxLayout boxlayout2 = new BoxLayout(settingsPanel, BoxLayout.Y_AXIS);
                settingsPanel.setLayout(boxlayout2);
                settingsPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

                settingsFrame.add(settingsPanel);

                settingsFrame.pack();
                settingsFrame.setResizable(false);
                settingsFrame.setVisible(true);
                settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        });
    }
}
