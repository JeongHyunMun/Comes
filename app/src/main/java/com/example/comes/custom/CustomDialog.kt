package com.example.comes.custom

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.comes.R
import com.example.comes.databinding.DialogCommonAlertBinding
import com.example.comes.util.ResourceUtil

class CustomDialog(context: Context) : Dialog(context, R.style.CustomBaseDialog) {
    private lateinit var mBinding: DialogCommonAlertBinding

    /**
     * 공통 Dialog
     * @param context
     */
    init {
        initView()
    }

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
    }

    fun initView() {
        window
            ?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        window!!.setBackgroundDrawable(ColorDrawable(ResourceUtil.getColor(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)))
        window!!.attributes.dimAmount = 0.6f
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(
                context
            ), R.layout.dialog_common_alert, null, false
        )
        setContentView(mBinding.getRoot())
    }

    fun setMessage(message: String?) {
        if (TextUtils.isEmpty(message)) {
            return
        }
        mBinding!!.tvContents.text = message
    }

    fun setPositiveButton(text: String?, listener: DialogInterface.OnClickListener?) {
        mBinding!!.tvOk.text = text
        setButton(mBinding!!.tvOk, listener)
    }

    fun setNegativeButton(text: String?, listener: DialogInterface.OnClickListener?) {
        mBinding!!.tvCancel.text = text
        setButton(mBinding!!.tvCancel, listener)
    }

    private fun setButton(btn: View?, listener: DialogInterface.OnClickListener?) {
        if (btn == null) {
            return
        }
        btn.visibility = View.VISIBLE
        btn.setOnClickListener(View.OnClickListener { view: View ->
            dismiss()
            try {
                if (listener != null) {
                    if (view.id == R.id.tv_ok) {
                        listener.onClick(this@CustomDialog, BUTTON_POSITIVE)
                    } else if (view.id == R.id.tv_cancel) {
                        listener.onClick(this@CustomDialog, BUTTON_NEGATIVE)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })
    }

    fun setCancelable(flag: Boolean, listener: DialogInterface.OnClickListener?) {
        super.setCancelable(flag)
        if (flag) {
            setOnCancelListener { dialog: DialogInterface? ->
                listener?.onClick(
                    this@CustomDialog,
                    BUTTON_NEUTRAL
                )
            }
        }
    }
}