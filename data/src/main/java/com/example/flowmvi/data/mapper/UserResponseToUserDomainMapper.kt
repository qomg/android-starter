package com.example.flowmvi.data.mapper

import com.example.flowmvi.core.EitherNes
import com.example.flowmvi.core.Mapper
import com.example.flowmvi.data.remote.UserResponse
import com.example.flowmvi.domain.model.User
import com.example.flowmvi.domain.model.UserValidationError

internal class UserResponseToUserDomainMapper :
  Mapper<UserResponse, EitherNes<UserValidationError, User>> {
  override fun invoke(response: UserResponse): EitherNes<UserValidationError, User> {
    return User.create(
      id = response.id,
      avatar = response.avatar,
      email = response.email,
      firstName = response.firstName,
      lastName = response.lastName
    )
  }
}
