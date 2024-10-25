package com.example.comes.util

import android.util.Log
import com.example.comes.BuildConfig

object LogUtil {
    const val TAG_RMS = "RMS"
    private const val LEVEL_VERBOSE = 0
    private const val LEVEL_DEBUG = 1
    private const val LEVEL_INFO = 2
    private const val LEVEL_WARNING = 3
    private const val LEVEL_ERROR = 4
    private const val LEVEL_FILE = 5
    var mIsDebugMode: Boolean = BuildConfig.DEBUG // DEBUG 모드 일때만 로그 사용.
    fun v(vararg args: Any) {
        log(LEVEL_VERBOSE, args)
    }

    @JvmStatic
    fun d(vararg args: Any) {
        log(LEVEL_DEBUG, args)
    }

    @JvmStatic
    fun i(vararg args: Any) {
        log(LEVEL_INFO, args)
    }

    fun w(vararg args: Any) {
        log(LEVEL_WARNING, args)
    }

    @JvmStatic
    fun e(vararg args: Any) {
        log(LEVEL_ERROR, args)
    }

    fun f(vararg args: Any) {
        log(LEVEL_FILE, args)
    }

    @Synchronized
    private fun log(level: Int, args: Array<out Any>) {
        if (mIsDebugMode) {
            if (args == null || args.size == 0) {
                return
            }
        } else {
            return
        }
        var className = Thread.currentThread().stackTrace[4].className
        val methodName = Thread.currentThread().stackTrace[4].methodName
        val nLineNumber = Thread.currentThread().stackTrace[4].lineNumber
        if (className != null) {
            val lastDotPos = className.lastIndexOf(".")
            className = className.substring(lastDotPos + 1)
        }

        // format
        var format = "" + args[0]
        format = format.replace("%d".toRegex(), "%s")
        format = format.replace("%f".toRegex(), "%s")
        format = format.replace("%c".toRegex(), "%s")
        format = format.replace("%b".toRegex(), "%s")
        format = format.replace("%x".toRegex(), "%s")
        format = format.replace("%l".toRegex(), "%s")

        // argument
        var argument = ""
        when (args.size - 1) {
            0 -> argument = format
            1 -> argument = String.format(format, "" + args[1])
            2 -> argument = String.format(format, "" + args[1], "" + args[2])
            3 -> argument = String.format(format, "" + args[1], "" + args[2], "" + args[3])
            4 -> argument =
                String.format(format, "" + args[1], "" + args[2], "" + args[3], "" + args[4])
            5 -> argument = String.format(
                format,
                "" + args[1],
                "" + args[2],
                "" + args[3],
                "" + args[4],
                "" + args[5]
            )
            else -> {}
        }
        val printLog =
            String.format("[%s] %s() [%5d] >> %s\n", className, methodName, nLineNumber, argument)
        when (level) {
            LEVEL_ERROR -> Log.e(TAG_RMS, printLog)
            LEVEL_WARNING -> Log.w(TAG_RMS, printLog)
            LEVEL_INFO -> Log.i(TAG_RMS, printLog)
            LEVEL_VERBOSE -> Log.v(TAG_RMS, printLog)
            LEVEL_DEBUG -> Log.d(TAG_RMS, printLog)
            else -> Log.d(TAG_RMS, printLog)
        }
    }
}