package il.ac.technion.cs.softwaredesign.storage
import java.util.concurrent.CompletableFuture

public interface SecureStorage {
    public abstract fun read(key: kotlin.ByteArray): CompletableFuture<kotlin.ByteArray?>

    public abstract fun write(key: kotlin.ByteArray, value: kotlin.ByteArray): CompletableFuture<kotlin.Unit>
}