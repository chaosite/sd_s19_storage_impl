package il.ac.technion.cs.softwaredesign.storage


fun main()
{
    write(byteArrayOf(45,43,22), byteArrayOf(4,4,4))
    write(byteArrayOf(45,48,22), byteArrayOf(4,2,4))
    var tmp = SecureStorageImpl.getDbCopy()
    println("db copy after getting it:"+tmp)
    SecureStorageImpl.clear()
    var tmp2 = SecureStorageImpl.getDbCopy()
    println("db copy after deleting it:"+tmp2)
    SecureStorageImpl.setDb(tmp)
    val readv = read(byteArrayOf(45,43,22))
    println("Read value:"+readv)
    tmp2 = SecureStorageImpl.getDbCopy()
    println("db copy after setting it to tmp:"+tmp2)
}
