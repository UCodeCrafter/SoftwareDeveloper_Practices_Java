package system_design.creational.singelton;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

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

//----------------------------X---------------------------X----------------------------------------
/** * Singleton with: *  - Initialization-on-demand holder idiom (lazy + thread-safe) *  - A guard against reflective creation (best-effort) *  - Serialization-safe via readResolve() * * Note: no approach is 100% bullet-proof vs. a determined attacker * with full reflective access (they can tamper private fields). For * the strongest guarantees prefer an enum-based singleton. */
final class SafeSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    // Guard to detect prior initialization
    // AtomicBoolean used to avoid ordering races in multi-threaded construction.
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    // Private constructor: throw if already initialized
    private SafeSingleton() {
        // If already initialized we refuse to create another instance.
        // This will catch normal reflection attempts that call the constructor
        // after the instance has already been created.
        if (initialized.getAndSet(true)) {
            throw new IllegalStateException("SafeSingleton: already initialized");
        }

        // perform initialization here...
    }

    // Holder idiom: lazy, thread-safe, and fast
    private static class Holder {
        private static final SafeSingleton INSTANCE = new SafeSingleton();
    }

    public static SafeSingleton getInstance() {
        return Holder.INSTANCE;
    }

    // Serialization safety: when deserializing, ensure we return the existing instance
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    // Optional: helpful to observe instance identity
    @Override
    public String toString() {
        return "SafeSingleton@" + Integer.toHexString(System.identityHashCode(this));
    }
}