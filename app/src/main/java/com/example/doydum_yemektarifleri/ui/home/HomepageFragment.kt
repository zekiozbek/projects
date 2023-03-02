package com.example.doydum_yemektarifleri.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.doydum_yemektarifleri.databinding.FragmentHomepageBinding
import com.example.doydum_yemektarifleri.domain.model.KitchenDomain
import com.google.firebase.firestore.FirebaseFirestore


class HomepageFragment : Fragment() {

    private lateinit var database: FirebaseFirestore
    private lateinit var rvAdapter: HomepageAdapter
    private lateinit var postList: ArrayList<KitchenDomain>
    private lateinit var binding: FragmentHomepageBinding

    private val viewModel = HomeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomepageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postList = ArrayList()
        database = FirebaseFirestore.getInstance()


        binding.rvHomepage.setHasFixedSize(true)
        binding.rvHomepage.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        viewModel.getKitchens()

        rvAdapter = HomepageAdapter(postList)
        binding.rvHomepage.adapter = rvAdapter

        viewModel.kitchenLiveData.observe(viewLifecycleOwner, kitchenObserver)
    }

    private val kitchenObserver = Observer<List<KitchenDomain>> { list ->
        postList.clear()
        postList.addAll(list)
        rvAdapter.notifyDataSetChanged()
    }
}