import java.util.*;

class Process {
    int id, remaining;
    Process(int id, int burst) { this.id = id; this.remaining = burst; }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), tq = s.nextInt();
        Process[] p = new Process[n];
        for (int i = 0; i < n; i++) p[i] = new Process(i + 1, s.nextInt());

        for (int time = 0; ; time++) {
            boolean done = true;
            for (Process pr : p) {
                if (pr.remaining > 0) {
                    done = false;
                    System.out.println("Time " + time + ": Process " + pr.id + " executing");
                    pr.remaining -= Math.min(pr.remaining, tq);
                }
            }
            if (done) break;
        }
        s.close();
    }
}

input:-  any 6 random number (0-10)
