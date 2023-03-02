package com.example.doydum_yemektarifleri.ui.species

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doydum_yemektarifleri.R

/**
 * A simple [Fragment] subclass.
 * Use the [SpeciesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpeciesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_species, container, false)
    }
}