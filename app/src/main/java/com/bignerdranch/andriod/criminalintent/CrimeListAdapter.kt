package com.bignerdranch.andriod.criminalintent

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.andriod.criminalintent.databinding.ListItemCrimeBinding
import java.util.Locale

class CrimeHolder(
   private val binding:ListItemCrimeBinding
): RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime) {
            binding.crimeTitle.text = crime.title
            val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
            val formattedDate = dateFormat.format(crime.date)
            binding.crimeDate.text = formattedDate

            binding.root.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "${crime.title} clicked!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            binding.crimeSolved.visibility = if(crime.isSolved) {
                View.VISIBLE
            }else {
                View.GONE
            }
}


class CrimeListAdapter(
    private val crimes:List<Crime>

):RecyclerView.Adapter<CrimeHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun getItemCount() = crimes.size



    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {

        val crime = crimes[position]
      /*  holder.apply {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
        } */

        holder.bind(crime)
    }
}
}