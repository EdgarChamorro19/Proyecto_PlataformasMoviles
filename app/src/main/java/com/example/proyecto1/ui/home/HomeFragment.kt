package com.example.proyecto1.ui.home

import android.content.Intent
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBindings
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.proyecto1.*
import com.example.proyecto1.databinding.FragmentHomeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_productos.*
import kotlinx.android.synthetic.main.activity_productos.recyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.json.JSONArray
import org.json.JSONObject

class HomeFragment : Fragment() {
    val arrayList=ArrayList<Productos>()
    val displayList=ArrayList<Productos>()
    val list = mutableListOf<CarouselItem>()
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val carousel: ImageCarousel= root.findViewById(R.id.carousel)
        val btn:Button = root.findViewById(R.id.btnropa)
        val btnmap:FloatingActionButton=root.findViewById(R.id.btnmaps)
        list.add(CarouselItem(R.drawable.tec_producto))
        list.add(CarouselItem(R.drawable.tec_producto2))
        list.add(CarouselItem(R.drawable.ropa_producto))
        carousel.addData(list)

        val url = "http://192.168.200.8/proyecto/listarProductos.php"
        val queue= Volley.newRequestQueue(root.context)
        val stringRequest= StringRequest(Request.Method.GET,url,{ response ->

            val jsonArray= JSONArray(response)

            for (i in 0 until jsonArray.length()){
                val jsonObject= JSONObject(jsonArray.getString(i))
                val id=jsonObject.get("id").toString().toInt()
                val nombre=jsonObject.get("Nombre").toString()
                val cantidad=jsonObject.get("Cantidad").toString().toInt()
                val categoria=jsonObject.get("Categoria").toString()
                val valor=jsonObject.get("Valor").toString().toDouble()
                val imagen=jsonObject.get("imagen").toString()

                arrayList.add(Productos(id,nombre,cantidad,categoria,valor,imagen))
            }

            displayList.addAll(arrayList)

            val myAdapter=Adapter(displayList,ActivityProductos())
            recyclerView2.layoutManager= LinearLayoutManager(root.context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView2.adapter=myAdapter
        },{ error ->
        })
        queue.add(stringRequest)

        btn.setOnClickListener{
            val frm1= Intent(context,ActivityProductos::class.java)
            startActivity(frm1)
        }
        btnmap.setOnClickListener{
            val frm2= Intent(context,MapsActivity::class.java)
            startActivity(frm2)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}