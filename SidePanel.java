import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by nigel on 5/5/2016.
 */
public class SidePanel extends JPanel {

    JSlider outsidetempslide = new JSlider(0,100,50);
    JSlider insidetempslide = new JSlider(0,100,50);

    JLabel menu1title = new JLabel("Wall 1 Material");

    JLabel menu2title = new JLabel("Wall 2 Material");

    JLabel slidertitle = new JLabel("Outside Temperature");
    JLabel sliderundertitle = new JLabel("°C");
    JLabel insideslidertitle = new JLabel("Inside Temperature");

    JLabel timetitle = new JLabel("Time");

    static JLabel timelabel = new JLabel("0.0");

    JPanel buttonpanel = new ButtonPanel();
    BoxLayout boxlayout3 = new BoxLayout(buttonpanel, BoxLayout.X_AXIS);

    JPanel buttonpanel2 = new OtherButtonPanel();
    BoxLayout boxlayout4 = new BoxLayout(buttonpanel2, BoxLayout.X_AXIS);

    public static String[] choices = { "Aluminum","Copper", "Glass","Ice","Steel","Lead","Wood"};
    public static final JComboBox<String> wall1menu = new JComboBox<String>(choices);
    public static final JComboBox<String> wall2menu = new JComboBox<String>(choices);

    Font sliderfont = new Font("Serif", Font.BOLD, 15);
    Font titlefont = new Font("Arial", Font.BOLD, 18);
    Font outputfont = new Font("Arial", Font.BOLD, 24);

    public int getOutsideTemp(){
        return outsidetempslide.getValue();
    }

    public int getWallTemp(){
        return insidetempslide.getValue();
    }

    public SidePanel() {

        menu1title.setFont(titlefont);
        menu1title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(menu1title);

        add(Box.createRigidArea(new Dimension(0,10)));

        wall1menu.setSize(100,20);
        wall1menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(wall1menu);
        wall1menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainScreen.wall1type = String.valueOf(MainScreen.sidePanel.wall1menu.getSelectedItem());
                MainScreen.wall1 = new Walls(179,0, MainScreen.wall1type);
                MainScreen.wallpanel.setVisible(true);
                MainScreen.wallpanel.remove(MainScreen.c);
                MainScreen.containerPanel.remove(MainScreen.sidePanel);
                MainScreen.c = new MainScreen();
                MainScreen.wallpanel.add(MainScreen.c);
                MainScreen.containerPanel.add(MainScreen.wallpanel);
                MainScreen.containerPanel.add(MainScreen.sidePanel);
                MainScreen.containerPanel.setVisible(true);
                MainScreen.frame.setVisible(true);
            }
        });

        add(Box.createRigidArea(new Dimension(0,30)));

        menu2title.setFont(titlefont);
        menu2title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(menu2title);

        add(Box.createRigidArea(new Dimension(0,10)));

        wall2menu.setSize(100,20);
        wall2menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(wall2menu);
        wall2menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainScreen.wall2type = String.valueOf(MainScreen.sidePanel.wall2menu.getSelectedItem());
                MainScreen.wall2 = new Walls(280,00, MainScreen.wall2type);
                MainScreen.wallpanel.setVisible(true);
                MainScreen.wallpanel.remove(MainScreen.c);
                MainScreen.containerPanel.remove(MainScreen.sidePanel);
                MainScreen.c = new MainScreen();
                MainScreen.wallpanel.add(MainScreen.c);
                MainScreen.containerPanel.add(MainScreen.wallpanel);
                MainScreen.containerPanel.add(MainScreen.sidePanel);
                MainScreen.containerPanel.setVisible(true);
                MainScreen.frame.setVisible(true);

            }
        });

        add(Box.createRigidArea(new Dimension(0,30)));

        slidertitle.setFont(titlefont);
        slidertitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(slidertitle);



        add(Box.createRigidArea(new Dimension(0,10)));

        outsidetempslide.setMajorTickSpacing(20);
        outsidetempslide.setPaintTicks(true);
        outsidetempslide.setFont(sliderfont);
        outsidetempslide.setPaintLabels(true);
        outsidetempslide.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(outsidetempslide);
        outsidetempslide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                OutputPanel.outtemp.setText(String.valueOf(MainScreen.sidePanel.getOutsideTemp()));
            }
        });

        add(Box.createRigidArea(new Dimension(0,20)));

        insideslidertitle.setFont(titlefont);
        insideslidertitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(insideslidertitle);

        add(Box.createRigidArea(new Dimension(0,10)));

        insidetempslide.setMajorTickSpacing(20);
        insidetempslide.setPaintTicks(true);
        insidetempslide.setFont(sliderfont);
        insidetempslide.setPaintLabels(true);
        insidetempslide.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(insidetempslide);
        insidetempslide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                OutputPanel.intemp.setText(String.valueOf(MainScreen.sidePanel.insidetempslide.getValue()));
            }
        });

        sliderundertitle.setFont(sliderfont);
        sliderundertitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(sliderundertitle);

        add(Box.createRigidArea(new Dimension(0,25)));

        timetitle.setFont(titlefont);
        timetitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(timetitle);

        timelabel.setFont(outputfont);
        timelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(timelabel);

        add(Box.createRigidArea(new Dimension(0,25)));

        buttonpanel.setLayout(boxlayout3);
        add(buttonpanel);

        add(Box.createRigidArea(new Dimension(0,20)));

        buttonpanel2.setLayout(boxlayout4);
        add(buttonpanel2);

        //this.setBorder(BorderFactory.createLineBorder(Color.black, 4));

    }

    public static boolean getRunning() {
        return ButtonPanel.getRunning();
    }
}
