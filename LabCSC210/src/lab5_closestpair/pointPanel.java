package lab5_closestpair;

import java.awt.*;

public class pointPanel extends javax.swing.JPanel {
    int n = 10;
    int[][] point = new int[n][2];
    int[] closestPoint1 = new int[2];
    int[] closestPoint2 = new int[2];
    int[][] convexHull = new int[n][4];

    public pointPanel(int[][] point,
                      int[] closestPoint1,
                      int[] closestPoint2) {
        this.point = point;
        this.closestPoint1 = closestPoint1;
        this.closestPoint2 = closestPoint2;
        initComponents();
    }

    public void paintComponent(Graphics page){
        for (int i = 0; i < point.length; i++) {
            page.drawOval(point[i][0]-5, point[i][1]-5,10, 10);
        }
        page.setColor(Color.magenta);
        page.drawLine(closestPoint1[0], closestPoint1[1], closestPoint2[0], closestPoint2[1]);

        page.setColor(Color.blue);
        for (int i = 0; i < convexHull.length; i++) {
            page.drawLine(convexHull[i][0], convexHull[i][1], convexHull[i][2], convexHull[i][3]);
        }
    }

    public void getConvex(int[][] c) {
       convexHull = c;
    }

    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGap(0, 300, Short.MAX_VALUE)
        );
    }
}
