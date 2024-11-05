import java.util.*;

class Process {
    int id, remaining;
    Process(int id, int burst) { this.id = id; this.remaining = burst; }
}

public class SJFPreemptive {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), time = 0;
        Process[] p = new Process[n];
        for (int i = 0; i < n; i++) p[i] = new Process(i + 1, s.nextInt());
        
        while (true) {
            Arrays.sort(p, Comparator.comparingInt(a -> a.remaining));
            boolean done = true;
            for (Process pr : p) {
                if (pr.remaining > 0) {
                    System.out.println("Time " + time + ": Process " + pr.id + " is executing");
                    pr.remaining--; done = false; break;
                }
            }
            if (done) break; time++;
        }
        s.close();
    }
}
INPUT:- any 5 random numbers (1-9)
