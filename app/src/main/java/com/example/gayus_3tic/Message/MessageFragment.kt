package com.example.gayus_3tic.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.gayus_3tic.R
import com.example.gayus_3tic.databinding.FragmentMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://reqres.in/img/faces/1-image.jpg"),
        MessageModel("Budi", "Sudah makan?", "https://reqres.in/img/faces/2-image.jpg"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://reqres.in/img/faces/3-image.jpg"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://reqres.in/img/faces/4-image.jpg"),
        MessageModel("Eka", "Nice job kemarin!", "https://reqres.in/img/faces/5-image.jpg"),
        MessageModel("Fajar", "Lagi ngapain?", "https://reqres.in/img/faces/6-image.jpg"),
        MessageModel("Gita", "Boleh minta tolong?", "https://reqres.in/img/faces/7-image.jpg"),
        MessageModel("Hana", "Lihat email ya", "https://reqres.in/img/faces/8-image.jpg"),
        MessageModel("Irfan", "Oke noted", "https://reqres.in/img/faces/9-image.jpg"),
        MessageModel("Joko", "Sampai jumpa besok", "https://reqres.in/img/faces/10-image.jpg")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Message"

        // Option menu di Toolbar: tombol Info membuka tutorial
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.message_toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_tutorial -> {
                        startActivity(Intent(requireContext(), TutorialMessageActivity::class.java))
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.ListMesageItems.adapter = adapter

        binding.ListMesageItems.setOnItemClickListener { _, _, position, _ ->
            val message = messageList[position]
            Snackbar.make(
                binding.root,
                "Pesan dari ${message.senderName}: ${message.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
