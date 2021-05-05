package com.veldan.mvi.domain.repositories

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.veldan.mvi.domain.useCases.LoadTodoColorUseCase
import com.veldan.mvi.mvi.intents.TodoCreatorViewEvent
import com.veldan.mvi.mvi.models.TodoCreatorViewState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoadTodoColorRepo @Inject constructor() : LoadTodoColorUseCase {

    override fun reduce(event: TodoCreatorViewEvent): Flow<TodoCreatorViewState> {

        val state: Flow<TodoCreatorViewState>

        when (event) {
            is TodoCreatorViewEvent.LoadColor -> {
                state = loadColor()
            }
        }

        return state
    }

    private fun loadColor() = flow<TodoCreatorViewState> {

        emit(TodoCreatorViewState.LoadingColor)
        delay(randomTime().toLong())
        emit(TodoCreatorViewState.LoadedColor(Color.RED))

    }.flowOn(Dispatchers.Default)


    private fun randomTime() = (500..5000).random()
}