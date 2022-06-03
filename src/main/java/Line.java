import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Color;

/**
 *
 * @author Abir Elşekaki
 */
public class Line {
    private Point pointStart;
    private Point pointEnd;

    private Character startChar = null;
    private Character endChar = null;

    public void paint(Graphics2D g){
        
        if (pointStart != null) {
            g.setColor(Color.BLACK);
            g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
            g.drawLine(pointEnd.x - 5, pointEnd.y - 5, pointEnd.x + 5, pointEnd.y  + 5);
            g.drawLine(pointEnd.x + 5, pointEnd.y - 5 , pointEnd.x - 5, pointEnd.y  + 5);
        }
    }

    public void setPointStart(Point pointStart)
    {
        this.pointStart = pointStart;
    }

    public void setPointEnd(Point pointEnd)
    {
        this.pointEnd = pointEnd;
    }

    public Character getStartChar()
    {
        return startChar;
    }

    public void setStartChar(Character startChar)
    {
        this.startChar = startChar;
    }

    public Character getEndChar()
    {
        return endChar;
    }

    public void setEndChar(Character endChar)
    {
        this.endChar = endChar;
    }

    public Point getPointStart() {
        return pointStart;
    }

    public Point getPointEnd() {
        return pointEnd;
    }
    
    public boolean hasCharacters(){
        return this.startChar != null && this.endChar != null;
    }
    
}
