package com.example.virtualinterviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter(private val resultList: List<Result>) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvInterview: TextView = itemView.findViewById(R.id.tvInterview)
        val tvScore: TextView = itemView.findViewById(R.id.tvScore)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.score_item, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item = resultList[position]
        holder.tvInterview.text = item.interviewName
        holder.tvScore.text = "Score: ${"%.1f".format(item.score)} / 100"
        holder.tvDate.text = android.text.format.DateFormat.format(
            "dd MMM yyyy", item.timestamp
        )
    }

    override fun getItemCount(): Int = resultList.size
}
