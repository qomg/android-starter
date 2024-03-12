package com.example.flowmvi.data.mapper

import com.example.flowmvi.core.Mapper
import com.example.flowmvi.data.remote.UserBody
import com.example.flowmvi.domain.model.User

internal class UserDomainToUserBodyMapper : Mapper<User, UserBody> {
  override fun invoke(domain: User): UserBody {
    return UserBody(
      email = domain.email.value,
      firstName = domain.firstName.value,
      lastName = domain.lastName.value
    )
  }
}
