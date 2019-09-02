package il.ac.technion.cs.softwaredesign.storage

import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap


class SecureStorageFactoryImpl constructor() : SecureStorageFactory {
    private val storagesMap = ConcurrentHashMap<ByteArrayKey, SecureStorage>()
    private val MILISECONDS_DELAY_PER_DB = 100

    override fun open(name: ByteArray): CompletableFuture<SecureStorage> {
        return CompletableFuture.supplyAsync {
            val key = ByteArrayKey(name)
            synchronized(this) {
                if (!storagesMap.containsKey(key)) {
                    storagesMap[key] = SecureStorageImpl()
                }
            }
            Thread.sleep(MILISECONDS_DELAY_PER_DB * storagesMap.size.toLong())
            storagesMap[key]!!
        }
    }
}