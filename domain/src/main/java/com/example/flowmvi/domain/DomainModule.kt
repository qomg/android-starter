package com.example.flowmvi.domain

import com.example.flowmvi.domain.usecase.AddUserUseCase
import com.example.flowmvi.domain.usecase.GetUsersUseCase
import com.example.flowmvi.domain.usecase.RefreshGetUsersUseCase
import com.example.flowmvi.domain.usecase.RemoveUserUseCase
import com.example.flowmvi.domain.usecase.SearchUsersUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

@JvmField
val domainModule = module {
  factoryOf(::GetUsersUseCase)

  factoryOf(::RefreshGetUsersUseCase)

  factoryOf(::RemoveUserUseCase)

  factoryOf(::AddUserUseCase)

  factoryOf(::SearchUsersUseCase)
}
