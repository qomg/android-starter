package com.example.flowmvi.ui.main

import com.example.flowmvi.domain.model.User
import com.example.flowmvi.test_utils.rightValueOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals

class MainContractTest {
  @Test
  fun test_userItem_equals() {
    assertEquals(
      UserItem(
        id = "0",
        email = "yourname@example.com",
        avatar = "avatar.png",
        firstName = "first",
        lastName = "last"
      ),
      UserItem(
        id = "0",
        email = "yourname@example.com",
        avatar = "avatar.png",
        firstName = "first",
        lastName = "last"
      )
    )
  }

  @Test
  fun test_userItem_hashCode() {
    assertEquals(
      UserItem(
        id = "0",
        email = "yourname@example.com",
        avatar = "avatar.png",
        firstName = "first",
        lastName = "last"
      ).hashCode(),
      UserItem(
        id = "0",
        email = "yourname@example.com",
        avatar = "avatar.png",
        firstName = "first",
        lastName = "last"
      ).hashCode()
    )
  }

  @Test
  fun test_userItem_fullName() {
    assertEquals(
      UserItem(
        id = "0",
        email = "yourname@example.com",
        avatar = "avatar.png",
        firstName = "first",
        lastName = "last"
      ).fullName,
      "first last",
    )
  }

  @Test
  fun test_userItem_toDomain() {
    assertEquals(
      User.create(
        id = "0",
        email = "yourname@example.com",
        firstName = "first",
        lastName = "last",
        avatar = "avatar.png",
      ).rightValueOrThrow,
      UserItem(
        id = "0",
        email = "yourname@example.com",
        avatar = "avatar.png",
        firstName = "first",
        lastName = "last"
      ).toDomain().rightValueOrThrow,
    )
  }

  @Test
  fun test_userItem_fromDomain() {
    assertEquals(
      UserItem(
        id = "0",
        email = "yourname@example.com",
        avatar = "avatar.png",
        firstName = "first",
        lastName = "last"
      ),
      UserItem(
        domain = User.create(
          id = "0",
          email = "yourname@example.com",
          firstName = "first",
          lastName = "last",
          avatar = "avatar.png",
        ).rightValueOrThrow
      ),
    )
  }
}
