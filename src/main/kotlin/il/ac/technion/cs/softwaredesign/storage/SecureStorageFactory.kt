package il.ac.technion.cs.softwaredesign.storage

public interface SecureStorageFactory {
    public abstract fun open(name: kotlin.ByteArray): il.ac.technion.cs.softwaredesign.storage.SecureStorage
}