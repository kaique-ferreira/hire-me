package com.aruana.hireme.customviews

import android.content.Context
import android.util.AttributeSet
import com.aruana.hireme.R
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.job_card.view.*

class JobCardView : MaterialCardView {

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        inflate(context, R.layout.job_card, this)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.JobCardView, 0, 0)
            try {
                val title = typedArray.getString(R.styleable.JobCardView_title)
                val image = typedArray.getDrawable(R.styleable.JobCardView_image)

                rootView.jobTitle.text = title
                rootView.jobImage.apply {
                    transitionName = title
                    background = image
                }
            } finally {
                typedArray.recycle()
            }
        }
    }
}

