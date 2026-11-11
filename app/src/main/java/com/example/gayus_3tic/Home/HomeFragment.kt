package com.example.gayus_3tic.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.gayus_3tic.Home.pertemuan11.TenthActivity
import com.example.gayus_3tic.Home.pertemuan6.EnamActivity
import com.example.gayus_3tic.Home.pertemuan9.NinthActivity
import com.example.gayus_3tic.Home.pertemuan_5.LimaActivity
import com.example.gayus_3tic.LoginActivity
import com.example.gayus_3tic.databinding.FragmentHomeeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val user = sharedPref.getString("user", "Gayus")

        binding.tvHasil.text = "Nama: $user\nUmur: 25"

        binding.btnKembali.setOnClickListener {
            requireActivity().finish()
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        binding.btntoLima.setOnClickListener {
            val intent = Intent(requireContext(), LimaActivity::class.java)
            startActivity(intent)
        }

        binding.btntoEnam.setOnClickListener {
            val intent = Intent(requireContext(), EnamActivity::class.java)
            startActivity(intent)
        }

        binding.btntoNinth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }
        binding.btnTenth.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup") {
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                    Log.e("Info Snackbar", "Snackbar ditutup")
                }
                .show()
        }

        binding.btnDialog.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
