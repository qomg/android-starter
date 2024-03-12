package com.example.flowmvi.ui.add

import com.example.flowmvi.domain.model.Email
import com.example.flowmvi.domain.model.FirstName
import com.example.flowmvi.domain.model.LastName
import com.example.flowmvi.domain.model.UserValidationError
import com.example.flowmvi.test_utils.rightValueOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Suppress("ClassName")
class Email_FirstName_LastName_Test {
  @Test
  fun testCreateEmail_withValidEmail_returnsValid() {
    val validated = Email.create("yourname@example.com")
    assertTrue(validated.isRight())
    assertEquals(
      "yourname@example.com",
      validated.rightValueOrThrow.value,
    )
  }

  @Test
  fun testCreateEmail_withInvalidEmail_returnsInvalid() {
    assertEquals(
      UserValidationError.INVALID_EMAIL_ADDRESS.asLeftNes,
      Email.create(null),
    )
    assertEquals(
      UserValidationError.INVALID_EMAIL_ADDRESS.asLeftNes,
      Email.create(""),
    )
    assertEquals(
      UserValidationError.INVALID_EMAIL_ADDRESS.asLeftNes,
      Email.create("a"),
    )
    assertEquals(
      UserValidationError.INVALID_EMAIL_ADDRESS.asLeftNes,
      Email.create("a@"),
    )
  }

  @Test
  fun testCreateFirstName_withValidFirstName_returnsValid() {
    val validated = FirstName.create("qomg")
    assertTrue(validated.isRight())
    assertEquals(
      "qomg",
      validated.rightValueOrThrow.value,
    )
  }

  @Test
  fun testCreateFirstName_withInvalidFirstName_returnsInvalid() {
    assertEquals(
      UserValidationError.TOO_SHORT_FIRST_NAME.asLeftNes,
      FirstName.create(null),
    )
    assertEquals(
      UserValidationError.TOO_SHORT_FIRST_NAME.asLeftNes,
      FirstName.create(""),
    )
    assertEquals(
      UserValidationError.TOO_SHORT_FIRST_NAME.asLeftNes,
      FirstName.create("a"),
    )
    assertEquals(
      UserValidationError.TOO_SHORT_FIRST_NAME.asLeftNes,
      FirstName.create("ab"),
    )
  }

  @Test
  fun testCreateLastName_withValidLastName_returnsValid() {
    val validated = LastName.create("qomg")
    assertTrue(validated.isRight())
    assertEquals(
      "qomg",
      validated.rightValueOrThrow.value,
    )
  }

  @Test
  fun testCreateLastName_withInvalidLastName_returnsInvalid() {
    assertEquals(
      UserValidationError.TOO_SHORT_LAST_NAME.asLeftNes,
      LastName.create(null),
    )
    assertEquals(
      UserValidationError.TOO_SHORT_LAST_NAME.asLeftNes,
      LastName.create(""),
    )
    assertEquals(
      UserValidationError.TOO_SHORT_LAST_NAME.asLeftNes,
      LastName.create("a"),
    )
    assertEquals(
      UserValidationError.TOO_SHORT_LAST_NAME.asLeftNes,
      LastName.create("ab"),
    )
  }
}
