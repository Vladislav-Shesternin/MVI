package com.veldan.mvi.domain.useCases

import com.veldan.mvi.ui.viewComponents.todoRecycleView.Todo

interface GetTodoUseCase {

    fun getTodoList(): List<Todo>

}