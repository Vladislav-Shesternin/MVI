package com.veldan.mvi.domain.repositories

import com.veldan.mvi.domain.useCases.GetTodoUseCase
import com.veldan.mvi.ui.viewComponents.todoRecycleView.Todo
import javax.inject.Inject

class GetTodoRepo @Inject constructor() : GetTodoUseCase {

    override fun getTodoList(): List<Todo> {
        return List(50) {
            Todo("TODO: ${it.inc()}")
        }
    }

}