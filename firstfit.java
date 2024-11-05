import java.util.Scanner;

public class FirstFit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] blocks = new int[s.nextInt()], processes = new int[s.nextInt()];
        for (int i = 0; i < blocks.length; i++) blocks[i] = s.nextInt();
        for (int p : processes) {
            int allocated = 0;
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[j] >= p) {
                    blocks[j] -= p;
                    allocated = 1;
                    System.out.println("Process " + p + " allocated");
                    break;
                }
            }
            if (allocated == 0) System.out.println("Process " + p + " not allocated");
        }
        s.close();
    }
}
