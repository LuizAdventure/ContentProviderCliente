package com.luizalberto.contenteprovidercliente

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var notesRecycler: RecyclerView
    lateinit var noteRefreshButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteRefreshButton = findViewById(R.id.cliente_botao_atualiza)
        notesRecycler = findViewById(R.id.cliente_lista)
        getContentProvider()

        noteRefreshButton.setOnClickListener {getContentProvider() }
    }

    private fun getContentProvider(){
        try {
            val url = "content://com.luizalberto.contentprovider.provider/notes"
            val data = Uri.parse(url)
            val cursor: Cursor? =
            contentResolver.query(data, null, null, null, "title")
            notesRecycler.apply{
                layoutManager= LinearLayoutManager(this@MainActivity)
                adapter = ClienteAdapter(cursor as Cursor)
            }
        }catch (ex: Exception) {
            ex.printStackTrace()
        }

    }
}