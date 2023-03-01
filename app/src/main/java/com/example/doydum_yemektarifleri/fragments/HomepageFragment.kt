package com.example.doydum_yemektarifleri.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.animation.core.snap
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.doydum_yemektarifleri.R
import com.example.doydum_yemektarifleri.adapters.HomepageAdapter
import com.example.doydum_yemektarifleri.databinding.FragmentHomepageBinding
import com.example.doydum_yemektarifleri.models.HomepageModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_homepage.*


class HomepageFragment : Fragment() {

    private lateinit var database:  FirebaseFirestore
    private lateinit var rvAdapter: HomepageAdapter
    private lateinit var postList: ArrayList<HomepageModel>
    private lateinit var binding: FragmentHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(layoutInflater)
        val view = binding.root

        postList = ArrayList()
        database = FirebaseFirestore.getInstance()

        getData()

        binding.rvHomepage.setHasFixedSize(true)
        binding.rvHomepage.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        rvAdapter = HomepageAdapter(postList)
        binding.rvHomepage.adapter = rvAdapter

        return view
    }

    fun getData() {

        database.collection("Mutfaklar").addSnapshotListener { snapshot, error ->

            if (snapshot!=null){
                if (!snapshot.isEmpty){
                    val documents = snapshot.documents

                    postList.clear()

                    for (document in documents){
                        val mutfak = document.get("mutfak") as String
                        val resim = document.get("resim") as String

                        val indirilenPost = HomepageModel(mutfak,resim)
                        postList.add(indirilenPost)

                    }

                    rvAdapter.notifyDataSetChanged()
                }
            }

        }





    }
}