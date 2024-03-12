package com.example.flowmvi.domain.model

import com.example.flowmvi.core.EitherNes

@JvmInline
value class Email private constructor(val value: String) {
  companion object {
    fun create(value: String?): EitherNes<UserValidationError, Email> =
      validateEmail(value).map(::Email)
  }
}
