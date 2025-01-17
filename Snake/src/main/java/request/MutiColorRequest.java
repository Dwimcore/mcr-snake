package request;

        import java.awt.*;
        import java.util.ArrayList;

public class MutiColorRequest implements Request {
    private ArrayList<Color> colors = new ArrayList<Color>();
    private int score;

    public MutiColorRequest(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public int getScore() {
        return score;
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.MULTICOLORREQUEST;
    }
}
