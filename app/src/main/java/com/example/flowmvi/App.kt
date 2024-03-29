package com.example.flowmvi

import android.app.Application
import com.google.android.material.color.DynamicColors
import com.example.flowmvi.core.coreModule
import com.example.flowmvi.data.dataModule
import com.example.flowmvi.domain.domainModule
import com.example.flowmvi.ui.add.addModule
import com.example.flowmvi.ui.main.mainModule
import com.example.flowmvi.ui.search.searchModule
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@FlowPreview
@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
@ExperimentalTime
@JvmField
val allModules = listOf(
  coreModule,
  dataModule,
  domainModule,
  mainModule,
  addModule,
  searchModule,
)

@Suppress("unused")
@ExperimentalStdlibApi
@FlowPreview
@ExperimentalCoroutinesApi
@ExperimentalTime
class App : Application() {
  override fun onCreate() {
    super.onCreate()

    DynamicColors.applyToActivitiesIfAvailable(this)

    startKoin {
      androidContext(this@App)

      androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)

      modules(allModules)
    }
  }
}
