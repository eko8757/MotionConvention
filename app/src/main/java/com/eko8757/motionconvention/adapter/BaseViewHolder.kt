package com.eko8757.motionconvention.adapter

import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eko8757.motionconvention.R
import com.eko8757.motionconvention.common.TRANSITION_CARD
import com.eko8757.motionconvention.common.inflate
import com.eko8757.motionconvention.model.DataProvider.BaseData
import com.eko8757.motionconvention.model.DataProvider.Card
import com.eko8757.motionconvention.model.DataProvider.Details
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_card.*
import kotlinx.android.synthetic.main.item_details.*

abstract class BaseViewHolder<T : BaseData>(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {

    override val containerView: View?
        get() = itemView

    abstract fun bind(data: T, listener: View.OnClickListener? = null)

    class CardViewHolder(parent: ViewGroup) : BaseViewHolder<Card>(parent.inflate(R.layout.item_card)) {

        override fun bind(data: Card, listener: View.OnClickListener?) {
            containerView?.setOnClickListener(listener)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                containerView?.transitionName = TRANSITION_CARD + adapterPosition
            }

            tv_title.text = data.name
            tv_amount.text = data.amount
            tv_date.text = data.date
            tv_status.text = data.status.code
            img_status.setImageResource(data.status.iconId)
            img_card.setImageResource(data.imageId)
        }
    }

    class DetailsViewHolder(parent: ViewGroup) : BaseViewHolder<Details>(parent.inflate(R.layout.item_details)) {

        override fun bind(data: Details, listener: View.OnClickListener?) {
            tv_details_title.text = data.title
            tv_details_subtitle.text = data.subtitle
            tv_details_amount.text = data.amount
        }
    }
}