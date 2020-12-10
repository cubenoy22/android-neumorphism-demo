package jp.cubenoy22.neumorphism

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import jp.cubenoy22.neumorphism.databinding.FragmentControllerBinding

class ControllerFragment : Fragment(R.layout.fragment_controller) {

    private val viewModel: ControllerViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.addOnLayoutChangeListener { _, left, _, right, _, _, _, _, _ ->
            viewModel.maxSize.value = right - left
        }
        FragmentControllerBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@ControllerFragment.viewModel
        }
    }
}