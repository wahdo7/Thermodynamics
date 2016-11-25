import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel {
    JTextField widthtext = new JTextField(10);

    JTextField depthtext = new JTextField(10);

    JTextField heighttext = new JTextField(10);

    JLabel widthtitle = new JLabel("Wall Width");

    JLabel depthtitle = new JLabel("Wall Depth");

    JLabel heighttitle = new JLabel("Wall Height");

    JButton confirmbutton = new JButton("Confirm Changes");

    Font titlefont = new Font("Arial", Font.BOLD, 18);

    public SettingsPanel () {

        widthtitle.setFont(titlefont);
        widthtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(widthtitle);

        add(widthtext);

        add(Box.createRigidArea(new Dimension(0,20)));

        depthtitle.setFont(titlefont);
        depthtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(depthtitle);

        add(depthtext);

        add(Box.createRigidArea(new Dimension(0,20)));

        heighttitle.setFont(titlefont);
        heighttitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(heighttitle);

        add(heighttext);

        add(Box.createRigidArea(new Dimension(0,20)));

        confirmbutton.setMaximumSize(new Dimension(140,100));
        confirmbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(confirmbutton);
        confirmbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainScreen.wall1.WALL_HEIGHT= Integer.valueOf(heighttext.getText());
                MainScreen.wall2.WALL_HEIGHT= Integer.valueOf(heighttext.getText());
                MainScreen.wall1.WALL_DEPTH= Integer.valueOf(depthtext.getText());
                MainScreen.wall2.WALL_DEPTH= Integer.valueOf(depthtext.getText());
                MainScreen.wall1.WALL_WIDTH= Integer.valueOf(widthtext.getText());
                MainScreen.wall2.WALL_WIDTH= Integer.valueOf(widthtext.getText());
            }
        });
    }
}
