package com.example.viewpager2example

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2example.adapterclass.ViewPagerAdapter
import com.example.viewpager2example.databinding.ActivityMainBinding
import com.example.viewpager2example.modelclass.Mylistmodel
import com.example.viewpager2example.transformationClass.DepthPageTransformer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var mylist = ArrayList<Mylistmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        pagartwoview()
    }

    private fun pagartwoview() {
        binding.apply {

            for (i in 0 until 50) {
                mylist.add(Mylistmodel("Title: $i"))
            }

            pager.adapter = ViewPagerAdapter(this@MainActivity, mylist)
            pager.setPageTransformer(DepthPageTransformer())

            pager.orientation = ViewPager2.ORIENTATION_VERTICAL
            pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Toast.makeText(this@MainActivity, "Title :$position", Toast.LENGTH_SHORT).show()
                }

                override fun onPageScrollStateChanged(state: Int) {

                    super.onPageScrollStateChanged(state)
                }
            })
        }
    }
}