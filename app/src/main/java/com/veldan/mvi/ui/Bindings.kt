package com.veldan.mvi.ui

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView
import com.veldan.mvi.ui.viewComponents.todoRecycleView.Todo
import com.veldan.mvi.ui.viewComponents.todoRecycleView.TodoRecycleView

@BindingAdapter("onItemClick")
fun TodoRecycleView.onItemClick(block: (TextView?) -> Unit) {
    this.setItemClick(block)
}

@BindingAdapter("todoList")
fun TodoRecycleView.setTodoList(todoList: List<Todo>) {
    this.setItemList(todoList)
}

private var lottieAnimationView: LottieAnimationView? = null

@BindingAdapter("click")
fun LottieAnimationView.click(block: () -> Unit) {
    setOnClickListener {

        lottieAnimationView?.let {
            hideColorSelectionAnimation(it)
        }

        lottieAnimationView = this

        showColorSelectionAnimation(this)

        block()
    }
}



private fun showColorSelectionAnimation(lottie: LottieAnimationView) {
    lottie.apply {
        speed = 1f
        playAnimation()
    }
}

private fun hideColorSelectionAnimation(lottie: LottieAnimationView) {
    lottie.apply {
        speed = -1f
        playAnimation()
    }
}