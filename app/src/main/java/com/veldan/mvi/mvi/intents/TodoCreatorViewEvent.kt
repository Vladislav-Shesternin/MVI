package com.veldan.mvi.mvi.intents

sealed class TodoCreatorViewEvent {
    object LoadColor : TodoCreatorViewEvent()
}