package lab3_towerofhanoi;

public class Lab3_TowerOfHanoi {
    public static void main(String[] args) {
        TowerOHanoi th = new TowerOHanoi(6);

//        while (!th.pegA.isEmpty()) {
//            System.out.println(th.pegA.pop());
//        }

        th.play();
    }
}
