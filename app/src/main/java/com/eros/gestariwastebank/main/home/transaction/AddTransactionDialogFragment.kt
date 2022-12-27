package com.eros.gestariwastebank.main.home.transaction

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.databinding.FragmentAddTransactionDialogBinding
import com.eros.gestariwastebank.databinding.FragmentHistoryDialogBinding

class AddTransactionDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentAddTransactionDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        binding = FragmentAddTransactionDialogBinding.inflate(LayoutInflater.from(context), null, false)

        val itemName = arguments?.getString("itemName")
        val itemPrice = arguments?.getString("itemPrice")
        val itemImage = arguments?.getString("itemImage")

        binding.tvItemName.text = itemName
        binding.tvItemPrice.text = "Rp $itemPrice/kg"
        Glide.with(binding.root)
            .load(itemImage)
            .into(binding.ivItem)

        binding.ivClose.setOnClickListener {
            dismiss()
        }
        builder.setView(binding.root)
        return builder.create()
    }
}