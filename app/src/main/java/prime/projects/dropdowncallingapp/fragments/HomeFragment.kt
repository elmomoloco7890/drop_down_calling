package prime.projects.dropdowncallingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import prime.projects.dropdowncallingapp.R
import prime.projects.dropdowncallingapp.data.Color
import prime.projects.dropdowncallingapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private var binding: FragmentHomeBinding ?= null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = homeBinding
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            homeFragment = this@HomeFragment
        }
    }

    fun goToSpinner(){
        findNavController().navigate(R.id.action_homeFragment_to_dropDownFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }




}