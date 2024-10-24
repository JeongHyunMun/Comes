package com.example.comes.custom

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.comes.R
import com.example.comes.databinding.DialogLoadingProgressBinding
import com.example.comes.util.ResourceUtil


class LoadingProgressDialog(context: Context) : Dialog(context, R.style.LoadingBar) {
    private lateinit var binding: DialogLoadingProgressBinding

    /**
     * 로딩바 Dialog
     * @param context
     */
//    init {
//        initView()
//    }

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setCancelable(false)
        initView()
    }

    fun initView() {
        window
            ?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        window!!.setBackgroundDrawable(ColorDrawable(ResourceUtil.getColor(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)))
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(
                context
            ), R.layout.dialog_loading_progress, null, false
        )
        setContentView(binding.getRoot())
    }

    override fun show() {
        super.show()
        binding!!.ivLoading.startAnimation(binding!!.ivLoading.rotateAnimation)
    }

    override fun dismiss() {
        super.dismiss()
        binding!!.ivLoading.clearAnimation()
    }
}