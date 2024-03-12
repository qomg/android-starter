package com.example.flowmvi.domain.usecase

import arrow.core.Either
import com.example.flowmvi.domain.model.UserError
import com.example.flowmvi.domain.repository.UserRepository

class RefreshGetUsersUseCase(private val userRepository: UserRepository) {
  suspend operator fun invoke(): Either<UserError, Unit> = userRepository.refresh()
}
