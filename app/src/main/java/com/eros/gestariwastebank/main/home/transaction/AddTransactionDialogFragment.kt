package com.eros.gestariwastebank.main.home.transaction

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.databinding.FragmentAddTransactionDialogBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.home.transaction.viewmodel.AddTranscationViewModel
import java.text.NumberFormat
import java.util.*

class AddTransactionDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentAddTransactionDialogBinding

    private val viewModel: AddTranscationViewModel by activityViewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(requireContext())
        }
    )

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        binding =
            FragmentAddTransactionDialogBinding.inflate(LayoutInflater.from(context), null, false)

        var quantity = 1
        val itemName = arguments?.getString("itemName")
        val itemPrice = arguments?.getString("itemPrice")
        val itemImage = arguments?.getString("itemImage")
        val itemId = arguments?.getString("itemId")

        binding.tvItemName.text = itemName
        binding.tvItemPrice.text =
            NumberFormat.getNumberInstance(Locale.US).format(itemPrice?.toInt())
        Glide.with(binding.root)
            .load(itemImage)
            .into(binding.ivItem)

        binding.btnPlus.setOnClickListener {
            quantity++
            binding.tvTrashAmount.text = quantity.toString()
        }

        binding.btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                binding.tvTrashAmount.text = quantity.toString()
            } else {
                quantity = 1
                binding.tvTrashAmount.text = quantity.toString()
            }
        }

        binding.btnAddTransaction.setOnClickListener {
            val cart = Cart(
                id = itemId?.toInt(),
                itemName,
                itemImage,
                quantity,
                itemPrice
            )
            viewModel.insertDataCart(
                id = itemId?.toInt()!!,
                itemName!!,
                itemImage!!,
                quantity,
                itemPrice?.toInt()!!
            )
            Toast.makeText(context, "Item berhasil ditambahkan", Toast.LENGTH_SHORT).show()
        }

        binding.ivClose.setOnClickListener {
            dismiss()
        }

        builder.setView(binding.root)
        return builder.create()
    }
}