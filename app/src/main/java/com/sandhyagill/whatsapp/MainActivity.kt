package com.sandhyagill.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sandhyagill.whatsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var fragment = arrayListOf<Fragment>()
    val title = listOf("Chat","Status","Call")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragment.add(ChatFragment())
        fragment.add(StatusFragment())
        fragment.add(CallFragment())
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPager.adapter = TabAdapter(this, fragment)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = title[position]
        }.attach()
    }
}
class TabAdapter(fa: FragmentActivity, var list: List<Fragment>) : FragmentStateAdapter(fa) {
    override fun getItemCount() = list.size

    override
    fun createFragment(position: Int) = list[position]

}