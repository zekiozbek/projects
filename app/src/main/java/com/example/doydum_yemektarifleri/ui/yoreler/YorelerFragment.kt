package com.example.doydum_yemektarifleri.ui.yoreler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doydum_yemektarifleri.R
/**
 * A simple [Fragment] subclass.
 * Use the [YorelerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class YorelerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yoreler, container, false)
    }

}