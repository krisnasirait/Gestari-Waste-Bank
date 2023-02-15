package com.eros.gestariwastebank.main.wallet

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.eros.gestariwastebank.databinding.FragmentHistoryDialogBinding


class HistoryDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentHistoryDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val binding = FragmentHistoryDialogBinding.bind(requireView())

        val status = arguments?.getString("status")
        val date = arguments?.getString("date")
        val amount = arguments?.getString("amount")

        binding.tvTitle.text = "Detail $status"
        binding.tvDate.text = date
        binding.tvAmount.text = "Rp $amount,-"
        if(status == "Penarikan") {
            binding.tvAmount.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark))
        } else {
            binding.tvAmount.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_green_dark))
        }

        binding.ivClose.setOnClickListener {
            dismiss()
        }
        return builder.setView(binding.root).create()
    }


}