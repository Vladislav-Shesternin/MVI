package com.veldan.mvi.domain.interactors

import com.veldan.mvi.domain.useCases.GetTodoUseCase
import com.veldan.mvi.ui.viewComponents.todoRecycleView.Todo
import javax.inject.Inject

class GetTodo @Inject constructor(
    private val getTodo: GetTodoUseCase
) {

    operator fun invoke(): List<Todo> {
        return getTodo.getTodoList()
    }

}