package com.sandhyagill.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sandhyagill.whatsapp.databinding.FragmentCommunityBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommunityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
val communityList : MutableList<Community> = mutableListOf(Community(R.drawable.user1,"Sandhya","Hello","2:00 AM"),
    Community(R.drawable.user2,"Tanu","Ajj Clg Jana","3:55 PM"),
    Community(R.drawable.user3,"Harman","kida","8:09 PM"),
    Community(R.drawable.user4,"Lovi","Assignment krli","4:56 AM"),
    Community(R.drawable.user5,"Komal","Hi","7:23 AM"),
    Community(R.drawable.user6,"Drishti","Hi","7:23 AM"),
    Community(R.drawable.user7,"Suman","Hi","7:23 AM"))

class CommunityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentCommunityBinding

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
        binding = FragmentCommunityBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CommunityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommunityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}