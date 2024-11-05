import java.util.Scanner;

class Process {
    int id, arrival, burst, waiting, turnaround;
    Process(int id, int arrival, int burst) { this.id = id; this.arrival = arrival; this.burst = burst; }
}

public class FCFS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Process[] p = new Process[s.nextInt()];
        for (int i = 0; i < p.length; i++) p[i] = new Process(i + 1, s.nextInt(), s.nextInt());
        java.util.Arrays.sort(p, (a, b) -> a.arrival - b.arrival);
        int t = 0;
        for (Process pr : p) { t = Math.max(t, pr.arrival); pr.waiting = t - pr.arrival; t += pr.burst; pr.turnaround = pr.waiting + pr.burst; }
        System.out.println("PID\tWT\tTAT");
        for (Process pr : p) System.out.println(pr.id + "\t" + pr.waiting + "\t" + pr.turnaround);
        s.close();
    }
}

//input:- 
// 3
//0 5
//1 4
//2 6
