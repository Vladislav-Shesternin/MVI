package com.veldan.mvi.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veldan.mvi.domain.interactors.LoadTodoColor
import com.veldan.mvi.mvi.intents.TodoCreatorViewEvent
import com.veldan.mvi.mvi.models.TodoCreatorViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoCreatorViewModel @Inject constructor(
    private val loadTodoColor: LoadTodoColor
) : ViewModel() {

    /** LiveData - Удобней как по Мне */

    private val _state = MutableLiveData<TodoCreatorViewState>()
    val state: LiveData<TodoCreatorViewState> get() = _state

//    private val _state = MutableStateFlow<TodoCreatorViewState?>(null)
//    val state: StateFlow<TodoCreatorViewState?> get() = _state

//   val lambdaLoadTodoColor: () -> Unit  = {
//        viewModelScope.launch {
//            loadTodoColor(TodoCreatorViewEvent.LoadColor).collect {
//                _state.value = it
//            }
//        }
//    }

    fun lambdaLoadTodoColor() {
        viewModelScope.launch {
            loadTodoColor(TodoCreatorViewEvent.LoadColor).collect {
                _state.value = it
            }
        }
    }

}

