import java.util.*;

class Process {
    int id, burst, priority;
    Process(int id, int burst, int priority) {
        this.id = id; this.burst = burst; this.priority = priority;
    }
}

public class PriorityScheduling {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Process[] p = new Process[s.nextInt()];
        for (int i = 0; i < p.length; i++) 
            p[i] = new Process(i + 1, s.nextInt(), s.nextInt());

        Arrays.sort(p, Comparator.comparingInt((Process pr) -> pr.priority).reversed());
        for (int time = 0; time < p.length; time++) 
            System.out.println("Time " + (time > 0 ? p[time - 1].burst + time - 1 : 0) + ": Process " + p[time].id + " executing");
        s.close();
    }
}
INPUT:-	3
	10 2
	5 7
	3 4
