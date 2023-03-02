package com.example.doydum_yemektarifleri.ui.favs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doydum_yemektarifleri.R

/**
 * A simple [Fragment] subclass.
 * Use the [FavsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favs, container, false)
    }
}