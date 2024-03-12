package com.example.flowmvi.domain.repository

import arrow.core.Either
import com.example.flowmvi.domain.model.User
import com.example.flowmvi.domain.model.UserError
import kotlinx.coroutines.flow.Flow

interface UserRepository {
  fun getUsers(): Flow<Either<UserError, List<User>>>

  suspend fun refresh(): Either<UserError, Unit>

  suspend fun remove(user: User): Either<UserError, Unit>

  suspend fun add(user: User): Either<UserError, Unit>

  suspend fun search(query: String): Either<UserError, List<User>>
}
