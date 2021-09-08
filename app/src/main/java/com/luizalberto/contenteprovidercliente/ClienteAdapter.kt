package com.luizalberto.contenteprovidercliente

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClienteAdapter (private val mCursor: Cursor): RecyclerView.Adapter<ClienteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder =
        ClienteViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.cliente_lista, parent, false))

        override fun getItemCount(): Int = mCursor.count

        override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
            mCursor.moveToPosition(position)
            holder.clienteTitulo.text = mCursor.getString(mCursor.getColumnIndex("title"))
            holder.clienteDescricao.text = mCursor.getString(mCursor.getColumnIndex("description"))

        }

}

    class ClienteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clienteTitulo = itemView.findViewById(R.id.cliente_item_titulo) as TextView
        val clienteDescricao = itemView.findViewById(R.id.cliente_item_descrição) as TextView

    }

