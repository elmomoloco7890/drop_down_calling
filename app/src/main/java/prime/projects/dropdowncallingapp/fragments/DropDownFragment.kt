package prime.projects.dropdowncallingapp.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import prime.projects.dropdowncallingapp.data.Color
import prime.projects.dropdowncallingapp.R
import prime.projects.dropdowncallingapp.databinding.FragmentDropDownBinding
import prime.projects.dropdowncallingapp.model.DropDownViewModel


class DropDownFragment : Fragment(),
    AdapterView.OnItemSelectedListener {


    private var binding: FragmentDropDownBinding ?= null

    private lateinit var color: Color

    private lateinit var colorArray: Array<String>

    private lateinit var adapter: ArrayAdapter<String>

    private val sharedVM: DropDownViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val dropDownBinding = FragmentDropDownBinding.inflate(inflater, container, false)
        binding = dropDownBinding
        return dropDownBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorArray = arrayOf("Red","Green","Blue")
        adapter = ArrayAdapter(requireContext(), R.layout.new_drop_list_item, colorArray)
        color = Color()
        binding?.apply {
            dropDownFragment = this@DropDownFragment
            colors = color
        }

        binding?.primeSpinner?.adapter = adapter
        binding?.primeSpinner?.onItemSelectedListener = this

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


    fun displayResult(){
        binding?.displayData?.text = color.label
        //findNavController().navigate(R.id.action_dropDownFragment_to_homeFragment)
    }



    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        when(position){
            0 -> color.label = "Red"
            1 -> color.label = "Green"
            2 -> color.label = "Blue"
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        sharedVM.makeShortToasts(requireActivity(), "Please make a selection")
    }


}