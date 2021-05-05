package com.veldan.mvi.ui.fragments

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import com.airbnb.lottie.LottieAnimationView
import com.veldan.mvi.databinding.FragmentTodoCreatorBinding
import com.veldan.mvi.mvi.models.TodoCreatorViewState
import com.veldan.mvi.viewModels.TodoCreatorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoCreator : Fragment() {

    private val TAG = this::class.simpleName

    private lateinit var binding: FragmentTodoCreatorBinding

    private val viewModel: TodoCreatorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return initBinding()
    }

    override fun onResume() {
        super.onResume()

        /** LiveData - Удобней как по Мне */

        viewModel.state.observe(this) { state ->
            render(state)
        }

//        viewModel.state.asLiveData().observe(this) { state ->
//            state?.let {
//                render(state)
//            }
//        }

    }

    private fun initBinding(): View {
        FragmentTodoCreatorBinding.inflate(layoutInflater).apply {
            binding = this
            todoCreatorViewModel = viewModel
            return root
        }
    }

    private fun render(state: TodoCreatorViewState) {
        when (state) {
            is TodoCreatorViewState.LoadingColor -> {
                showLoadingColor()

            }
            is TodoCreatorViewState.LoadedColor -> {
                hideLoadingColor()

            }
        }
    }

    private fun showLoadingColor() {
        binding.lottieProgressBar.apply {
            visibility = View.VISIBLE
            repeatCount = ValueAnimator.INFINITE
            playAnimation()
        }
    }

    private fun hideLoadingColor() {
        binding.lottieProgressBar.apply {
            visibility = View.INVISIBLE
            cancelAnimation()
        }
    }
}