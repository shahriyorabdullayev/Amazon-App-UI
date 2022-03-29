package com.example.m5_l6amazonui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l6amazonui.R
import com.example.m5_l6amazonui.model.Essential

class FavoriteAdapter(val context: Context, val items: ArrayList<Essential>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_essential, parent, false)
        return EssentialViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is EssentialViewHolder) {
            holder.apply {
                title.text = item.title
                image.setImageResource(item.image)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class EssentialViewHolder(view:View) :RecyclerView.ViewHolder(view) {

        val title = view.findViewById<TextView>(R.id.tv_title)
        val image = view.findViewById<ImageView>(R.id.iv_image)
    }
}