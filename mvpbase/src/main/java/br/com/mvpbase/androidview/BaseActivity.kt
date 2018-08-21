package br.com.mvpbase.androidview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.madeinlabs.mvpbase.androidview.ToastController
import br.com.mvpbase.contract.Contract
import br.com.mvpbase.viewstatus.ActivityStatus

abstract class BaseActivity: AppCompatActivity(), Contract.View {

    private lateinit var activityStatus: ActivityStatus

    private val mStartViewAnimation = StartViewAnimation()
    private lateinit var mToastController: ToastController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        activityStatus = ActivityStatus(this)
        mToastController = ToastController(this)
        onInitInject(applicationContext)
        onInitView()
    }

    abstract fun onInitInject(applicationContext: Context?)

    abstract fun getLayoutResource(): Int

    abstract fun onInitView()

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun getActivityStatus(): ActivityStatus {
        return activityStatus
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

    override fun onDestroy() {
        mToastController.cancel()
        super.onDestroy()
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
        finish()
        mStartViewAnimation.putAnimation(this, animation)
    }

}
