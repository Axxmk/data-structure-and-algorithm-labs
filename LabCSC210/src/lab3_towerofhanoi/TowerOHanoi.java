package lab3_towerofhanoi;
import java.util.Stack;

public class TowerOHanoi {
    Stack<Integer> pegA;
    Stack<Integer> pegB;
    Stack<Integer> pegC;
    int amountOfDisks;
    int ithMove;

    public TowerOHanoi (int amountOfDisks) {
        this.amountOfDisks = amountOfDisks;
        this.ithMove = 0;
        pegA = new Stack<Integer>();
        pegB = new Stack<Integer>();
        pegC = new Stack<Integer>();

        for (int i = this.amountOfDisks; i > 0; i--) {
            pegA.push(i);
        }
    }

    public void play() {
        move(this.pegA.size(), this.pegA, this.pegC, this.pegB);
    }

    public void move(int n, Stack fromPeg, Stack toPeg, Stack availablePeg) {
        if (n == 1) {
            toPeg.push(fromPeg.pop());
//            System.out.println(pegA.toString() + " " + pegB.toString() + " " + pegC.toString());
            this.ithMove++;
            showTowerOfHanoi();
            return;
        }
        move(n-1, fromPeg, availablePeg, toPeg);
        move(1, fromPeg, toPeg, availablePeg);
         move(n-1, availablePeg, toPeg, fromPeg);
    }

    public void showTowerOfHanoi() {
        int max = 0;
        if (pegA.size() >= pegB.size() && pegA.size() >= pegC.size()) {
            max = pegA.size()-1;
        }
        else if (pegB.size() >= pegA.size() && pegB.size() >= pegC.size()) {
            max = pegB.size()-1;
        }
        else {
            max = pegC.size()-1;
        }

        for (int i = max; i >= 0; i--) {
            // PegA
            if (pegA.size() - 1 >= i) {
                System.out.print(pegA.elementAt(i) + "   ");
            }
            else {
                System.out.print("    ");
            }

            // PegB
            if (pegB.size() - 1 >= i) {
                System.out.print(pegB.elementAt(i) + "   ");
            }
            else {
                System.out.print("    ");
            }

            // PegB
            if (pegC.size() - 1 >= i) {
                System.out.print(pegC.elementAt(i) + "   ");
            }
            else {
                System.out.print("    ");
            }
            System.out.println();
        }
        System.out.println("Move " + this.ithMove + " ----------");
    }
}
