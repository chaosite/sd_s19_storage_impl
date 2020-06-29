package il.ac.technion.cs.softwaredesign.storage

import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap

private const val MILLISECONDS_DELAY_PER_DB = 100

class SecureStorageFactoryImpl : SecureStorageFactory {
    private val storagesMap = ConcurrentHashMap<ByteArrayKey, SecureStorage>()

    override fun open(name: ByteArray): CompletableFuture<SecureStorage> = CompletableFuture.supplyAsync {
        val key = ByteArrayKey(name)
        storagesMap.getOrPut(key, ::SecureStorageImpl)
        Thread.sleep(MILLISECONDS_DELAY_PER_DB * storagesMap.size.toLong())
        storagesMap[key]!!
    }
}