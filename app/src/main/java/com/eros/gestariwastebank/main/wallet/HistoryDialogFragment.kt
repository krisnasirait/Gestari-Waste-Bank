package com.eros.gestariwastebank.main.wallet

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.eros.gestariwastebank.databinding.FragmentHistoryDialogBinding


class HistoryDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentHistoryDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        binding = FragmentHistoryDialogBinding.inflate(LayoutInflater.from(context), null, false)

        val status = arguments?.getString("status")
        val date = arguments?.getString("date")
        val amount = arguments?.getString("amount")

        binding.tvTitle.text = "Detail $status"
        binding.tvDate.text = date
        binding.tvAmount.text = "Rp $amount,-"
        if(status == "Penarikan") {
            binding.tvAmount.setTextColor(resources.getColor(android.R.color.holo_red_dark))
        } else {
            binding.tvAmount.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        }

        binding.ivClose.setOnClickListener {
            dismiss()
        }
        builder.setView(binding.root)
        return builder.create()
    }


}