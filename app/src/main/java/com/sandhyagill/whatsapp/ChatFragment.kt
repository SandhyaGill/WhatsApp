package com.sandhyagill.whatsapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandhyagill.whatsapp.databinding.FragmentCallBinding
import com.sandhyagill.whatsapp.databinding.FragmentChatBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentChatBinding

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
        binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chatList : MutableList<Chat> = mutableListOf()
        chatList.add(Chat(R.drawable.user1,"Sandhya","Hello","2:00 AM"))
        chatList.add(Chat(R.drawable.user2,"Tanu","Ajj Clg Jana","3:55 PM"))
        chatList.add(Chat(R.drawable.user3,"Harman","kida","8:09 PM"))
        chatList.add(Chat(R.drawable.user4,"Lovi","Assignment krli","4:56 AM"))
        chatList.add(Chat(R.drawable.user5,"Komal","Hi","7:23 AM"))
        chatList.add(Chat(R.drawable.user6,"Drishti","Hi","7:23 AM"))
        chatList.add(Chat(R.drawable.user7,"Suman","Hi","7:23 AM"))
        binding.recyclerView.adapter = RecyclerChatAdapter(chatList)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}