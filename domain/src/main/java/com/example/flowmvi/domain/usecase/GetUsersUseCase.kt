package com.example.flowmvi.domain.usecase

import arrow.core.Either
import com.example.flowmvi.domain.model.User
import com.example.flowmvi.domain.model.UserError
import com.example.flowmvi.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(private val userRepository: UserRepository) {
  operator fun invoke(): Flow<Either<UserError, List<User>>> = userRepository.getUsers()
}
