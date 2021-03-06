package jp.cubenoy22.neumorphism

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import jp.cubenoy22.neumorphism.databinding.FragmentControllerBinding
import jp.cubenoy22.neumorphism.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private val viewModel: ControllerViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentFirstBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@FirstFragment.viewModel
        }
    }
}