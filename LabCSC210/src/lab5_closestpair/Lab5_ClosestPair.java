package lab5_closestpair;

import javax.swing.*;

public class Lab5_ClosestPair {
    public static void main(String[] args) {
        int n = 10;
        int[][] point = new int[n][2];

        point[0][0]= 50; point[0][1] = 100; //(50,100)
        point[1][0]= 150; point[1][1] = 200;
        point[2][0]= 250; point[2][1] = 200;
        point[3][0]= 75; point[3][1] = 350;
        point[4][0]= 500; point[4][1] = 370;
        point[5][0]= 450; point[5][1] = 200;
        point[6][0]= 155; point[6][1] = 120;
        point[7][0]= 235; point[7][1] = 254;
        point[8][0]= 55; point[8][1] = 212;
        point[9][0]= 95; point[9][1] = 554;

        int closest1 = 0, closest2 = 0;
        double distanceSquare = 0, shortestDistanceSquare = 1000000;

        for (int i = 0; i < point.length; i++) {
            for (int j = i+1; j < point.length; j++) {
                // c^2 = a^2 + b^2
                // c^2 = (x1 - x2)^2  + (y1 - y2)^2

                distanceSquare = Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1], 2);
                if (distanceSquare < shortestDistanceSquare) {
                    shortestDistanceSquare = distanceSquare;
                    closest1 = i;
                    closest2 = j;
                }
            }
        }

        System.out.println("The closest pair is (" + point[closest1][0] + "," + point[closest1][1]+ ") and ("
                            + point[closest2][0] + "," + point[closest2][1]+ ")");

        JFrame frame = new JFrame("Closest Pair");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pointPanel panel = new pointPanel(point, point[closest1], point[closest2]);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // Convex Hull
        int a, b, c, cOfPointK;
        int[][] convex = new int[n][4];
        int boundaryCount = 0;

        for (int i = 0; i < point.length; i++) {
            for (int j = i+1; j < point.length; j++) {
                a = point[j][1] - point[i][1];  // y2 - y1
                b = point[i][0] - point[j][0];  // x1 - x2
                c = (point[i][0] * point[j][1]) - (point[j][0] * point[i][1]);  // c = x1y2 - x2y1

                int countMore = 0, countLess = 0, k = 0;
                for (; k < point.length; k++) {
                    // c = axk + byk;
                    cOfPointK = (a * point[k][0]) + (b * point[k][1]);

                    if (cOfPointK >= c) countMore++;
                    if (cOfPointK <= c) countLess++;

                    if (countMore != k+1 && countLess != k+1) {
                        break;  // point K tell us that line ij is not a boundary.
                    }
                }

                if (k == point.length) {
                    System.out.println("Line from point " + i + " to point " + j + " is a boundary of convex hull");
                    convex[boundaryCount][0] = point[i][0];
                    convex[boundaryCount][1] = point[i][1];
                    convex[boundaryCount][2] = point[j][0];
                    convex[boundaryCount][3] = point[j][1];
                    boundaryCount++;
                }
            }
        }

        panel.getConvex(convex);
        frame.pack();
        frame.setVisible(true);
    }
}
