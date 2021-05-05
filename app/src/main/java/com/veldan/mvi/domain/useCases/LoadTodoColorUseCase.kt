package com.veldan.mvi.domain.useCases

import com.veldan.mvi.mvi.intents.TodoCreatorViewEvent
import com.veldan.mvi.mvi.models.TodoCreatorViewState
import kotlinx.coroutines.flow.Flow

interface LoadTodoColorUseCase {

   fun reduce(event: TodoCreatorViewEvent): Flow<TodoCreatorViewState>

}