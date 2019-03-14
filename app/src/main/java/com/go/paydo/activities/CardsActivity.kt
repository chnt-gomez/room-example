package com.go.paydo.activities

import android.app.AlertDialog
import android.app.Dialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.EditText
import com.go.paydo.R
import com.go.paydo.adapters.CardAdapter
import com.go.paydo.daos.CardDAO_Impl
import com.go.paydo.entities.Card
import com.go.paydo.repositories.CardRepo
import com.go.paydo.viewmodel.CardViewModel
import kotlinx.android.synthetic.main.activity_cards.*

class CardsActivity() : AppCompatActivity() {

    lateinit var cardViewModel : CardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            newCardDialog(this@CardsActivity, cardViewModel).show()
        }

        cardViewModel = ViewModelProviders.of(this).get(CardViewModel::class.java)
        var cardAdapter = CardAdapter(applicationContext)

        cardViewModel.allCards?.observe(this, Observer {cards ->
            cards?.let{
                cardAdapter.setItems(cards)
            }

        })


        var viewManager = LinearLayoutManager(this)

        var recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = cardAdapter
        }
    }

    companion object {
        private fun newCardDialog(activity : AppCompatActivity, cardViewModel : CardViewModel ): Dialog{

            val builder = AlertDialog.Builder(activity)
            val inflater = activity.layoutInflater

            val view = inflater.inflate(R.layout.dialog_new_card, null)

            builder.setView(view)
                .setPositiveButton("Create", DialogInterface.OnClickListener{dialog, id ->
                    val edtCard = view.findViewById<EditText>(R.id.edt_card)
                    val cardName = edtCard.text.toString()
                    cardViewModel.insertCard(Card(null, cardName))

                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener{dialog, id ->
                })
            return builder.create()
        }
    }
}
