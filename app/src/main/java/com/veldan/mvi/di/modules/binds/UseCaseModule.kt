package com.veldan.mvi.di.modules.binds

import com.veldan.mvi.domain.repositories.GetTodoRepo
import com.veldan.mvi.domain.repositories.LoadTodoColorRepo
import com.veldan.mvi.domain.useCases.GetTodoUseCase
import com.veldan.mvi.domain.useCases.LoadTodoColorUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetTodo(impl: GetTodoRepo): GetTodoUseCase

    @Binds
    abstract fun bindLoadColor(impl: LoadTodoColorRepo): LoadTodoColorUseCase

}