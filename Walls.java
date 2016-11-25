import java.awt.*;

/**
 * Created by nigel on 5/5/2016.
 */
public class Walls {
    public static int WALL_HEIGHT = MainScreen.HEIGHT;
    public static int WALL_WIDTH = 80;
    public static int WALL_DEPTH = 4;
    private int xPosition, yPosition;
    private static final Color brown = new Color(108, 42, 1);
    private static final Color darkOrange = new Color(177, 82, 31);
    private static final Color lightBlue = new Color(98, 155, 159);
    private static final Color steel = new Color(166, 180, 181);
    private double Temperature;
    public Type materialType;
    public static final int WALL_AREA = 320;
    //every 10 px is meter

    enum Type{

        ALUMINUM ("Aluminum",0.22, Color.lightGray, 2700, 205),
        COPPER ("Copper", 0.0932, darkOrange, 8940,385 ),
        GLASS ("Glass", 0.201, Color.cyan, 5000, 0.8),
        ICE ("Ice", 0.5, lightBlue, 917, 1.6),
        IRON_STEEL("Iron/Steel", 0.11, steel, 7850, 50.2),
        LEAD("Lead", 0.0311, Color.black, 11340, 34.7),
        WOOD("Wood", 0.401, brown, 510, 0.26);

        private String material;
        public double specificHeat, thermalConductivity;
        private Color materialColor;
        private int density;
        Type(String material, double specificHeat, Color materialColor, int density, double thermalConductivity){
            this.material = material;
            this.specificHeat = specificHeat;
            this.materialColor = materialColor;
            this.density = density;
            this.thermalConductivity = thermalConductivity;
        }

    }

    public Walls(int xPosition, int yPosition, String MaterialType){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        switch (MaterialType){
            case "Aluminum":
                materialType = Type.ALUMINUM;
                break;
            case "Copper":
                materialType = Type.COPPER;
                break;
            case "Glass":
                materialType = Type.GLASS;
                break;
            case "Ice":
                materialType = Type.ICE;
                break;
            case "Steel":
                materialType = Type.IRON_STEEL;
                break;
            case "Lead":
                materialType = Type.LEAD;
                break;
            case "Wood":
                materialType = Type.WOOD;
                break;

        }
    }
    public double materialHeat(){
        return materialType.specificHeat * WALL_AREA * 3;
    }
    public double rateOfHeatTransfer(){
        return materialType.thermalConductivity*WALL_AREA*3/WALL_DEPTH;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Type getMaterialType() {
        return materialType;
    }

    public void drawWalls(Graphics2D g){
        g.setColor(Color.white);
        g.fillRect(xPosition,yPosition,WALL_WIDTH,WALL_HEIGHT);
        g.setColor(materialType.materialColor);
        g.fillRect(xPosition,yPosition,WALL_WIDTH,WALL_HEIGHT);
    }
}
