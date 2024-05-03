package net.asgeri.atlactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import net.asgeri.atlactivity.databinding.ItemCardBinding

class NameAdapter() :
    RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    private val list = arrayListOf<User>()

    inner class NameViewHolder(val itemCardBinding: ItemCardBinding) :
        RecyclerView.ViewHolder(itemCardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val user = list[position]

        holder.itemCardBinding.textView6.text = user.name
        holder.itemCardBinding.imageView2.setImageResource(user.image)

        holder.itemCardBinding.cardView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(HomeFragmentDirections.actionHomeFragmentToProfileFragment(user))
        }
    }

     fun updateList(newList: ArrayList<User>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

}