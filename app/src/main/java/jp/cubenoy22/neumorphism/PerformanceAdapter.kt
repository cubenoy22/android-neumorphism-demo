package jp.cubenoy22.neumorphism

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PerformanceAdapter : RecyclerView.Adapter<PerformanceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerformanceViewHolder {
        return PerformanceViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PerformanceViewHolder, position: Int) {
        holder.binding.index = position
    }

    override fun getItemCount(): Int {
        return 100
    }
}

