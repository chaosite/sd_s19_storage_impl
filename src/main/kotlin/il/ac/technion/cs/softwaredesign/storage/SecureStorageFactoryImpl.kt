package il.ac.technion.cs.softwaredesign.storage


import java.util.HashMap



class SecureStorageFactoryImpl constructor() : SecureStorageFactory {
    private val storagesMap = HashMap<ByteArrayKey, SecureStorage>()
    private val MILISECONDS_DELAY_PER_DB = 100
    override fun open(name: ByteArray): SecureStorage {
        val key = ByteArrayKey(name)

        if(!storagesMap.containsKey(key))
        {
            storagesMap.put(key, SecureStorageImpl())
        }
        Thread.sleep(MILISECONDS_DELAY_PER_DB * storagesMap.size.toLong())
        return storagesMap[key] as SecureStorage
    }
}