package com.example.comes.view.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.ViewDataBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.comes.custom.LoadingProgressDialog
import com.example.comes.network.model.BaseViewModel
import com.example.comes.ComesApp.Companion.instance
import com.example.comes.common.DEFINE
import java.util.*

/**
 * author : hyeonmun
 * develop date : 2024-10-18
 * coment : A basic activity that is used to implement only the necessary code by predefining overlapping code when using multiple activities.
 */
abstract class BaseActivity <T : ViewDataBinding, M : BaseViewModel> : AppCompatActivity() {

    // lateinit을 사용한 Non-nullable 타입
    lateinit var binding: T
//    abstract val layoutResId: Int    // setContentView로 호출할 Layout 파일
    lateinit var viewModel: M        // Activity에서 viewModel로 쓸 변수

    private var mProgress: LoadingProgressDialog? = null
    var useLoading: Boolean = true
    private var beforeContext: Context? = null

    abstract fun getLayoutResId(): Int  // setContentView로 호출할 Layout 파일
    abstract fun getViewModel(): Class<M>
    abstract fun initView()          // 뷰or액티비티의 속성 등을 초기화
    abstract fun initDataBinding()   // 데이터 바인딩 및 rxjava 설정
    abstract fun initAfterBinding()  // 바인딩 이후 할 일 구현, 클릭리스너 등등

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        getLocaleLanguage(true)

        // 초기화된 layoutResId로 binding 객체 생성
        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        viewModel = ViewModelProvider(this).get(getViewModel())
        if (viewModel != null) {
        }
        // live data를 사용하기 위함
        binding.lifecycleOwner = this@BaseActivity
        mProgress = LoadingProgressDialog(this)

        initView()
        initDataBinding()
        initAfterBinding()
    }

    /**
     * 로딩바 표시.
     */
    open fun showLoading() {
        if (mProgress == null) {
            mProgress = LoadingProgressDialog(this)
        }
        if (!mProgress!!.isShowing()) {
            try {
                mProgress!!.show()
            } catch (e: Exception) {
            }
        }
    }

    /**
     * 로딩바 닫기.
     */
    open fun hideLoading() {
        if (mProgress != null && mProgress!!.isShowing()) {
            mProgress!!.dismiss()
        }
    }

//    fun getLocaleLanguage (isChangeLocaleLanguage: Boolean): String {
//        val local: Locale
////        val savedLang = PreferenceUtil.getString(this, )
//
//    }

}