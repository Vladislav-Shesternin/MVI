package com.veldan.mvi.ui.viewComponents.todoRecycleView

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoRecycleView(
    context: Context,
    attrs: AttributeSet
) : RecyclerView(context, attrs) {

    private val TAG = this::class.simpleName

    private val adapterTodo = TodoAdapter()

    init {
        initAdapter()
    }

    private fun initAdapter() {
        adapter = adapterTodo
    }

    fun setItemList(todoList: List<Todo>) {
        adapterTodo.submitList(todoList)
    }

    fun setItemClick(block: (TextView?) -> Unit) {
        adapterTodo.onItemClick = block
    }

}