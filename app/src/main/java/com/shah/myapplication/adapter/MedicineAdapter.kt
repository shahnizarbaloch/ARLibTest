package com.shah.myapplication.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.shah.myapplication.R
import com.shah.myapplication.model.MedicationItem

class MedicineAdapter(
    private val context: Context,
    private val medicineList: List<MedicationItem>,
    private val onMyOwnClickListener: OnMyOwnClickListener
) : RecyclerView.Adapter<MedicineAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        @SuppressLint("InflateParams") val view =
            inflater.inflate(R.layout.design_medication, null, false)
        return MyViewHolder(view, onMyOwnClickListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val obj = medicineList[position]
        holder.tvName.text = obj.name
        holder.tvDose.text = obj.dose
        holder.tvStrength.text = obj.strength
    }

    override fun getItemCount(): Int {
        return medicineList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class MyViewHolder(itemView: View, var onMyOwnClickListener: OnMyOwnClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var tvName: TextView
        var tvDose: TextView
        var tvStrength: TextView

        override fun onClick(view: View) {
            onMyOwnClickListener.onMyOwnClick(adapterPosition)
        }

        init {
            tvName = itemView.findViewById(R.id.tv_medicine_name)
            tvDose = itemView.findViewById(R.id.tv_medicine_dose)
            tvStrength = itemView.findViewById(R.id.tv_medicine_strength)
            itemView.setOnClickListener(this)
        }
    }

    interface OnMyOwnClickListener {
        fun onMyOwnClick(position: Int)
    }
}