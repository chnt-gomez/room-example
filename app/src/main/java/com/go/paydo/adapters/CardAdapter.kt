package com.go.paydo.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.go.paydo.R
import com.go.paydo.entities.Card

class CardAdapter (context : Context) : RecyclerView.Adapter<CardAdapter.ViewHolder>(){

    private var items = emptyList<Card>()
    private val layoutInflater = LayoutInflater.from(context)

    override fun getItemCount()  = items.size

    class ViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)

    /**
     * Inflates the Item view (Each)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Define a view
        val textView = layoutInflater.inflate(
            R.layout.card_text, parent, false) as TextView
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].cardName
    }

    fun setItems(items : List<Card>){
        this.items = items
        notifyDataSetChanged()
    }


}