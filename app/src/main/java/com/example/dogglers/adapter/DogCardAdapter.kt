package com.example.dogglers.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    private val dataset = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        
        val imageView: ImageView = view!!.findViewById(R.id.image_view_dog)
        val textViewNameDog: TextView = view!!.findViewById(R.id.text_view_name_dog)
        val textViewAgeDog: TextView = view!!.findViewById(R.id.text_view_age_dog)
        val textViewHobbiesDog: TextView = view!!.findViewById(R.id.text_view_hobbies_dog)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        return when(layout){
            GRID -> {
                val adapterLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.grid_list_item, parent, false)
                (DogCardViewHolder(adapterLayout))
            }

            else -> {
                val adapterLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_horizontal_list_item, parent, false)
                (DogCardViewHolder(adapterLayout))
            }
        }
    }

    override fun getItemCount(): Int = dataset.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
       val item = dataset[position]
        val resources = context?.resources
        holder.imageView.setImageResource(item.imageResourceId)
        holder.textViewNameDog.text = item.name
        holder.textViewAgeDog.text = resources!!.getString(R.string.dog_age, item.age)
        holder.textViewHobbiesDog.text = resources!!.getString(R.string.dog_hobbies, item.hobbies)
    }
}
