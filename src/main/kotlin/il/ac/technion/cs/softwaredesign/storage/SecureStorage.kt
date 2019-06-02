package il.ac.technion.cs.softwaredesign.storage

public interface SecureStorage {
    public abstract fun read(key: kotlin.ByteArray): kotlin.ByteArray?

    public abstract fun write(key: kotlin.ByteArray, value: kotlin.ByteArray): kotlin.Unit
}