package com.example.flowmvi.core

import android.content.Context
import com.example.flowmvi.core_ui.navigator.IntentProviders
import com.example.flowmvi.core_ui.navigator.Navigator

class NavigatorImpl(
  private val add: IntentProviders.Add,
  private val search: IntentProviders.Search,
) : Navigator {
  override fun Context.navigateToAdd() =
    startActivity(add.makeIntent(this))

  override fun Context.navigateToSearch() {
    startActivity(search.makeIntent(this))
  }
}
