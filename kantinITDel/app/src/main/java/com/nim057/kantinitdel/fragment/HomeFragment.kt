package com.nim057.kantinitdel.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.nim057.kantinitdel.R
import com.nim057.kantinitdel.adapter.AdapterMenu
import com.nim057.kantinitdel.adapter.AdapterSlider
import com.nim057.kantinitdel.model.Menu

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    lateinit var rvMenu: RecyclerView
    lateinit var rvMenu1: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvMenu = view.findViewById(R.id.rv_menu)
        rvMenu1 = view.findViewById(R.id.rv_menu1)

        var arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.kantin1)
        arrSlider.add(R.drawable.kantin2)
        arrSlider.add(R.drawable.kantin3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager1 = LinearLayoutManager(activity)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL

        rvMenu.adapter = AdapterMenu(arrMenu)
        rvMenu.layoutManager = layoutManager

        rvMenu1.adapter = AdapterMenu(arrMenu1)
        rvMenu1.layoutManager = layoutManager1

        return view
    }

    val arrMenu: ArrayList<Menu>get() {
        val arr = ArrayList<Menu>()
        val m1 = Menu()
        m1.nama = "Ayam Woku"
        m1.harga = "Rp28.250"
        m1.gambar = R.drawable.makanan1

        val m2 = Menu()
        m2.nama = "Mie Gomak Kuah"
        m2.harga = "Rp7.900"
        m2.gambar = R.drawable.makanan2

        val m3 = Menu()
        m3.nama = "Jahir Pesmol"
        m3.harga = "Rp23.500"
        m3.gambar = R.drawable.makanan3

        arr.add(m1)
        arr.add(m2)
        arr.add(m3)

        return arr
    }
    val arrMenu1: ArrayList<Menu>get() {
        val arr1 = ArrayList<Menu>()
        val m1 = Menu()
        m1.nama = "Susu Tarutung"
        m1.harga = "Rp9.990"
        m1.gambar = R.drawable.minuman1

        val m2 = Menu()
        m2.nama = "Bandrek Susu"
        m2.harga = "Rp7.200"
        m2.gambar = R.drawable.minuman2

        val m3 = Menu()
        m3.nama = "Teh Manis"
        m3.harga = "Rp6.900"
        m3.gambar = R.drawable.minuman3

        arr1.add(m1)
        arr1.add(m2)
        arr1.add(m3)

        return arr1
    }

}