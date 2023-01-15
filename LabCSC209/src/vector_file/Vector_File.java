package vector_file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vector_File {
    public static void main(String[] args) {
        Magic m1 = new Magic("Fireball", 8, "burning", "fire");
        Magic m2 = new Magic("Summon", 6, "Invite god", "earth");
        Magic m3 = new Magic("Time travel", 5, "Go back in time", "wind");

        Vector player1 = new Vector();
        player1.add(m1);
        player1.add(m2);
        player1.add(m3);

        System.out.println(m2.getSpell() + " " + m2.getPower());

        System.out.println( ((Magic) player1.elementAt(2)).getSpell());
        for (int i = 0; i < player1.size(); i++) {
            System.out.print(" " + ((Magic) player1.elementAt(i)).getSpell());
        }

        player1.removeElementAt(1);
        System.out.println("\n After magic was removed.");
        for (int i = 0; i < player1.size(); i++) {
            System.out.print(" " + ((Magic) player1.get(i)).getSpell());
        }

        System.out.println(" " + player1.size() + " " + player1.capacity());
        player1.add(new Magic("healing", 2, "safe life", "water"));
        player1.add(new Magic("fly", 4, "Fly in the air", "wind"));
        System.out.println(" " + player1.size() + " " + player1.capacity());
        player1.add(new Magic("Teleport", 5, "MOve anywhere", "earth"));
        player1.add(new Magic("Turtle Wave", 5, "Destroy", "wind"));
        player1.add(m3);
        player1.add(m3);
        player1.add(m3);
        player1.add(m3);
        System.out.println(" " + player1.size() + " " + player1.capacity());
        player1.add(m3);
        System.out.println(" " + player1.size() + " " + player1.capacity());

        final int SPELL_SIZE = 15, ABILITY_SIZE = 20, ELEMENT_SIZE = 5;
        final int MAGIC_SIZE = 15 + 4 + 20 + 5;

        try {
            RandomAccessFile filePointer = new RandomAccessFile("player1.dat", "rw");
            byte[] spell = new byte[SPELL_SIZE];
            byte[] ability = new byte[ABILITY_SIZE];
            byte[] element = new byte[ELEMENT_SIZE];

            spell = (((Magic) player1.elementAt(0)).getSpell() + "               ").getBytes();
            filePointer.write(spell, 0, SPELL_SIZE);

            filePointer.writeInt( ((Magic) player1.elementAt(0)).getPower());

            ability = (((Magic) player1.elementAt(0)).getAbility() + "                      ").getBytes();
            filePointer.write(ability, 0, ABILITY_SIZE);

            element = (((Magic) player1.elementAt(0)).getElement() + "         ").getBytes();
            filePointer.write(element, 0, ELEMENT_SIZE);

            for (int i = 1; i < player1.size(); i++) {
                spell = (((Magic) player1.elementAt(i)).getSpell() + "               ").getBytes();
                filePointer.write(spell, 0, SPELL_SIZE);

                filePointer.writeInt( ((Magic) player1.elementAt(i)).getPower());

                ability = (((Magic) player1.elementAt(i)).getAbility() + "                      ").getBytes();
                filePointer.write(ability, 0, ABILITY_SIZE);

                element = (((Magic) player1.elementAt(i)).getElement() + "         ").getBytes();
                filePointer.write(element, 0, ELEMENT_SIZE);
            }

            // magic 0 is the beginning of the file which is byte number 0.
            // get spell of the magic
            //one magic in 44 bytes => magic I will start at byte number 44.
            // Actually byte number 44                  is the spell of the magic 1.
            //          byte number 44 + 15 = 59        is the power of th magic 1.
            //          byte number 44 + 15 + 4 = 63    is the ability of th magic 1.

            System.out.println("Current byte of my file pointer is -> " + filePointer.getFilePointer());

            filePointer.seek(63);
            byte[] x = new byte[ABILITY_SIZE];
            filePointer.read(x, 0, ABILITY_SIZE);
            System.out.println(" -> " + new String(x));

            System.out.println("Current byte of my file pointer is -> " + filePointer.getFilePointer());

            //read power of the magic 5. => 44*5 + 15 = 235
            filePointer.seek(44*5 + 15);
            System.out.println("power of the magic 5 is " + filePointer.readInt());
 ;       }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Vector_File.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Vector_File.class.getName()).log(Level.SEVERE, null, ex);
        }

        // | m1 | m2 | m3 | m4 | m5 |  |  |  |  |
    }
}
