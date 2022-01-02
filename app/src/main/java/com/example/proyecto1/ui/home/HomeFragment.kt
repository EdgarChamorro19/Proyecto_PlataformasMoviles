package com.example.proyecto1.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBindings
import com.example.proyecto1.ActivityPrincipal
import com.example.proyecto1.ActivityProductos
import com.example.proyecto1.R
import com.example.proyecto1.databinding.FragmentHomeBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class HomeFragment : Fragment() {
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
        list.add(CarouselItem(R.drawable.tec_producto))
        list.add(CarouselItem(R.drawable.tec_producto2))
        list.add(CarouselItem(R.drawable.ropa_producto))
        carousel.addData(list)

        btn.setOnClickListener{
            val frm1= Intent(context,ActivityProductos::class.java)
            startActivity(frm1)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}