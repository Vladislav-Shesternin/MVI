package com.veldan.mvi.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.veldan.mvi.databinding.FragmentTodoListBinding
import com.veldan.mvi.viewModels.TodoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoList : Fragment() {

    private val TAG = this::class.simpleName

    private lateinit var binding: FragmentTodoListBinding

    private val viewModel: TodoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return initBinding()
    }

    private fun initBinding(): View {
        FragmentTodoListBinding.inflate(layoutInflater).apply {
            binding = this
            todoList = this@TodoList
            todoListViewModel = viewModel
            return root
        }
    }

    val onItemClick: (TextView?) -> Unit = {
        Log.i(TAG, "onItemClick: ${it?.text}")
    }


}