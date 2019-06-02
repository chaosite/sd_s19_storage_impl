package il.ac.technion.cs.softwaredesign.storage

import java.util.HashMap

class ByteArrayKey(private val bytes: ByteArray) {
    override fun equals(other: Any?): Boolean =
        this === other || other is ByteArrayKey && this.bytes contentEquals other.bytes

    override fun hashCode(): Int = bytes.contentHashCode()
    override fun toString(): String = bytes.contentToString()
}

class SecureStorageImpl : SecureStorage {
    private var storageMap = HashMap<ByteArrayKey, kotlin.ByteArray>()
    override fun read(key: ByteArray): ByteArray? {
        val value = storageMap.get(key = ByteArrayKey(key))
        if (value != null) {
            Thread.sleep(value.size.toLong())
        }
        return value
    }

    override fun write(key: ByteArray, value: ByteArray) {
        storageMap.put(ByteArrayKey(key), value)
    }
}

