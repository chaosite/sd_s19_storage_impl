package il.ac.technion.cs.softwaredesign.storage



class SecureStorageModule constructor() : com.authzee.kotlinguice4.KotlinModule() {
    protected override fun configure(): kotlin.Unit {
        bind<SecureStorageFactory>().toInstance(SecureStorageFactoryImpl())
    }
}

