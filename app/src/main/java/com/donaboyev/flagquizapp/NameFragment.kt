package com.donaboyev.flagquizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.donaboyev.flagquizapp.databinding.FragmentNameBinding

class NameFragment : Fragment() {

    private var _binding: FragmentNameBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnStart.setOnClickListener {
            if (binding.etName.text.toString().trim().isEmpty()) {
                Toast.makeText(requireContext(), "Please enter your name", Toast.LENGTH_SHORT)
                    .show()
            } else {
                findNavController().navigate(
                    NameFragmentDirections.actionNameFragmentToQuizFragment(
                        binding.etName.text.toString().trim()
                    )
                )
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}