package com.go.paydo.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.go.paydo.R
import com.go.paydo.entities.Operation

class OperationsAdapter(context : Context) : RecyclerView.Adapter<OperationsAdapter.OperationViewHolder>()  {


    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private val operations = emptyList<Operation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationViewHolder {
        val itemView = inflater.inflate(R.layout.rv_item, parent, false)
        return OperationViewHolder(itemView)
    }

    override fun getItemCount(): Int = operations.size

    override fun onBindViewHolder(holder: OperationViewHolder, position: Int) {
        val current = operations[position]
        holder.itemView.text = current.amount

    }

    /**
     * TODO(14): Create an adapter that works with a RecyclerView
     */

    inner class OperationViewHolder (view : View) : RecyclerView.ViewHolder(view){
        val itemView : TextView = view.findViewById(R.id.operation_item)
    }
}