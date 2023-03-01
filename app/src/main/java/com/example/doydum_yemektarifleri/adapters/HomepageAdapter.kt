package com.example.doydum_yemektarifleri.adapters




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.doydum_yemektarifleri.R
import com.example.doydum_yemektarifleri.models.HomepageModel


class HomepageAdapter(private val postList: ArrayList<HomepageModel>) :
    RecyclerView.Adapter<HomepageAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardview: CardView
        val textViewFood: TextView
        val imageViewFood: ImageView

        init {
            // Define click listener for the ViewHolder's View
            cardview = view.findViewById(R.id.cardview)
            textViewFood = view.findViewById(R.id.textViewFood)
            imageViewFood = view.findViewById(R.id.imageViewFood)
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardview_products, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val data = postList.get(position)
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textViewFood.text = data.mutfak

        viewHolder.cardview.setOnClickListener{
            it.findNavController().navigate(R.id.action_homepageFragment_to_speciesFragment)

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = postList.size

}
