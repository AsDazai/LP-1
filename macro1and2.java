import java.util.*;

class Macro {
    String name;
    List<String> definition;

    Macro(String name, List<String> definition) {
        this.name = name;
        this.definition = definition;
    }
}

public class MacroAssembler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Macro> macroTable = new HashMap<>();
        List<String> code = new ArrayList<>();

        // Pass 1: Read macro definitions
        System.out.println("Enter number of macros:");
        int macroCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < macroCount; i++) {
            System.out.println("Enter macro name:");
            String name = scanner.nextLine();
            List<String> definition = new ArrayList<>();
            System.out.println("Enter macro definition (end with END):");
            String line;
            while (!(line = scanner.nextLine()).equals("END")) {
                definition.add(line);
            }
            macroTable.put(name, new Macro(name, definition));
        }

        // Pass 2: Read code and expand macros
        System.out.println("\nEnter assembly code (end with END):");
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            code.add(line);
        }

        System.out.println("\nExpanded Code:");
        for (String instruction : code) {
            if (macroTable.containsKey(instruction)) {
                Macro macro = macroTable.get(instruction);
                for (String def : macro.definition) {
                    System.out.println(def);
                }
            } else {
                System.out.println(instruction);
            }
        }

        scanner.close();
    }
}
