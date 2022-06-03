
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Abir Elşekaki
 */
public class Chars {
    
    private ArrayList<Character> chars;
    
    private final int[][][] positions = {
        {
            {210,90},
            {80,300},
            {350,300}
        },
        {
            {80,80},
            {350,80},
            {80,350},
            {350,350}
        },
        {
            {210,80},
            {350,180},
            {300,350},
            {140,350},
            {80,180}
        },
        {
            {210,80},
            {350,180},
            {350,320},
            {210,400},
            {80,320},
            {80,180}
        }
    };

    public Chars(String chars) {
       setChars(chars);
    }

    private void setChars(String chars)
    {
        ArrayList<Character> charsList = new ArrayList<>();
        
        int[][] coordinates = this.positions[chars.length() - 3];
        
        shuffleArray(coordinates);
        for (int i = 0; i < chars.length(); i++) {
            charsList.add(new Character(i ,new Point(coordinates[i][0], coordinates[i][1]), chars.charAt(i)));   
        }
        
        Collections.shuffle(charsList);
        
        this.chars = charsList;
       
    }

    public ArrayList<Character> getChars(){
        
        return chars;
    }
    
    static void shuffleArray(int[][] ar)
  {
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int[] a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }

  public Character getCharacterByPosition(Point point)
  {
      for (Character character : chars) {
          if (point.x >= character.getPosition().x && point.x <= character.getPosition().x + 80 && point.y >= character.getPosition().y && point.y <= character.getPosition().y + 80) {
              return character;
          }
      }

      return null;
  }
    
}
