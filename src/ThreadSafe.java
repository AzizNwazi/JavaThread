import java.util.logging.Level;
import java.util.logging.Logger;

// Class definition for ThreadSafe
public class ThreadSafe {
    private int count = 0; // Shared variable to be incremented
    // Method to increase the count in a thread-safe manner using synchronized keyword
    public synchronized void increase(){
        count++;
    }
    // Method to run two threads concurrently and increase the count
    public void runThreaders(){
        // Creating and starting thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Loop to increment count 5000 times
                for(int i = 0 ;  i < 5000 ; i++) {
                    increase();
                }
            }
        });
        // Creating and starting thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Loop to increment count 5000 times
                for(int i = 0 ;  i < 5000 ; i++) {
                    increase();
                }
            }
        });

        thread1.start(); // Starting thread1
        thread2.start(); // Starting thread2

        try {
            // Waiting for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            // Handling interrupted exception
            Logger.getLogger(ThreadSafe.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Printing the final value of count
        System.out.println("Count Value : " + count);
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Creating an instance of ThreadSafe
        ThreadSafe threadsafe = new ThreadSafe();
        // Calling the method to run the threads
        threadsafe.runThreaders();
    }
}
