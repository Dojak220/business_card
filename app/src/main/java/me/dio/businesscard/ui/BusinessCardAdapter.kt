package me.dio.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.dio.businesscard.data.BusinessCard
import me.dio.businesscard.databinding.BusinessCardItemBinding


class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BusinessCardItemBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    inner class ViewHolder(private val binding: BusinessCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BusinessCard) {
            binding.tvName.text = item.name
            binding.tvCompanyName.text = item.company
            binding.tvPhone.text = item.phone
            binding.tvEmail.text = item.email
            binding.cvBusinessCard.setCardBackgroundColor(Color.parseColor(item.backgroundColor))

            binding.cvBusinessCard.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}
