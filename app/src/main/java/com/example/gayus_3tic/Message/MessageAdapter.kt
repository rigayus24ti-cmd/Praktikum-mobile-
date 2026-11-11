package com.example.gayus_3tic.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.gayus_3tic.R

class MessageAdapter(
    private val context: Context,
    private val messageList: List<MessageModel>
) : BaseAdapter() {

    override fun getCount(): Int = messageList.size

    override fun getItem(position: Int): Any = messageList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_message, parent, false)

        val avatarImg = view.findViewById<ImageView>(R.id.avatarImg)
        val textSender = view.findViewById<TextView>(R.id.textSender)
        val textMessage = view.findViewById<TextView>(R.id.textMessage)

        val item = messageList[position]
        textSender.text = item.senderName
        textMessage.text = item.messageText

        Glide.with(context)
            .load(item.avatarUrl)
            .placeholder(R.drawable.user)
            .error(R.drawable.user)
            .circleCrop()
            .into(avatarImg)

        return view
    }
}
