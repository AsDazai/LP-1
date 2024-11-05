import java.util.*;

public class FIFO {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int frames = s.nextInt(), pagesCount = s.nextInt(), pageFaults = 0;
        int[] pages = new int[pagesCount];
        for (int i = 0; i < pagesCount; i++) pages[i] = s.nextInt();
        Queue<Integer> memory = new LinkedList<>();

        for (int page : pages) {
            if (!memory.contains(page)) {
                if (memory.size() == frames) memory.poll();
                memory.add(page); pageFaults++;
            }
        }
        System.out.println("Page Faults: " + pageFaults);
        s.close();
    }
}

Input :- 
3
9
7 0 1 2 0 3 0 4 2
