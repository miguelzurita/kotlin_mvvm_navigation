package com.miguelzurita.demo.view

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.miguelzurita.demo.R
import com.miguelzurita.demo.databinding.FragmentAddBinding
import com.miguelzurita.demo.viewmodel.AddViewModel


/**
 * A simple [Fragment] subclass.
 */
class AddFragment : Fragment() {

    private lateinit var viewmodel: AddViewModel
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddBinding.inflate(inflater)
        viewmodel = ViewModelProviders.of(this).get(AddViewModel::class.java)
        binding.viewmodel = viewmodel

        initializeObserver()
        configureUI()

        return binding.root
    }

    private fun initializeObserver() {
        viewmodel.saveLiveData.observe(this, Observer {
            binding.etName.requestFocus()
            if (it) {
                // show success feedback on save
                changeBackgroundColor(resources.getColor(R.color.purple_500), resources.getColor(R.color.teal_200), 300, 1500)
            } else {
                // show error feedback
                changeBackgroundColor(resources.getColor(R.color.purple_500), resources.getColor(R.color.red), 300, 1500)
            }
        })
    }

    private fun changeBackgroundColor(initColor: Int, temporalColor: Int, animationDuration: Long, duration: Long) {
        val backgroundColorAnimator = ObjectAnimator.ofObject(binding.btnAdd, "backgroundColor", ArgbEvaluator(), initColor, temporalColor)
        backgroundColorAnimator.duration = animationDuration
        backgroundColorAnimator.start()

        object : CountDownTimer(duration, 50) {
            override fun onTick(arg0: Long) {}

            override fun onFinish() {
                val backgroundColorAnimator = ObjectAnimator.ofObject(binding.btnAdd, "backgroundColor", ArgbEvaluator(), temporalColor, initColor)
                backgroundColorAnimator.duration = animationDuration
                backgroundColorAnimator.start()
            }
        }.start()
    }

    private fun configureUI() {

    }

}