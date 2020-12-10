package jp.cubenoy22.neumorphism

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.cubenoy22.neumorphism.databinding.ItemPerformanceBinding

class PerformanceViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_performance, parent, false)
) {
    val binding = ItemPerformanceBinding.bind(itemView)
}