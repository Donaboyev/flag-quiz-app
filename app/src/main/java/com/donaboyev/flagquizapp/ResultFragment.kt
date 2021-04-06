package com.donaboyev.flagquizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.donaboyev.flagquizapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding
        get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)

        binding.tvName.text = args.name
        binding.tvScore.text = "Your score is ${args.correctAnswers} out of ${args.totalQuestions}"

        binding.btnFinish.setOnClickListener {
            findNavController().navigate(ResultFragmentDirections.actionResultFragmentToNameFragment())
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}