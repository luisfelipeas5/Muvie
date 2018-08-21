package br.com.mvpbase.androidview

import android.app.Activity
import androidx.fragment.app.Fragment
import br.com.mvpbase.R

typealias ActivityAnimation = Int

class StartViewAnimation {
    companion object {
        private const val TRANSLATE_LEFT: ActivityAnimation = 1
        private const val TRANSLATE_RIGHT: ActivityAnimation = 2
        private const val TRANSLATE_UP: ActivityAnimation = 3
        private const val TRANSLATE_DOWN: ActivityAnimation = 4
        private const val TRANSLATE_FADE: ActivityAnimation = 5
    }

    fun putAnimation(activity: Activity, animation: ActivityAnimation) {
        try {
            val animations = getAnimation(animation)
            activity.overridePendingTransition(animations[0], animations[1])
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    fun putAnimation(fragment: Fragment, animation: ActivityAnimation) {
        try {
            val animations = getAnimation(animation)
            fragment.activity?.overridePendingTransition(animations[0], animations[1])
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    private fun getAnimation(animation: ActivityAnimation): IntArray {
        val exitAnim: Int
        val enterAnim: Int

        when (animation) {

            TRANSLATE_UP -> {
                enterAnim = R.anim.translate_slide_up
                exitAnim = R.anim.translate_no_change
            }

            TRANSLATE_DOWN -> {
                enterAnim = R.anim.translate_no_change
                exitAnim = R.anim.translate_slide_down
            }

            TRANSLATE_RIGHT -> {
                enterAnim = R.anim.translate_right_enter
                exitAnim = R.anim.translate_right_exit
            }

            TRANSLATE_FADE -> {
                enterAnim = R.anim.translate_fade_in
                exitAnim = R.anim.translate_fade_out
            }

            TRANSLATE_LEFT -> {
                enterAnim = R.anim.translate_left_enter
                exitAnim = R.anim.translate_left_exit
            }
            else -> {
                enterAnim = R.anim.translate_left_enter
                exitAnim = R.anim.translate_left_exit
            }
        }

        return intArrayOf(enterAnim, exitAnim)
    }

}
