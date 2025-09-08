import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SilkRoad road = new SilkRoad();

        int n = sc.nextInt();  // número de días

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();   // 1 = robot, 2 = tienda
            int x = sc.nextInt();

            if (t == 1) {
                road.addRobot(x);
            } else if (t == 2) {
                int c = sc.nextInt();
                road.addStore(x, c);
            }

            System.out.println(road.maxProfit());
        }

        sc.close();
    }
}
