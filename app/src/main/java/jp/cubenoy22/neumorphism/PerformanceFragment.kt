package jp.cubenoy22.neumorphism

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import jp.cubenoy22.neumorphism.databinding.FragmentPerformanceBinding

class PerformanceFragment : Fragment(R.layout.fragment_performance) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentPerformanceBinding.bind(view).apply {
            recycler.layoutManager = GridLayoutManager(requireContext(), 4)
            recycler.adapter = PerformanceAdapter()
        }
    }
}