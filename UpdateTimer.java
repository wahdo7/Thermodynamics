import java.util.TimerTask;

public class updateTime extends TimerTask {
    public void run() {
        MainScreen.time += 0.1;
        double num = Math.round(MainScreen.time * 100.0) / 100.0;
        SidePanel.timelabel.setText(Double.toString(num));
    }
}
