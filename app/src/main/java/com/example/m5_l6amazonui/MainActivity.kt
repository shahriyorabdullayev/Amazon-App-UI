package com.example.m5_l6amazonui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentOnAttachListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l6amazonui.adapter.FavoriteAdapter
import com.example.m5_l6amazonui.model.Essential

class MainActivity : AppCompatActivity() {

    private lateinit var rvEssential: RecyclerView
    private lateinit var llFashion:LinearLayout
    private lateinit var llPopular:LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        llFashion = findViewById(R.id.ll_fashion)
        llPopular = findViewById(R.id.ll_camera)

        rvEssential = findViewById(R.id.rv_essential)
        rvEssential.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        refreshAdapter(getEssential())

        setLinearHeight(llFashion)
        setLinearHeight(llPopular)


//        holder.oldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }

    private fun refreshAdapter(essentials: ArrayList<Essential>) {
        val adapter = FavoriteAdapter(this, essentials)
        rvEssential.adapter = adapter

    }

    private fun getEssential(): ArrayList<Essential> {
        val list = ArrayList<Essential>()
        for (i in 0..20){
            list.add(Essential("Oculus", R.drawable.im_oculus))
            list.add(Essential("Gamer", R.drawable.im_gamer))
            list.add(Essential("Mobile", R.drawable.im_mobile))
        }
        return list
    }

    private fun setLinearHeight(layout: LinearLayout) {
        //Get screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightPixels = displayMetrics.heightPixels

        //Change pixel to dp
        val heightInDp:Int = heightPixels/resources.displayMetrics.density.toInt()

        //Set layout width programmatically

        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = heightInDp
        layout.layoutParams = params

    }
}