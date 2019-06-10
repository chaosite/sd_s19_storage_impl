package il.ac.technion.cs.softwaredesign.storage

import com.authzee.kotlinguice4.KotlinModule

class SecureStorageModule : KotlinModule() {
    protected override fun configure(): kotlin.Unit {
        bind<SecureStorageFactory>().toInstance(SecureStorageFactoryImpl())
    }
}

