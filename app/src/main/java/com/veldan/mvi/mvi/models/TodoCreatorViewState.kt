package com.veldan.mvi.mvi.models

sealed class TodoCreatorViewState {
    object LoadingColor : TodoCreatorViewState()
    data class LoadedColor(val color: Int) : TodoCreatorViewState()
}