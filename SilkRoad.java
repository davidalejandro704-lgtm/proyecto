import java.util.*;

class SilkRoad {
    private List<Robot> robots;
    private List<Store> stores;

    public SilkRoad() {
        robots = new ArrayList<>();
        stores = new ArrayList<>();
    }

    public void addRobot(int pos) {
        robots.add(new Robot(pos));
    }

    public void addStore(int pos, int money) {
        stores.add(new Store(pos, money));
    }

    public void resupplyStores() {
        for (Store s : stores) {
            s.resupply();
        }
    }

    public void returnRobots() {
        for (Robot r : robots) {
            r.returnToStart();
        }
    }

    public long maxProfit() {
        if (robots.isEmpty() || stores.isEmpty()) return 0;

        List<Integer> r = new ArrayList<>();
        for (Robot rob : robots) {
            r.add(rob.getPos());
        }
        Collections.sort(r);

        List<Store> s = new ArrayList<>(stores);
        s.sort(Comparator.comparingInt(Store::getLocation));

        int k = s.size();
        int[] x = new int[k + 1];
        long[] val = new long[k + 1];
        long[] pref = new long[k + 1];

        for (int i = 1; i <= k; i++) {
            x[i] = s.get(i - 1).getLocation();
            val[i] = s.get(i - 1).getMoney();
            pref[i] = pref[i - 1] + val[i];
        }

        long[] prev = new long[k + 1];

        for (int robot : r) {
            long[] curr = new long[k + 1];
            for (int t = 1; t <= k; t++) {
                curr[t] = curr[t - 1];
                for (int a = 1; a <= t; a++) {
                    long sum = pref[t] - pref[a - 1];
                    long cost;
                    if (robot <= x[a]) {
                        cost = x[t] - robot;
                    } else if (robot >= x[t]) {
                        cost = robot - x[a];
                    } else {
                        cost = (x[t] - x[a]) + Math.min(robot - x[a], x[t] - robot);
                    }
                    long gain = sum - cost;
                    if (gain < 0) gain = 0;
                    curr[t] = Math.max(curr[t], prev[a - 1] + gain);
                }
            }
            prev = curr;
        }

        return prev[k];
    }
}
