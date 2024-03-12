@file:Suppress("unused")

package com.example.flowmvi.initializer

import android.content.Context
import androidx.startup.Initializer
import com.example.flowmvi.ui.add.databinding.ActivityAddBinding
import com.example.flowmvi.ui.main.databinding.ActivityMainBinding
import com.hoc081098.viewbindingdelegate.preloadBindMethods
import timber.log.Timber

class ViewBindingInitializer : Initializer<Unit> {
  override fun create(context: Context) {
    preloadBindMethods(
      ActivityMainBinding::class,
      ActivityAddBinding::class,
    )
    Timber.d("ViewBindingInitializer...")
  }

  override fun dependencies(): List<Class<out Initializer<*>>> =
    listOf(TimberInitializer::class.java)
}
