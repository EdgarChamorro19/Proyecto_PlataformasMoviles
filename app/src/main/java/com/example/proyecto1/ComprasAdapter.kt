package com.example.proyecto1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto1.ui.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.itemcompras.view.*
import kotlinx.android.synthetic.main.itemproductos.view.*

class ComprasAdapter (val arrayList: ArrayList<Compras>,val context: ActivityCompras)
    : RecyclerView.Adapter<ComprasAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bintItems(compras: Compras, context: Context){
            itemView.item_id.text="Codigo: "+compras.idcompras.toString()
            itemView.item_cliente.text="Cliente: "+compras.nombrecliente
            itemView.item_cedula.text="Cedula: "+compras.identificacioncliente
            itemView.item_nombre.text=compras.nombreproducto
            itemView.item_cant.text="Cantidad: "+compras.cantidadproducto.toString()
            itemView.item_estado.text="Estado: "+compras.estado
            itemView.item_correo.text="Correo: "+compras.correocliente
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.itemcompras,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bintItems(arrayList[i],context)
    }

    override fun getItemCount()=arrayList.size
}