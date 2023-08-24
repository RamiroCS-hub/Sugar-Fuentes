package com.sugarcoach.ui.treatment.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sugarcoach.R
import java.util.*
import kotlin.collections.ArrayList

class TreatmentAdapter(private val activity: TreatmentActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: MutableList<HorarioItem> = Collections.emptyList()
    private var items: ArrayList<String> = ArrayList()
    lateinit var holder: TreatmentHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(activity)
        var holder = TreatmentHolder(inflater.inflate(R.layout.treatment_item, parent, false))
        this.holder = holder
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[holder.adapterPosition]
        bind(holder as TreatmentHolder, item)
    }


    override fun getItemCount(): Int {
        return itemList.size
    }


    fun setData(itemList: List<HorarioItem>, items: ArrayList<String>) {
        this.itemList = itemList.toMutableList()
        this.items = items
        notifyDataSetChanged()
    }


    fun edit(position: Int, item: HorarioItem) {
        itemList[position] = item
        notifyItemChanged(position)
    }

    fun  getItem(position: Int): HorarioItem {
        return itemList[position]
    }

    private fun bind(holder: TreatmentHolder, item: HorarioItem) {
        holder.inflateData(item,holder.adapterPosition, activity, items)
    }

}