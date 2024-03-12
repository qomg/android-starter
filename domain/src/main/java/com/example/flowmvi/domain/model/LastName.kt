package com.example.flowmvi.domain.model

import com.example.flowmvi.core.EitherNes

@JvmInline
value class LastName private constructor(val value: String) {
  companion object {
    fun create(value: String?): EitherNes<UserValidationError, LastName> =
      validateLastName(value).map(::LastName)
  }
}
