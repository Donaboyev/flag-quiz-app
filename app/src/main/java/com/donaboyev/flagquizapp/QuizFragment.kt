package com.donaboyev.flagquizapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.donaboyev.flagquizapp.databinding.FragmentQuizBinding

class QuizFragment : Fragment(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: List<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var _binding: FragmentQuizBinding? = null
    private val binding
        get() = _binding!!
    private val args: QuizFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        mQuestionList = Util.getRandomQuestions(requireContext())
        setQuestion()
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size) binding.btnSubmit.text = "Finish"
        else binding.btnSubmit.text = "Submit"
        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition" + "/" + binding.progressBar.max
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)
        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.default_option_border_bg
            )
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvOptionOne -> selectedOptionView(binding.tvOptionOne, 1)
            R.id.tvOptionTwo -> selectedOptionView(binding.tvOptionTwo, 2)
            R.id.tvOptionThree -> selectedOptionView(binding.tvOptionThree, 3)
            R.id.tvOptionFour -> selectedOptionView(binding.tvOptionFour, 4)
            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            findNavController().navigate(
                                QuizFragmentDirections.actionQuizFragmentToResultFragment(
                                    args.name,
                                    mQuestionList!!.size,
                                    mCorrectAnswer
                                )
                            )
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) answerView(
                        mSelectedOptionPosition,
                        R.drawable.wrong_option_border_bg
                    )
                    else mCorrectAnswer++
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                }
                if (mCurrentPosition == mQuestionList!!.size) binding.btnSubmit.text = "Finish"
                else binding.btnSubmit.text = "Go to next question"
                mSelectedOptionPosition = 0
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> binding.tvOptionOne.background =
                ContextCompat.getDrawable(requireContext(), drawableView)
            2 -> binding.tvOptionTwo.background =
                ContextCompat.getDrawable(requireContext(), drawableView)
            3 -> binding.tvOptionThree.background =
                ContextCompat.getDrawable(requireContext(), drawableView)
            4 -> binding.tvOptionFour.background =
                ContextCompat.getDrawable(requireContext(), drawableView)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.selected_option_border_bg
        )
    }
}