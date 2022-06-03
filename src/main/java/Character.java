import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Abir Elşekaki
 */
public class Character {
    private Point position;
    private char value;
    private Color color = Color.BLACK;
    private final int index;

    public Character(int index, Point position, char value) {
        this.position = position;
        this.value = value;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public String getValue() {
        return String.valueOf(value);
    }

    public void setValue(char value) {
        this.value = value;
    }

}
