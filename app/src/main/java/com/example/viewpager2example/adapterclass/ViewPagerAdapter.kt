package com.example.viewpager2example.adapterclass

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewpager2example.R
import com.example.viewpager2example.databinding.ViewpageriteamlayoutBinding
import com.example.viewpager2example.modelclass.Mylistmodel

class ViewPagerAdapter(var context: Context,var mylist: ArrayList<Mylistmodel>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewpageriteamlayoutBinding):RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myview= ViewpageriteamlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(myview)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.singleviewlist.setText(mylist[position].name)

        Glide.with(holder.binding.imageview)
            .load(mylist[position].image)
            .placeholder(R.drawable.ic_launcher_background).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
      return mylist.size
    }
}
