package com.example.coffeeplus.ui.theme.paymentfragments

import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coffeeplus.databinding.FragmentPaymentBinding


class PaymentFragment : Fragment() {
    private lateinit var binding: FragmentPaymentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaymentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timer(240000)
        cardNumbers()
        cardDate()
    }


    private fun timer(minute: Long) {
        object : CountDownTimer(minute, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                val text = String.format("%02d:%02d", minutes, seconds)
                binding.tvTimer.text = "Qalan vaxt :$text"
            }

            override fun onFinish() {
                binding.tvTimer.text = "00.00"
            }

        }.start()
    }


    private fun cardNumbers() {
        var isUpdating: Boolean = false
        binding.etCard.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isUpdating) return

                val digit = s.toString()
                val text = digit.replace(" ", "")


                val textFormat = StringBuilder()
                for (i in text.indices) {
                    if (i > 0 && i % 4 == 0) {
                        textFormat.append(" ")
                    }

                    textFormat.append(text[i])
                }

                isUpdating = true

                binding.etCard.setText(textFormat)
                binding.etCard.setSelection(textFormat.length)
                isUpdating = false

            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

    }

    private fun cardDate() {
        var isUpdating: Boolean = false
        binding.etYear.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isUpdating) return

                val text = s.toString()
                val year = text.replace("/", "")

                if (year.length <= 2) {
                    isUpdating = false
                    return
                }

                val yearFormat = year.substring(0, 2) + "/" + year.substring(2)
                isUpdating = true
                binding.etYear.setText(yearFormat)
                binding.etYear.setSelection(yearFormat.length)
                isUpdating = false
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }


}