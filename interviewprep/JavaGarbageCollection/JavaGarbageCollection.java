package JavaGarbageCollection;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class JavaGarbageCollection {
    public static void main(String[] args) {

        /**
         * different garbage collection algorithms in java
         *
         * 1. Serial GC -> uses single thread to perform all garbage collection work, suitable for single threaded app
         * 2. parallel -> use multiple thread for garbage collection, suitably for multithreaded app
         * 3. Concurrent Mark Sweep -> performs most of the garbage collection concurently with application thread
         *      to minimize the pause times.
         * 4. G1 (Garbage First) -> divides the heap into regions and prioritizes reclaiming regions with the most garbage
         *
         */


        /**
         * Soft, Weak and Phantom references in java
         *
         * 1. Soft -> objects stored in weak reference are cleared at the discretion of the garbage collector. when sys running on low memory
         *              objects held in soft reference may be reclaimed to free up space
         *
         * 2. Weak -> cleared as soon as they are no longer strongly reachable. these are used for memory sensitive caches, where entries can
         *              be easily removed to prevent excessive memory consumption
         *
         * 3. Phantom -> cleared after GC determines that they are no longer reachable. they are not immediately reclaimed when th become unreachable,
         *              instead they are enqueue for cleanup actions, allowing additional processing before their final removal.
         *
         */

        // Strong reference (default)
        // not collected
        Object strongRef = new Object();

        // WeakReference
        // collected by GC if there are no strong references to it (Caching)
        WeakReference<Object> weakRef = new WeakReference<>(new Object());

        // Soft References (used in image caching libraries)
        // collected by GC is memory pressure increases
        SoftReference<Object> softRef = new SoftReference<>(new Object());


        // Phantom reference (memory management framework)
        // the weakest type of reference and are mainly used to track when an object is being finalized by the garbage collector
        ReferenceQueue<Object> phantomQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), phantomQueue);

        // Lets simulate some memory pressure
        System.gc();

        // Print status of references
        System.out.println("Strong ref: "+strongRef);
        System.out.println("Weak ref: "+weakRef.get());
        System.out.println("Soft Ref: "+softRef.get());
        System.out.println("Phantom ref: "+phantomReference.get());


    }
}
