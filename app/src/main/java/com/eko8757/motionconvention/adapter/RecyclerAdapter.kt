package com.eko8757.motionconvention.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eko8757.motionconvention.model.DataProvider.Details
import com.eko8757.motionconvention.model.DataProvider.BaseData

class RecyclerAdapter<T : BaseData>(private var dataSet: List<T>, private var listener: View.OnClickListener? = null)
    : RecyclerView.Adapter<BaseViewHolder<T>>() {

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return when (viewType) {
            0 -> BaseViewHolder.DetailsViewHolder(parent) as BaseViewHolder<T>
            else -> BaseViewHolder.CardViewHolder(parent) as BaseViewHolder<T>
        }
    }

    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        val type = dataSet[0].javaClass
        return when (type) {
            Details::class.java -> 0
            else -> 1
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) = holder.bind(dataSet[position], listener)
}