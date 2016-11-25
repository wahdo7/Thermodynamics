import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;


public class ButtonPanel extends JPanel {

    public static boolean isrunning = false;

    Timer timer;

    JButton startbutton = new JButton("Start");

    JButton resetbutton = new JButton("Reset");

    public ButtonPanel () {

        startbutton.setMaximumSize(new Dimension(80,100));
        add(startbutton);

        startbutton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (isrunning == false) {

                    isrunning = true;
                    startbutton.setText("Stop");
                    timer = new Timer();
                    timer.schedule(new updateTime(), 0, 100);
                    timer.schedule(new updateStuff(), 0, 100);
                    System.out.print(MainScreen.getWallTemperature());
                }

                else {
                    isrunning = false;
                    startbutton.setText("Start");

                    timer.cancel();
                    timer.purge();

                }
            }
        });

        add(Box.createRigidArea(new Dimension(40,0)));

        resetbutton.setMaximumSize(new Dimension(80,100));
        add(resetbutton);

        resetbutton.addActionListener(new ActionListener() {

            public void actionPerformed (ActionEvent e) {
                MainScreen.setTime(0.0);
                MainScreen.sidePanel.outsidetempslide.setValue(50);
                MainScreen.sidePanel.insidetempslide.setValue(50);
                MainScreen.setTime(0.0);
                MainScreen.insideTemperature = 0;
                MainScreen.currentHeat = 0;
                OutputPanel.totalheatlabel.setText("0");
                OutputPanel.netheatlabel.setText("0");
                OutputPanel.heatratelabel.setText("0");

                isrunning = false;
                startbutton.setText("Start");
                timer.cancel();
                timer.purge();
            }
        });

    }

    public static boolean getRunning() {
        return isrunning;
    }

}

