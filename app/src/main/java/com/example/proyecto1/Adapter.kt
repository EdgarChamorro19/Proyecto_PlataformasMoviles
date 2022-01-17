package com.example.proyecto1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.itemproductos.view.*

class Adapter(val arrayList: ArrayList<Productos>, val context: ActivityProductos)
    : RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bintItems(productos: Productos, context: Context){
            itemView.item_cod.text="Cod: "+productos.id.toString()
            itemView.item_titulo.text=productos.Nombre
            itemView.item_cantidad.text="Cantidad: "+productos.Cantidad.toString()
            itemView.item_cat.text="Categoria: "+productos.Categoria
            itemView.item_valor.text="Precio:$"+productos.Valor.toString()
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.itemproductos,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bintItems(arrayList[i],context)
    }

    override fun getItemCount()=arrayList.size
}