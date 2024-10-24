package com.example.comes.view

import android.content.Intent
import android.os.Bundle
import com.example.comes.R
import com.example.comes.databinding.ActivityIntroBinding
import com.example.comes.network.model.BaseViewModel
import com.example.comes.view.base.BaseActivity
import com.example.comes.view.login.LoginActivity

class IntroActivity : BaseActivity<ActivityIntroBinding, BaseViewModel>() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_intro
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
        var btn_start = binding.startBtn
        btn_start.setOnClickListener{
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initDataBinding() {
        // DataBinding 관련 초기화 작업 작성
    }

    override fun initAfterBinding() {
        // DataBinding 이후 작업 작성
    }



}