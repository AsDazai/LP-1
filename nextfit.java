import java.util.Scanner;

public class NextFit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] blocks = new int[s.nextInt()], processes = new int[s.nextInt()];
        for (int i = 0; i < blocks.length; i++) blocks[i] = s.nextInt();
        int lastPos = 0;
        for (int p : processes) {
            boolean allocated = false;
            for (int i = 0; i < blocks.length; i++) {
                int idx = (lastPos + i) % blocks.length;
                if (blocks[idx] >= p) {
                    blocks[idx] -= p;
                    lastPos = idx;
                    allocated = true;
                    System.out.println("Process " + p + " allocated");
                    break;
                }
            }
            if (!allocated) System.out.println("Process " + p + " not allocated");
        }
        s.close();
    }
}
