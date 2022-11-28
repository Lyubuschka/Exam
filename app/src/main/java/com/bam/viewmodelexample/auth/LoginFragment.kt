package com.bam.viewmodelexample.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bam.viewmodelexample.R
import com.bam.viewmodelexample.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        viewModel.isAuth.observe(viewLifecycleOwner){
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_listFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            val email = binding.editTextTextPersonName.text.toString()
            val pass = binding.editTextTextPassword.text.toString()
            viewModel.login(email, pass);
        }
    }

}