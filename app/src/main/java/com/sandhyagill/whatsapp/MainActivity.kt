package com.sandhyagill.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sandhyagill.whatsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var fragment = arrayListOf<Fragment>()
    val title = listOf(R.drawable.community,"Chat","Status","Call")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragment.add(CommunityFragment())
        fragment.add(ChatFragment())
        fragment.add(StatusFragment())
        fragment.add(CallFragment())
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPager.adapter = TabAdapter(this, fragment)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = title[position].toString()
        }.attach()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.side_menu, menu)
          return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuSettings-> Toast.makeText(this,"This is settings", Toast.LENGTH_SHORT).show()
            R.id.menuPayments-> Toast.makeText(this,"This is payments", Toast.LENGTH_SHORT).show()
            R.id.menuStarredMessages-> Toast.makeText(this,"This is starred msg", Toast.LENGTH_SHORT).show()
            R.id.menuLinkedDevices-> Toast.makeText(this,"This is linked devices", Toast.LENGTH_SHORT).show()
            R.id.menuNewBroadcast-> Toast.makeText(this,"This is new broadcast", Toast.LENGTH_SHORT).show()
            R.id.menuNewGroup-> Toast.makeText(this,"This is new group", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
class TabAdapter(fa: FragmentActivity, var list: List<Fragment>) : FragmentStateAdapter(fa) {
    override fun getItemCount() = list.size

    override
    fun createFragment(position: Int) = list[position]

}