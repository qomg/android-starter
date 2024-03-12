package com.example.flowmvi.data.mapper

import com.example.flowmvi.data.remote.UserBody
import com.example.flowmvi.domain.model.User
import com.example.flowmvi.test_utils.rightValueOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals

class UserDomainToUserBodyMapperTest {
  private val mapper = UserDomainToUserBodyMapper()

  @Test
  fun test_UserDomainToUserBodyMapper() {
    val body = mapper(
      User.create(
        id = "id",
        email = "yourname@example.com",
        firstName = "first",
        lastName = "last",
        avatar = "avatar",
      ).rightValueOrThrow
    )

    assertEquals(
      UserBody(
        email = "yourname@example.com",
        firstName = "first",
        lastName = "last",
      ),
      body
    )
  }
}
