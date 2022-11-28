package com.bam.viewmodelexample.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bam.viewmodelexample.R
import com.bam.viewmodelexample.databinding.FragmentEditBinding
import com.bam.viewmodelexample.list.ListFragmentViewModel
import com.bam.viewmodelexample.room.UserData


class EditFragment : Fragment() {

    lateinit var binding: FragmentEditBinding
    lateinit var viewModel: ListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater)

        viewModel = ViewModelProvider(requireActivity())[ListFragmentViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val name = binding.name.text.toString()
            val age = binding.age.text.toString()

            val user = UserData(name = name, age = age.toInt())
            viewModel.insert(user)
            Navigation.findNavController(it).navigate(R.id.action_editFragment_to_listFragment)
        }

    }


}