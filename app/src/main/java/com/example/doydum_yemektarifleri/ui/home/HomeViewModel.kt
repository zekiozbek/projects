package com.example.doydum_yemektarifleri.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doydum_yemektarifleri.common.Constants
import com.example.doydum_yemektarifleri.data.repository.FirebaseRepository
import com.example.doydum_yemektarifleri.domain.model.KitchenDomain
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * Created by Barış Keser on 2.03.2023.
 */
class HomeViewModel : ViewModel() {

    private val _kitchenLiveData = MutableLiveData<List<KitchenDomain>>()
    val kitchenLiveData: LiveData<List<KitchenDomain>> = _kitchenLiveData

    private val firebaseRepository = FirebaseRepository()

    fun getKitchens() {
        viewModelScope.launch {
            firebaseRepository.getKitchen().onEach {
                _kitchenLiveData.value = it
            }.launchIn(viewModelScope)
        }
    }


    /*fun getKitchens() {
        fireStore.collection(Constants.KITCHEN_COLLECTION).get()
            .addOnSuccessListener {
                val list: MutableList<KitchenDomain> = emptyList<KitchenDomain>() as MutableList<KitchenDomain>
                it.documents.forEach { document ->
                    list.add(
                        KitchenDomain(
                            mutfak = document.getString("mutfak"),
                            resim = document.getString("resim")
                        )
                    )
                }
                _kitchenLiveData.value = list
            }.addOnFailureListener {

            }
    }*/


}