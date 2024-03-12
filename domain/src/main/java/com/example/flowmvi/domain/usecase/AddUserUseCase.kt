package com.example.flowmvi.domain.usecase

import arrow.core.Either
import com.example.flowmvi.domain.model.User
import com.example.flowmvi.domain.model.UserError
import com.example.flowmvi.domain.repository.UserRepository

class AddUserUseCase(private val userRepository: UserRepository) {
  suspend operator fun invoke(user: User): Either<UserError, Unit> = userRepository.add(user)
}
