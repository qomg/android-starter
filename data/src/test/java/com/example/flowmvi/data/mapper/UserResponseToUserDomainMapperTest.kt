package com.example.flowmvi.data.mapper

import com.example.flowmvi.data.remote.UserResponse
import com.example.flowmvi.domain.model.User
import com.example.flowmvi.domain.model.UserValidationError
import com.example.flowmvi.test_utils.leftValueOrThrow
import com.example.flowmvi.test_utils.rightValueOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserResponseToUserDomainMapperTest {
  private val mapper = UserResponseToUserDomainMapper()

  @Test
  fun testUserDomainToUserResponseMapper_withValidResponse_returnsValid() {
    val validated = mapper(
      UserResponse(
        id = "id",
        email = "yourname@example.com",
        firstName = "first",
        lastName = "last",
        avatar = "avatar",
      )
    )
    assertTrue(validated.isRight())
    assertEquals(
      User.create(
        id = "id",
        email = "yourname@example.com",
        firstName = "first",
        lastName = "last",
        avatar = "avatar",
      ).rightValueOrThrow,
      validated.rightValueOrThrow,
    )
  }

  @Test
  fun testUserDomainToUserResponseMapper_withInvalidResponse_returnsInvalid() {
    val validated = mapper(
      UserResponse(
        id = "id",
        email = "email@",
        firstName = "first",
        lastName = "last",
        avatar = "avatar",
      )
    )
    assertTrue(validated.isLeft())
    assertEquals(
      UserValidationError.INVALID_EMAIL_ADDRESS,
      validated.leftValueOrThrow.single(),
    )
  }
}
