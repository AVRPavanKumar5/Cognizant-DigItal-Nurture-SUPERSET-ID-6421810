// Thread-safe Singleton implementation
class Singleton { 
    private static volatile Singleton instance;
    public static void main(String[] args) {
        System.out.println("=== PROGRAM FLOW DEMONSTRATION ===");
        System.out.println("Starting Singleton Pattern Demo...\n");
        
        demonstrateBasicSingleton();
        
        System.out.println("Now demonstrating Database Connection Singleton...\n");
        demonstrateDatabaseSingleton();
        System.out.println("Finally, testing thread safety of Singleton...\n");
        
        demonstrateThreadSafety();
        
        System.out.println("\n=== PROGRAM COMPLETED ===");
    }
    
    
    private static void demonstrateBasicSingleton() {
        System.out.println("--- STEP 1: Basic Singleton Pattern ---");
        System.out.println("1. Attempting to get first Singleton instance...");
        
        Singleton singleton1 = Singleton.getInstance();
        System.out.println("   ✓ First instance created: " + singleton1.hashCode());
        
        System.out.println("2. Attempting to get second Singleton instance...");
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("   ✓ Second instance obtained: " + singleton2.hashCode());
        
        System.out.println("3. Checking if both instances are the same...");
        boolean areSame = (singleton1 == singleton2);
        System.out.println("   ✓ Are instances the same? " + areSame);
        
        System.out.println("4. Testing singleton functionality...");
        singleton1.displayMessage();
        singleton2.displayMessage();
        
        System.out.println("   ✓ Step 1 completed successfully!\n");
    }
    
    
    private static void demonstrateDatabaseSingleton() {
        System.out.println("--- STEP 2: Database Connection Singleton ---");
        System.out.println("1. Creating first database connection...");
        
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        System.out.println("   ✓ First DB connection instance: " + db1.hashCode());
        System.out.println("   ✓ Connection string: " + db1.getConnectionString());
        
        System.out.println("2. Attempting to create second database connection...");
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("   ✓ Second DB connection instance: " + db2.hashCode());
        
        System.out.println("3. Verifying both connections are the same instance...");
        System.out.println("   ✓ Are DB connections the same? " + (db1 == db2));
        
        System.out.println("4. Testing database operations...");
        db1.executeQuery("SELECT * FROM users WHERE id = 1");
        db2.executeQuery("INSERT INTO products VALUES ('P001', 'Laptop', 999.99)");
        
        System.out.println("   ✓ Step 2 completed successfully!\n");
    }

    private static void demonstrateThreadSafety() {
        System.out.println("--- STEP 3: Thread Safety Test ---");
        System.out.println("Starting multiple threads to test singleton thread safety...");
        
        System.out.println("1. Testing with multiple concurrent threads...");
        
        Thread[] threads = new Thread[5];
        final Singleton[] instances = new Singleton[5];
        
        
        for (int i = 0; i < 5; i++) {
            final int threadNum = i;
            threads[i] = new Thread(() -> {
                System.out.println("   Thread " + threadNum + " requesting singleton instance...");
                instances[threadNum] = Singleton.getInstance();
                System.out.println("   Thread " + threadNum + " got instance: " + 
                                 instances[threadNum].hashCode());
            });
        }
    
        System.out.println("2. Starting all threads simultaneously...");
        for (Thread thread : threads) {
            thread.start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        
        // Verify all instances are the same
        System.out.println("3. Verifying thread safety results...");
        boolean allSame = true;
        for (int i = 1; i < instances.length; i++) {
            if (instances[0] != instances[i]) {
                allSame = false;
                break;
            }
        }
        
        System.out.println("   ✓ All thread instances are the same? " + allSame);
        System.out.println("   ✓ Thread safety test completed!\n");
    }
    
    private Singleton() {
        FlowTracker.logStep("Singleton constructor called");
        FlowTracker.logSubStep("Creating new Singleton instance");
        System.out.println("   → Singleton constructor called - Creating new instance");
    }
    
    public static Singleton getInstance() {
        System.out.println("   → getInstance() method called");
        if (instance == null) {
            System.out.println("   → Instance is null, entering synchronized block");
            synchronized (Singleton.class) {
                if (instance == null) {
                    System.out.println("   → Double-check: instance is still null, creating new instance");
                    instance = new Singleton();
                } else {
                    System.out.println("   → Double-check: instance already exists, returning existing");
                }
            }
        } else {
            System.out.println("   → Instance already exists, returning existing instance");
        }
        return instance;
    }
    
    public void displayMessage() {
        System.out.println("   → Singleton instance is working! Hash: " + this.hashCode());
    }
}

class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private String connectionString;
    private int queryCount = 0;
    
    private DatabaseConnection() {
    
        System.out.println("   → DatabaseConnection constructor called");
        connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("   → Database connection established: " + connectionString);
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static DatabaseConnection getInstance() {
        System.out.println("   → DatabaseConnection.getInstance() called");
        if (instance == null) {
            System.out.println("   → DB instance is null, acquiring lock...");
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    System.out.println("   → Creating new DatabaseConnection instance");
                    instance = new DatabaseConnection();
                } else {
                    System.out.println("   → DB instance created by another thread");
                }
            }
        } else {
            System.out.println("   → Returning existing DB instance");
        }
        return instance;
    }
    
    public void executeQuery(String query) {
        queryCount++;
        System.out.println("   → [Query #" + queryCount + "] Executing: " + query);
        System.out.println("   → Query executed successfully on connection: " + 
                         this.hashCode());
    }
    
    public String getConnectionString() {
        return connectionString;
    }
    
    public int getQueryCount() {
        return queryCount;
    }
}
class FlowTracker {
    private static int stepCounter = 0;
    
    public static void logStep(String description) {
        stepCounter++;
        System.out.println("[Step " + stepCounter + "] " + description);
    }
    
    public static void logSubStep(String description) {
        System.out.println("    └─ " + description);
    }
}