package com.example.comes.view.login

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.comes.R
import com.example.comes.custom.CustomDialog
import com.example.comes.databinding.ActivityLoginBinding
import com.example.comes.databinding.ActivityMainBinding
import com.example.comes.network.model.BaseViewModel
import com.example.comes.network.model.MainViewModel
import com.example.comes.network.model.request.LoginRequest
import com.example.comes.network.model.response.LoginResponse
import com.example.comes.view.base.BaseActivity
import java.util.*

class LoginActivity : BaseActivity<ActivityLoginBinding, BaseViewModel>() {
    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun getViewModel(): Class<BaseViewModel> {
        return BaseViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    override fun initView() {
        // UI 초기화 관련 코드를 여기에 작성
        var lgn_id = binding.loginId
        var lgn_pw = binding.loginPw
        var lgn_btn = binding.loginBtn
    }

    private fun reqLogin() {
        var strId: String = binding.loginId?.getText()?.toString() ?: ""
        var strPw: String = binding.loginPw?.getText()?.toString() ?: ""

        if (TextUtils.isEmpty(strId)) {
            binding.loginBtn.setClickable(true)
            Toast.makeText(this, getLayoutResId(), Toast.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(strPw)) {
            binding.loginBtn.setClickable(true)
            Toast.makeText(this, getLayoutResId(), Toast.LENGTH_SHORT).show()
            return
        }
        var loginRequest: LoginRequest = LoginRequest()
        var locale: String = Locale.getDefault().toString()
        loginRequest.setAutoLgn("N")
        loginRequest.setLgnId(strId)
        loginRequest.setLgnPwd(strPw)
        loginRequest.setLocale(locale)
        showLoading()
        getViewModel().getConstructor().newInstance().reqLogin(loginRequest)

    }

    override fun initDataBinding() {
        // DataBinding 관련 초기화 작업 작성
    }

    override fun initAfterBinding() {
        // DataBinding 이후 작업 작성
    }
}