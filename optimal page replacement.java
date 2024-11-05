import java.util.*;

public class OptimalPageReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of frames:");
        int frames = scanner.nextInt();
        System.out.println("Enter the number of pages:");
        int pagesCount = scanner.nextInt();
        int[] pages = new int[pagesCount];

        System.out.println("Enter the page reference string:");
        for (int i = 0; i < pagesCount; i++) {
            pages[i] = scanner.nextInt();
        }

        int pageFaults = optimalPageReplacement(pages, frames);
        System.out.println("Total Page Faults: " + pageFaults);
        scanner.close();
    }

    public static int optimalPageReplacement(int[] pages, int frames) {
        Set<Integer> memory = new HashSet<>();
        int pageFaults = 0;

        for (int i = 0; i < pages.length; i++) {
            if (!memory.contains(pages[i])) {
                if (memory.size() < frames) {
                    memory.add(pages[i]);
                } else {
                    int farthest = i + 1;
                    int pageToRemove = -1;
                    for (Integer page : memory) {
                        int j;
                        for (j = i + 1; j < pages.length; j++) {
                            if (pages[j] == page) {
                                break;
                            }
                        }
                        if (j > farthest) {
                            farthest = j;
                            pageToRemove = page;
                        }
                    }
                    memory.remove(pageToRemove);
                    memory.add(pages[i]);
                }
                pageFaults++;
            }
        }
        return pageFaults;
    }
}
