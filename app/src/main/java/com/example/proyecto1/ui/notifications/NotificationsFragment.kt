package com.example.proyecto1.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.proyecto1.*
import com.example.proyecto1.databinding.FragmentNotificationsBinding
import kotlinx.android.synthetic.main.activity_compras.*
import kotlinx.android.synthetic.main.activity_productos.*
import kotlinx.android.synthetic.main.fragment_notifications.*
import org.json.JSONArray
import org.json.JSONObject

class NotificationsFragment : Fragment() {


    val arrayList=ArrayList<Compras>()
    val displayList=ArrayList<Compras>()
    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var view = inflater.inflate(R.layout.fragment_notifications, container, false)
        val url = "http://192.168.200.8/proyecto/listarCompras.php"
        val queue= Volley.newRequestQueue(view.context)
        val stringRequest= StringRequest(Request.Method.GET,url,{ response ->

            val jsonArray= JSONArray(response)

            for (i in 0 until jsonArray.length()){
                val jsonObject= JSONObject(jsonArray.getString(i))
                val idcompras=jsonObject.get("id").toString().toInt()
                val nombrecliente=jsonObject.get("nombrecliente").toString()
                val identificacioncliente=jsonObject.get("identificacioncliente").toString()
                val nombreproducto=jsonObject.get("nombreproducto").toString()
                val cantidadproducto=jsonObject.get("cantidadproducto").toString().toInt()
                val estado=jsonObject.get("estado").toString()
                val correocliente=jsonObject.get("correocliente").toString()

                arrayList.add(Compras(idcompras, nombrecliente, identificacioncliente, nombreproducto, cantidadproducto, estado, correocliente))
            }

            displayList.addAll(arrayList)

            val comprasAdapter=ComprasAdapter(displayList, context = ActivityCompras())
            viewbuys.layoutManager= LinearLayoutManager(view.context)
            viewbuys.adapter=comprasAdapter
        },{ error ->
        })
        queue.add(stringRequest)

        return root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}