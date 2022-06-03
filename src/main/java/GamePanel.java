
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Abir Elşekaki
 */
public class GamePanel extends JPanel
{
  private Point pointStart = null;
  private Point pointEnd = null;
  private Chars cs;
  public ArrayList<Line> lines = new ArrayList<>();
  private Line currentLine = null;

  private final ArrayList<String> words;

  public GamePanel(ArrayList<String> words)
  {

    this.words = words;

    Collections.shuffle(words);

    cs = new Chars(words.get(0));
    lines = new ArrayList<>();
    currentLine = null;

    this.setVisible(true);
  }

  {
    javax.swing.GroupLayout charsContainerLayout = new javax.swing.GroupLayout(this);
    setLayout(charsContainerLayout);
    charsContainerLayout.setHorizontalGroup(charsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 500, Short.MAX_VALUE));
    setMaximumSize(new java.awt.Dimension(500, 500));
    setMinimumSize(new java.awt.Dimension(500, 500));
    setPreferredSize(new java.awt.Dimension(500, 500));

    addMouseListener(new MouseAdapter()
    {
      @Override
      public void mousePressed(MouseEvent e)
      {
        pointStart = e.getPoint();

        Character clickedChar = cs.getCharacterByPosition(pointStart);

        if(clickedChar != null)
        {
          currentLine = new Line();

          currentLine.setPointStart(pointStart);

          currentLine.setStartChar(clickedChar);

          removeDuplicateLines(currentLine.getStartChar(), null);
        }
      }

      @Override
      public void mouseReleased(MouseEvent e)
      {
        if(currentLine != null){

          Character endChar = cs.getCharacterByPosition(pointEnd);

          currentLine.setEndChar(endChar);

          removeDuplicateLines(currentLine.getStartChar(), currentLine.getEndChar());

          lines.add(currentLine);

          pointStart = null;
        }
        checkWin();

        repaint();
      }

    });
    addMouseMotionListener(new MouseMotionAdapter()
    {
      @Override
      public void mouseDragged(MouseEvent e)
      {
        if(currentLine != null)
        {
          pointEnd = e.getPoint();
          currentLine.setPointEnd(pointEnd);
          repaint();
        }
      }
    });
  }

  private  void checkWin()
  {
    if(lines.size() == cs.getChars().size() - 1)
    {
      StringBuilder result = new StringBuilder();

      String resultString = "Wow you gut it!";
      int index = 0;
      for (Line line : lines)
      {
        if(index != line.getStartChar().getIndex())
        {
          resultString = "ops you lost!";
        }
        index++;
        result.append(line.getStartChar().getValue());

      }

      if(resultString.equals("Wow you gut it!"))
      {
        JOptionPane.showMessageDialog(this, "Your word is " + result, resultString, JOptionPane.INFORMATION_MESSAGE);
      }
      else
      {
        JOptionPane.showMessageDialog(this, "Don't worry you can try again", resultString, JOptionPane.ERROR_MESSAGE);
      }

      Collections.shuffle(words);

      this.cs = new Chars(words.get(0));

      this.lines = new ArrayList<>();

      currentLine = null;

    }
  }
  private void removeDuplicateLines(Character start, Character end)
  {
    lines.removeIf(line -> end == null && line.getStartChar().equals(start) ||
        line.getStartChar().equals(end) && line.getEndChar().equals(start) ||
        line.getEndChar().equals(end) ||
        !line.getStartChar().equals(start) && line.getEndChar() == null
    );
  }

  @Override
  public void paint(Graphics g)
  {
    super.paint(g);

    Graphics2D g2 = (Graphics2D) g;

    g2.setStroke(new BasicStroke(2));

    if (currentLine != null) currentLine.paint(g2);

    for (Line line : lines) line.paint(g2);

    for (Character c : cs.getChars()) {
      if(currentLine != null){
        if (c.equals(currentLine.getStartChar()))
          c.setColor(Color.BLUE);

        if (c.equals(currentLine.getEndChar()))
          c.setColor(Color.ORANGE);
      }

      g2.setFont(new Font("Arial Black", Font.BOLD, 30));
      g2.setColor(c.getColor());
      g2.drawOval(c.getPosition().x, c.getPosition().y, 80, 80);
      g2.drawString(c.getValue(), c.getPosition().x + 30, c.getPosition().y + 50);
    }
  }
}
