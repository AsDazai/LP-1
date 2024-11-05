import java.util.*;

class Assembler {
    static class Symbol {
        String label;
        int address;
        
        Symbol(String label, int address) {
            this.label = label;
            this.address = address;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Symbol> symbolTable = new ArrayList<>();
        List<String> instructions = new ArrayList<>();
        int address = 0;

        // Pass 1: Read source code and create symbol table
        System.out.println("Enter the number of instructions:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter instruction (label opcode):");
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            if (parts[0].endsWith(":")) { // Check for label
                String label = parts[0].substring(0, parts[0].length() - 1);
                symbolTable.add(new Symbol(label, address));
                parts = Arrays.copyOfRange(parts, 1, parts.length); // Remove label
            }
            instructions.add(String.join(" ", parts));
            address++; // Increment address for next instruction
        }

        // Pass 2: Generate machine code
        System.out.println("\nSymbol Table:");
        for (Symbol symbol : symbolTable) {
            System.out.println(symbol.label + " -> " + symbol.address);
        }

        System.out.println("\nGenerated Machine Code:");
        for (String instruction : instructions) {
            for (Symbol symbol : symbolTable) {
                instruction = instruction.replace(symbol.label, Integer.toString(symbol.address));
            }
            System.out.println(instruction);
        }

        scanner.close();
    }
}
