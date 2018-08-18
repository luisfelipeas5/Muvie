package br.com.mvpbase.androidview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import br.com.madeinlabs.mvpbase.androidview.ToastController
import br.com.mvpbase.contract.Contract
import br.com.mvpbase.viewstatus.FragmentStatus

abstract class BaseFragment: Fragment(), Contract.View {

    protected lateinit var root: View
    private lateinit var fragmentStatus: FragmentStatus

    private val mStartViewAnimation = StartViewAnimation()
    private lateinit var mToastController: ToastController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(getLayoutResource(), container, false)
        fragmentStatus = FragmentStatus(this)
        mToastController = ToastController(context!!)
        onInitInject(context?.applicationContext)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitView()
    }

    abstract fun onInitInject(applicationContext: Context?)

    @LayoutRes
    abstract fun getLayoutResource(): Int

    abstract fun onInitView()

    fun setTitle(stringResource: Int) {
        activity?.setTitle(stringResource)
    }

    fun getFragmentStatus(): FragmentStatus {
        return fragmentStatus
    }

    fun showShortToast(resId: Int) {
        mToastController.showShortToast(resId)
    }

    fun showShortToast(text: String?) {
        mToastController.showToast(text, Toast.LENGTH_SHORT)
    }

    fun showLongToast(resId: Int) {
        mToastController.showShortToast(resId)
    }

    fun showLongToast(text: String?) {
        mToastController.showToast(text, Toast.LENGTH_LONG)
    }

    fun startActivity(intent: Intent, animation: Int) {
        startActivity(intent)
        mStartViewAnimation.putAnimation(this, animation)
    }

    fun startActivityForResult(intent: Intent, requestCode: Int, animation: ActivityAnimation) {
        startActivityForResult(intent, requestCode)
        mStartViewAnimation.putAnimation(this, animation)
    }

    fun finish(animation: ActivityAnimation) {
        activity?.let {
            it.finish()
            mStartViewAnimation.putAnimation(it, animation)
        }
    }

    fun showShortToast(throwable: Throwable, defaultResourceId: Int) {
        mToastController.showShortToast(throwable, defaultResourceId)
    }

    fun showLongToast(throwable: Throwable, defaultResourceId: Int) {
        mToastController.showLongToast(throwable, defaultResourceId)
    }

}