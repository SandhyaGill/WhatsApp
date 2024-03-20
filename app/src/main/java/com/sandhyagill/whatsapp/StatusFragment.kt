package com.sandhyagill.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandhyagill.whatsapp.databinding.FragmentStatusBinding
import java.util.zip.Inflater

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StatusFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
var statuslist: MutableList<Status> = mutableListOf(Status(R.drawable.user1,"Komal"),Status(R.drawable.user2,"Suman"),
    Status(R.drawable.user3,"Tanu"),Status(R.drawable.user4,"Drishti"),Status(R.drawable.user5,"Lovi"))
var channellist : MutableList<Channels> = mutableListOf(Channels(R.drawable.user4,"Sandhya","Hello","2:00 AM"))
var findChannellist : MutableList<FindChannel> = mutableListOf(FindChannel(R.drawable.finance,"Finance"),
    FindChannel(R.drawable.news,"News"),FindChannel(R.drawable.game,"Total Gaming"))
class StatusFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentStatusBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStatusBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvStatus.adapter = RecyclerStatusAdapter(statuslist)
        binding.rvStatus.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding?.ivPopUpMenu?.setOnClickListener {
            var popupMenu = PopupMenu(requireContext(), binding.ivPopUpMenu)
            popupMenu.menuInflater.inflate(R.menu.status_nav_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menuStatusPrivacy -> Toast.makeText(requireContext(), "Menu clicked", Toast.LENGTH_SHORT).show()
                    else->{}
                }
                return@setOnMenuItemClickListener true
            }
            popupMenu.show()
        }
        binding.rvChannels.adapter = RecyclerChannelAdpater(channellist)
        binding.rvChannels.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvFindChannels.adapter = RecyclerFindChannelAdapter(findChannellist)
        binding.rvFindChannels.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.status_side_menu, menu)
        return super.onCreateOptionsMenu(menu,inflater)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StatusFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StatusFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}