import java.util.ArrayList;
import java.util.List;

/**
 * Lab: JVM Memory Analysis
 * 
 * TODO: Complete this application to demonstrate memory behavior
 * 
 * Run with: java -Xms128m -Xmx256m -Xlog:gc*:file=gc.log MemoryLabApp
 */
public class MemoryLabApp {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== JVM Memory Lab ===");
        printMemoryStatus("Initial");

        List<byte[]> memoryBlocks = new ArrayList<>();

        // TODO: Implement the following
        // 1. Allocate memory in a loop (e.g., 1MB chunks)
        // 2. Print memory status after each allocation
        // 3. Handle OutOfMemoryError gracefully
        // 4. Add a small delay between allocations for observation

        // Your code here:
        try {
            int iteration = 0;
            while (true) {
                // Allocate 1MB chunks of memory
                byte[] block = new byte[1024 * 1024]; // 1 MB
                memoryBlocks.add(block);
                iteration++;
                
                // Print memory status after each allocation
                if (iteration % 10 == 0) {
                    printMemoryStatus("After " + iteration + " MB allocated");
                }
                
                // Add a small delay for observation
                Thread.sleep(50);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("\n!!! OutOfMemoryError caught !!!");
            System.out.println("Total memory blocks allocated: " + memoryBlocks.size());
            printMemoryStatus("After OOM");
        }

        printMemoryStatus("Final");
    }

    /**
     * Helper method to print current memory status
     */
    private static void printMemoryStatus(String label) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory() / (1024 * 1024);
        long totalMemory = runtime.totalMemory() / (1024 * 1024);
        long freeMemory = runtime.freeMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;

        System.out.printf("[%s] Max: %d MB, Total: %d MB, Used: %d MB, Free: %d MB%n",
                label, maxMemory, totalMemory, usedMemory, freeMemory);
    }
}
