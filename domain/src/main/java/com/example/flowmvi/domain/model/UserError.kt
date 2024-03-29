package com.example.flowmvi.domain.model

import com.example.flowmvi.core.NonEmptySet

sealed class UserError : Throwable() {
  object NetworkError : UserError()
  data class UserNotFound(val id: String) : UserError()
  data class InvalidId(val id: String) : UserError()
  data class ValidationFailed(val errors: NonEmptySet<UserValidationError>) : UserError()
  object ServerError : UserError()
  object Unexpected : UserError()
}
