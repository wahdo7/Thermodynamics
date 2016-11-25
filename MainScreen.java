import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;



/**
 * Created by nigel on 5/5/2016.
 */

public class MainScreen extends JPanel {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 900;
    private BufferedImage image;
    public static Graphics2D bufferedGraphics;
    public static Walls wall1, wall2;
    public static double wallTemperature;
    public static double insideTemperature;
    public static double time = 0;
    public static String wall1type, wall2type;
    public static double currentHeat = 0;
    public static double currentHeat2 = 0;

    public MainScreen(){
        super();
        setPreferredSize(new Dimension(WIDTH - 250,HEIGHT));
        image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
        bufferedGraphics = image.createGraphics();
        wall1type = String.valueOf(sidePanel.wall1menu.getSelectedItem());
        wall2type = String.valueOf(sidePanel.wall2menu.getSelectedItem());
        wall1 = new Walls(179,0, wall1type);
        wall2 = new Walls(260,0, wall2type);
        requestFocus();
    }

    public static double getWallTemperature(){
        wallTemperature = (wall1.materialType.thermalConductivity*sidePanel.outsidetempslide.getValue()+wall2.materialType.thermalConductivity*sidePanel.insidetempslide.getValue())
                /(wall1.materialType.thermalConductivity+wall2.materialType.thermalConductivity);
        return wallTemperature;
    }

    public static double rateOfHeatTransfer(){
        double rate1, rate2;
        rate1 = (wall1.materialType.thermalConductivity*wall1.WALL_AREA*(sidePanel.outsidetempslide.getValue()-getWallTemperature()))/(wall1.WALL_WIDTH/10);
        rate2 = (wall2.materialType.thermalConductivity*wall2.WALL_AREA*(getWallTemperature()-sidePanel.insidetempslide.getValue()))/(wall2.WALL_WIDTH/10);
        if (Double.valueOf(sidePanel.timelabel.getText())==0){
            return 0;
        }else {
            if (rate1 > rate2) {
                return rate2;
            } else if (rate2 == rate1) {
                return rate1;
            } else {
                return rate1;
            }
        }
    }

    public static double totalHeatTransfered() {
        if (rateOfHeatTransfer() < 0) {
            double heatChange2 = 0.1 * -(rateOfHeatTransfer());
            currentHeat2 += heatChange2;
            return currentHeat2;
        }else if (rateOfHeatTransfer()>0){
            double heatChange2 = 0.1*rateOfHeatTransfer();
            currentHeat2 += heatChange2;
            return currentHeat2;
        }else {
            return currentHeat2;
        }
    }

    public static double netHeatTransfered() {
        double heatChange = 0.1 * rateOfHeatTransfer();
        currentHeat += heatChange;
        return currentHeat;
    }

    public static void updateHeat(String s){
        OutputPanel.totalheatlabel.setText(s);
    }

    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        bufferedGraphics.clearRect(0,0,WIDTH - 250, HEIGHT);
        bufferedGraphics.setColor(Color.WHITE);
        bufferedGraphics.fillRect(0,0,WIDTH - 250,HEIGHT);
        wall1.drawWalls(bufferedGraphics);
        wall2.drawWalls(bufferedGraphics);
        g.drawImage(image,0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }

    public static SidePanel sidePanel;
    public static JFrame frame;
    public static MainScreen c;
    public static  JPanel wallpanel,containerPanel;
    public static BoxLayout boxlayout;

    public static void main(String[] args){
        frame = new JFrame("Thermodynamics");
        //JFrame outputFrame = new JFrame("Outputs");

        c = new MainScreen();
        wallpanel = new JPanel();
        wallpanel.add(c);
        wallpanel.setPreferredSize(new Dimension (WIDTH - 250, 600));
        wallpanel.setVisible(true);

        sidePanel = new SidePanel();
        sidePanel.setPreferredSize(new Dimension(250,600));
        sidePanel.setVisible(true);

        boxlayout = new BoxLayout(sidePanel, BoxLayout.Y_AXIS);
        sidePanel.setLayout(boxlayout);

        sidePanel.setBorder(new EmptyBorder(new Insets(40, 20, 40, 20)));

        containerPanel = new JPanel();
        containerPanel.add(wallpanel);
        containerPanel.add(sidePanel);
        containerPanel.setPreferredSize(new Dimension (WIDTH, HEIGHT));

        frame.add(containerPanel);

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*JPanel outputPanel = new OutputPanel();
        outputPanel.setPreferredSize(new Dimension(320,400));
        outputPanel.setVisible(true);

        BoxLayout boxlayout2 = new BoxLayout(outputPanel, BoxLayout.Y_AXIS);
        outputPanel.setLayout(boxlayout2);
        outputPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        outputFrame.add(outputPanel);

        outputFrame.pack();
        outputFrame.setResizable(false);
        outputFrame.setVisible(true);
        outputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); */

    }

    public static void setTime(double aTime) {
        time = aTime;
        SidePanel.timelabel.setText(Double.toString(time));
    }
}
