package com.veldan.mvi.domain.interactors

import com.veldan.mvi.domain.useCases.LoadTodoColorUseCase
import com.veldan.mvi.mvi.intents.TodoCreatorViewEvent
import com.veldan.mvi.mvi.models.TodoCreatorViewState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadTodoColor @Inject constructor(
    private val loadTodoColor: LoadTodoColorUseCase
) {

    operator fun invoke(event: TodoCreatorViewEvent): Flow<TodoCreatorViewState> {
        return loadTodoColor.reduce(event)
    }

}