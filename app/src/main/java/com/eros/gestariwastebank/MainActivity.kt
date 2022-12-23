package com.eros.gestariwastebank

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eros.gestariwastebank.data.Util
import com.eros.gestariwastebank.databinding.ActivityMainBinding
import com.eros.gestariwastebank.main.home.tambahsampah.AdapterCategory
import com.eros.gestariwastebank.main.home.tambahsampah.AdapterItem
import com.eros.gestariwastebank.main.home.tambahsampah.AdapterSchedule
import com.eros.gestariwastebank.main.home.transaction.TransactionActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.botNavBar

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)
        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, TransactionActivity::class.java))
        }
    }

    private fun showDialogCategory() {
        val dialog = BottomSheetDialog(this, R.style.MyTransparentDialog)
        val view = layoutInflater.inflate(R.layout.pop_up_category, null)
        val rvCategory = view.findViewById<RecyclerView>(R.id.rvCategory)
        val adapter = AdapterCategory {
            dialog.dismiss()
            showDialogItem()
        }
        rvCategory.layoutManager = LinearLayoutManager(this)
        rvCategory.adapter = adapter
        adapter.addCategory(generateDummyCategory())
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.show()
    }
    private fun showDialogAdd() {
        val dialog = BottomSheetDialog(this, R.style.MyTransparentDialog)
        val view = layoutInflater.inflate(R.layout.pop_up_add, null)
        val tvAdd = view.findViewById<TextView>(R.id.tvAddTrash)
        tvAdd.setOnClickListener {
            dialog.dismiss()
            showDialogCategory()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.show()
    }

    private fun showDialogItem() {
        val dialog = BottomSheetDialog(this, R.style.MyTransparentDialog)
        val view = layoutInflater.inflate(R.layout.pop_up_dialog_item, null)
        val rvCategory = view.findViewById<RecyclerView>(R.id.rvItem)
        val ivPrevious = view.findViewById<ImageView>(R.id.ivPrevious)
        val ivNext = view.findViewById<ImageView>(R.id.ivNext)
        val adapter = AdapterItem()
        ivPrevious.setOnClickListener {
            dialog.dismiss()
            showDialogCategory()
        }
        ivNext.setOnClickListener {
            dialog.dismiss()
            showDialogSchedule()
        }
        rvCategory.layoutManager = LinearLayoutManager(this)
        rvCategory.adapter = adapter
        adapter.addItem(Util.allItem)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.show()
    }

    private fun showDialogSchedule() {
        val dialog = BottomSheetDialog(this, R.style.MyTransparentDialog)
        val view = layoutInflater.inflate(R.layout.pop_up_dialog_schedule, null)
        val rvCategory = view.findViewById<RecyclerView>(R.id.rvItem)
        val ivNext = view.findViewById<ImageView>(R.id.ivNext)
        val tvConfirm = view.findViewById<TextView>(R.id.tvConfirm)
        val adapter = AdapterSchedule { positionSelected ->
            if (positionSelected >= 0) {
                ivNext.visibility = View.GONE
                tvConfirm.visibility = View.VISIBLE
            } else {
                ivNext.visibility = View.VISIBLE
                tvConfirm.visibility = View.GONE
            }
        }
        tvConfirm.setOnClickListener {
            dialog.dismiss()
            showDialogOrderConfirmed()
        }
        rvCategory.layoutManager = LinearLayoutManager(this)
        rvCategory.adapter = adapter
        adapter.addSchedule(generateDummySchedule())
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.show()
    }
    private fun showDialogOrderConfirmed() {
        val dialog = BottomSheetDialog(this, R.style.MyTransparentDialog)
        val view = layoutInflater.inflate(R.layout.pop_up_order_confirmed, null)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.show()
    }

    private fun generateDummyCategory(): ArrayList<String> {
        val data = ArrayList<String>()
        data.add("Plastik")
        data.add("Kertas")
        data.add("Kaca")
        data.add("Logam")
        data.add("Organik")
        return data
    }

    private fun generateDummySchedule(): ArrayList<String> {
        val data = ArrayList<String>()
        data.add("08:00 - 10:00")
        data.add("10:00 - 11:00")
        data.add("11:00 - 12:00")
        data.add("13:00 - 14:00")
        data.add("14:00 - 15:00")
        data.add("15:00 - 16:00")
        return data
    }
}