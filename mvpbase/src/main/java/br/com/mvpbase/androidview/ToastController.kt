package br.com.madeinlabs.mvpbase.androidview

import android.content.Context
import android.widget.Toast
import br.com.madeinlabs.mvpbase.exception.BaseCustomException

class ToastController(private val context: Context) {

    private var mToast: Toast? = null

    fun showShortToast(resId: Int) {
        showShortToast(context.getString(resId))
    }

    fun showShortToast(text: String?) {
        showToast(text, Toast.LENGTH_SHORT)
    }

    fun showLongToast(resId: Int) {
        showShortToast(context.getString(resId))
    }

    fun showLongToast(text: String?) {
        showToast(text, Toast.LENGTH_LONG)
    }

    fun showToast(text: String?, length: Int) {
        if (text != null) {
            cancel()
            mToast = Toast.makeText(context, text, length)
            mToast?.show()
        }
    }

    fun cancel() {
        mToast?.cancel()
    }

    fun showShortToast(throwable: Throwable, defaultResourceId: Int) {
        var resourceId = defaultResourceId
        if (throwable is BaseCustomException) {
            resourceId = throwable.getMessageResourceId()
        }
        showShortToast(resourceId)
    }

    fun showLongToast(throwable: Throwable, defaultResourceId: Int) {
        var resourceId = defaultResourceId
        if (throwable is BaseCustomException) {
            resourceId = throwable.getMessageResourceId()
        }
        showLongToast(resourceId)
    }

}
