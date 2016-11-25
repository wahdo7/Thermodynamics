import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
public class OutputPanel extends JPanel {

    JLabel heatratetitle = new JLabel("Rate of Heat Transfer (W or J/s)");

    public static JLabel heatratelabel = new JLabel(String.valueOf(MainScreen.rateOfHeatTransfer()));

    JLabel totalheattitle = new JLabel("Total Heat Transferred (J)");

    public static JLabel totalheatlabel = new JLabel(String.valueOf(MainScreen.totalHeatTransfered()));

    JLabel outtemptitle = new JLabel("Outside Temperature (°C)");
    JLabel walltemptitle = new JLabel("Inside Temperature (°C)");

    public static JLabel outtemp = new JLabel(String.valueOf(MainScreen.sidePanel.outsidetempslide.getValue()));
    public static JLabel walltemp = new JLabel(String.valueOf(MainScreen.sidePanel.insidetempslide.getValue()));

    JLabel intemptitle = new JLabel("Inside Temperature(°C)");

    public static JLabel intemp = new JLabel(String.valueOf(MainScreen.sidePanel.insidetempslide.getValue()));

    JLabel netheattitle = new JLabel("Net Heat Transferred (J)");

    public static JLabel netheatlabel = new JLabel(String.valueOf(MainScreen.netHeatTransfered()));

    Font titlefont = new Font("Arial", Font.BOLD, 18);
    Font outputfont = new Font("Arial", Font.BOLD, 24);

    public OutputPanel() {
        outtemptitle.setFont(titlefont);
        outtemptitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(outtemptitle);

        outtemp.setFont(outputfont);
        outtemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(outtemp);

        add(Box.createRigidArea(new Dimension(0,30)));

        intemptitle.setFont(titlefont);
        intemptitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(intemptitle);

        intemp.setFont(outputfont);
        intemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(intemp);

        add(Box.createRigidArea(new Dimension(0,30)));

        heatratetitle.setFont(titlefont);
        heatratetitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(heatratetitle);

        heatratelabel.setFont(outputfont);
        heatratelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(heatratelabel);


        add(Box.createRigidArea(new Dimension(0,20)));

        totalheattitle.setFont(titlefont);
        totalheattitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(totalheattitle);

        totalheatlabel.setFont(outputfont);
        totalheatlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(totalheatlabel);

        add(Box.createRigidArea(new Dimension(0,20)));

        netheattitle.setFont(titlefont);
        netheattitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(netheattitle);

        netheatlabel.setFont(outputfont);
        netheatlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(netheatlabel);
    }
}
