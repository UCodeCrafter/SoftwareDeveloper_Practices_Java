package system_design.creational.singelton;

/**
 * While double-checked locking is standard interview knowledge, modern Java applications often prefer the Initialization-on-demand holder idiom.
 * It provides lazy loading and thread safety entirely managed by the JVM classloader, without needing explicit synchronized or volatile keywords:
 */
public class ModernSingleton {
    private ModernSingleton() {}

    private static class Holder {
        // The JVM guarantees this line is executed thread-safely 
        // ONLY when Holder is first accessed inside getInstance()
        private static final ModernSingleton INSTANCE = new ModernSingleton();
    }

    public static ModernSingleton getInstance() {
        return Holder.INSTANCE;
    }
}