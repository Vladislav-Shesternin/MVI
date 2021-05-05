package com.veldan.mvi.viewModels

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.veldan.mvi.domain.interactors.GetTodo
import com.veldan.mvi.ui.fragments.TodoList
import com.veldan.mvi.ui.fragments.TodoListDirections
import com.veldan.mvi.ui.viewComponents.todoRecycleView.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val getTodo: GetTodo
) : ViewModel() {

    fun getTodoList(): List<Todo> {
        return getTodo.invoke()
    }

    fun navigateToCreatorTodo(fragment: TodoList) {
        val action = TodoListDirections.actionTodoListToCreatorTodo()
        fragment.findNavController().navigate(action)
    }
}