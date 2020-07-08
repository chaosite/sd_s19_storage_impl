package il.ac.technion.cs.softwaredesign.storage


import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap

internal class ByteArrayKey(private val bytes: ByteArray) {
    override fun equals(other: Any?): Boolean =
        this === other || other is ByteArrayKey && this.bytes contentEquals other.bytes

    override fun hashCode(): Int = bytes.contentHashCode()
    override fun toString(): String = bytes.contentToString()
}

internal class SecureStorageImpl : SecureStorage {
    private var storageMap = ConcurrentHashMap<ByteArrayKey, ByteArray>()
    override fun read(key: ByteArray): CompletableFuture<ByteArray?> = CompletableFuture.supplyAsync {
        val value = storageMap.get(key = ByteArrayKey(key))
        if (value != null) {
            Thread.sleep(value.size.toLong())
        }
        value
    }

    override fun write(key: ByteArray, value: ByteArray): CompletableFuture<Unit> = CompletableFuture.supplyAsync {
        storageMap[ByteArrayKey(key)] = value
    }
}