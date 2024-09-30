package com.example.comes.view

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.comes.network.model.BaseViewModel

abstract class BaseActivity <T : ViewDataBinding, M : BaseViewModel> : AppCompatActivity() {
    lateinit var binding: T
    lateinit var viewModel: M

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        viewModel = ViewModelProvider(this).get(getViewModelClass())
    }
    abstract fun getLayoutResId(): Int
    abstract fun getViewModelClass(): Class<M>

}