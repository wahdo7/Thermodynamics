import java.util.TimerTask;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class updateStuff extends TimerTask {
    public void run() {
        MainScreen.insideTemperature = MainScreen.sidePanel.insidetempslide.getValue();
        OutputPanel.intemp.setText(Integer.toString(intValue(MainScreen.sidePanel.insidetempslide.getValue())));

        OutputPanel.heatratelabel.setText(Integer.toString(intValue(MainScreen.rateOfHeatTransfer())));

        OutputPanel.totalheatlabel.setText(Integer.toString(intValue(MainScreen.totalHeatTransfered())));

        OutputPanel.netheatlabel.setText(Integer.toString(intValue(MainScreen.netHeatTransfered())));
    }
}
