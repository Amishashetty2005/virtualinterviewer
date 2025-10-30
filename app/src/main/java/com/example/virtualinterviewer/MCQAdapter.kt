package com.example.virtualinterviewer

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.virtualinterviewer.data.MCQQuestion
import com.example.virtualinterviewer.databinding.ItemMcqBinding

class MCQAdapter(private val questions: List<MCQQuestion>) :
    RecyclerView.Adapter<MCQAdapter.MCQViewHolder>() {

    private val selections = mutableMapOf<Int, String>()

    inner class MCQViewHolder(val binding: ItemMcqBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MCQViewHolder {
        val binding = ItemMcqBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MCQViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MCQViewHolder, position: Int) {
        val q = questions[position]
        holder.binding.tvQuestion.text = q.question

        holder.binding.rgOptions.removeAllViews()
        for (opt in q.options) {
            val rb = RadioButton(holder.binding.root.context).apply { text = opt }
            holder.binding.rgOptions.addView(rb)
        }

        // restore previous
        val prev = selections[position]
        if (prev != null) {
            for (i in 0 until holder.binding.rgOptions.childCount) {
                val child = holder.binding.rgOptions.getChildAt(i) as RadioButton
                if (child.text == prev) child.isChecked = true
            }
        }

        holder.binding.rgOptions.setOnCheckedChangeListener { _, checkedId ->
            val rb = holder.binding.rgOptions.findViewById<RadioButton>(checkedId)
            if (rb != null) selections[position] = rb.text.toString()
        }
    }

    override fun getItemCount(): Int = questions.size

    fun getSelections(): Map<Int, String> = selections.toMap()
}
