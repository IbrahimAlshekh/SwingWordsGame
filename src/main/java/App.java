import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Abir Elşekaki
 */
public class App {

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        words.add("abir");
        words.add("Gün");
        words.add("selam");
        words.add("Java");
        words.add("Swing");
        words.add("güzel");
        words.add("söyle");
        words.add("dünya");
        words.add("oyun");

        GamePanel gamePanel = new GamePanel(words);

        JFrame frame = new JFrame("Game");
        frame.setSize(510, 510);
        frame.setResizable(false);
        frame.add(gamePanel);
        frame.setVisible(true);

    }
}
