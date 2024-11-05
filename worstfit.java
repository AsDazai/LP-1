import java.util.Scanner;

public class WorstFit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] blocks = new int[s.nextInt()], processes = new int[s.nextInt()];
        for (int i = 0; i < blocks.length; i++) blocks[i] = s.nextInt();
        for (int p : processes) {
            int worstIdx = -1;
            for (int j = 0; j < blocks.length; j++)
                if (blocks[j] >= p && (worstIdx == -1 || blocks[j] > blocks[worstIdx])) worstIdx = j;
            if (worstIdx != -1) blocks[worstIdx] -= p;
            System.out.println("Process " + p + (worstIdx != -1 ? " allocated" : " not allocated"));
        }
    }
}
