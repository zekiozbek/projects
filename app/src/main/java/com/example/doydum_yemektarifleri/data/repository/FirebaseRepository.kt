package com.example.doydum_yemektarifleri.data.repository

import com.example.doydum_yemektarifleri.common.Constants
import com.example.doydum_yemektarifleri.domain.model.KitchenDomain
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

/**
 * Created by Barış Keser on 2.03.2023.
 */
class FirebaseRepository {

    private val fireStore = FirebaseFirestore.getInstance()

    suspend fun getKitchen(): Flow<List<KitchenDomain>> = flow {
        val data = fireStore.collection(Constants.KITCHEN_COLLECTION).get().await()
        val list: MutableList<KitchenDomain> = mutableListOf()
        data.documents.forEach { document ->
            list.add(
                KitchenDomain(
                    mutfak = document.getString("mutfak"),
                    resim = document.getString("resim")
                )
            )
        }
        emit(list)
    }

    /* suspend fun getKitchen(): ArrayList<KitchenDomain>? {
        var kitchenList: Deferred<ArrayList<KitchenDomain>>? = null

        fireStore.collection(Constants.KITCHEN_COLLECTION).get().addOnSuccessListener {
            val list: MutableList<KitchenDomain> =
                emptyList<KitchenDomain>() as MutableList<KitchenDomain>
            it.documents.forEach { document ->
                list.add(
                    KitchenDomain(
                        mutfak = document.getString("mutfak"),
                        resim = document.getString("resim")
                    )
                )
            }

            CoroutineScope(Dispatchers.IO).launch {
                kitchenList = async { list } as Deferred<ArrayList<KitchenDomain>>
            }

        }


        return kitchenList?.await()
    } */

}