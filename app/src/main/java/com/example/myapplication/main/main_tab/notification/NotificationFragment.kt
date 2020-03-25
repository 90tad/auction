package com.example.myapplication.main.main_tab.notification

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ultis.extensions.gone
import com.example.myapplication.ultis.extensions.visible
import kotlinx.android.synthetic.main.product_item_2.*

class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expanded_more_button.setOnClickListener {

//            product_item_expanded_view
//                .animate()
//                .translationY(item.height.toFloat())
//                .alpha(0.0f)
//                .setDuration(100)
//                .setListener(object : AnimatorListenerAdapter() {
//                    override fun onAnimationEnd(animation: Animator?) {
//                        super.onAnimationEnd(animation)
//                        if (product_item_expanded_view.visibility == View.VISIBLE) product_item_expanded_view.gone()
//                        else product_item_expanded_view.visible()
//                    }
//                })

            val viewPropertyAnimator = it.animate()
            viewPropertyAnimator
                .rotationBy(180F)
                .setDuration(200)
                .interpolator = DecelerateInterpolator()
            viewPropertyAnimator
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {
                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        it.isEnabled = true
                    }

                    override fun onAnimationCancel(animation: Animator?) {
                    }

                    override fun onAnimationStart(animation: Animator?) {
                        it.isEnabled = false
                        if (product_item_expanded_view.visibility == View.VISIBLE)
                            product_item_expanded_view.gone() else
                            product_item_expanded_view.visible()
                    }

                })
        }
    }

}
