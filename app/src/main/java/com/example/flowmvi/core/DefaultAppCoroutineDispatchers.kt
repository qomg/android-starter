package com.example.flowmvi.core

import com.example.flowmvi.core.dispatchers.AppCoroutineDispatchers
import kotlinx.coroutines.Dispatchers

internal class DefaultAppCoroutineDispatchers : AppCoroutineDispatchers {
  override val main get() = Dispatchers.Main
  override val mainImmediate get() = Dispatchers.Main.immediate
  override val io get() = Dispatchers.IO
}
