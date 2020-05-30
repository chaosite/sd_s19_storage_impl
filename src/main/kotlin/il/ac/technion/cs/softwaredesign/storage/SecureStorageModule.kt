package il.ac.technion.cs.softwaredesign.storage

import dev.misfitlabs.kotlinguice4.KotlinModule

class SecureStorageModule : KotlinModule() {
    protected override fun configure(): kotlin.Unit {
        bind<SecureStorageFactory>().toInstance(SecureStorageFactoryImpl())
    }
}

