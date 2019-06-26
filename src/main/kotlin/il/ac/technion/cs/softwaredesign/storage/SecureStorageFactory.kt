package il.ac.technion.cs.softwaredesign.storage
import java.util.concurrent.CompletableFuture
public interface SecureStorageFactory {
    public abstract fun open(name: kotlin.ByteArray): CompletableFuture<il.ac.technion.cs.softwaredesign.storage.SecureStorage>
}