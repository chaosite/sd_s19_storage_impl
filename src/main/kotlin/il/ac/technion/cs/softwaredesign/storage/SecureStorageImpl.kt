package il.ac.technion.cs.softwaredesign.storage

import java.util.HashMap

class ByteArrayKey(private val bytes: ByteArray) {
    override fun equals(other: Any?): Boolean =
            this === other || other is ByteArrayKey && this.bytes contentEquals other.bytes

    override fun hashCode(): Int = bytes.contentHashCode()
    override fun toString(): String = bytes.contentToString()
}

object SecureStorageImpl {

    private var storageMap = HashMap<ByteArrayKey, kotlin.ByteArray>()
    fun read(key: kotlin.ByteArray): kotlin.ByteArray? {
        val value = storageMap.get(key = ByteArrayKey(key))
        /*if (value != null) {
            Thread.sleep(value.size.toLong())
        }*/
        return value
    }

    fun write(key: kotlin.ByteArray, value: kotlin.ByteArray): kotlin.Unit {
        storageMap.put(ByteArrayKey(key), value)
    }

    fun clear()
    {
        storageMap.clear()
    }

    fun getDbCopy() : HashMap<ByteArrayKey, kotlin.ByteArray>
    {
        return HashMap(storageMap)
    }
    fun setDb(other : HashMap<ByteArrayKey, kotlin.ByteArray>)
    {
        clear()
        val listOfPairs = other.toList()
        for (pair in listOfPairs)
        {
            storageMap.put(pair.first, pair.second)
        }
    }
}

public fun read(key: kotlin.ByteArray): kotlin.ByteArray? {
    return SecureStorageImpl.read(key)
}

public fun write(key: kotlin.ByteArray, value: kotlin.ByteArray): kotlin.Unit {
    SecureStorageImpl.write(key, value)
}

