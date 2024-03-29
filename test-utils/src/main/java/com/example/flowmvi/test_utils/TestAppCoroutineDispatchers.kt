package com.example.flowmvi.test_utils

import com.example.flowmvi.core.dispatchers.AppCoroutineDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher

@ExperimentalCoroutinesApi
class TestAppCoroutineDispatchers(private val testCoroutineDispatcher: TestDispatcher) :
  AppCoroutineDispatchers {
  override val main get() = testCoroutineDispatcher
  override val mainImmediate get() = testCoroutineDispatcher
  override val io get() = testCoroutineDispatcher
}
