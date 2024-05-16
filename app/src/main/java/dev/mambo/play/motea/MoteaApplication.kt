package dev.mambo.play.motea

import android.app.Application
import dev.mambo.play.motea.data.dataModule
import dev.mambo.play.motea.sources.remote.remoteModule
import dev.mambo.play.motea.ui.uiModule
import org.koin.core.context.startKoin
import timber.log.Timber

class MoteaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeTimber()
        initializeKoin()
    }

    private fun initializeTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initializeKoin() {
        startKoin {
            modules(remoteModule, dataModule, uiModule)
        }
    }

}
