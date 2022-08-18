package com.example.myandroidbestpractices.Activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myandroidbestpractices.R

class FirstFragment :Fragment() {

    private lateinit var btn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.first_fragment, container, false)

        btn=root.findViewById(R.id.btn)
        btn.setOnClickListener {
            findNavController().navigate(R.id.actionnavigateHilt)
        }
        return root

    }
}