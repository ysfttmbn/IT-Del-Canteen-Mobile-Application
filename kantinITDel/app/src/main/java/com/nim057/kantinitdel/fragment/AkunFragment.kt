package com.nim057.kantinitdel.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.nim057.kantinitdel.R
import com.nim057.kantinitdel.database.SharedPreferences


/**
 * A simple [Fragment] subclass.
 */
class AkunFragment : Fragment() {

    lateinit var sp:SharedPreferences
    lateinit var btnLogout:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_akun, container, false)
        btnLogout = view.findViewById(R.id.btnLogout)

        sp = SharedPreferences(requireActivity())

        btnLogout.setOnClickListener{
            sp.setStatusLogin(false)
        }
        return view
    }

}
