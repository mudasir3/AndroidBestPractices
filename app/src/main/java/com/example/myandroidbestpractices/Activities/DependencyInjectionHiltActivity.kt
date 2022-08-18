package com.example.myandroidbestpractices.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidbestpractices.Adapters.CryptocurrencyAdapter
import com.example.myandroidbestpractices.R
import com.example.myandroidbestpractices.ViewModels.DIHiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DependencyInjectionHiltActivity : AppCompatActivity() {

    private lateinit var cryptocurrencyList: RecyclerView
    private val viewModel: DIHiltViewModel by viewModels()

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val root = inflater.inflate(R.layout.activity_dependency_injecton_hilt, container, false)
//
//        cryptocurrencyList = root.findViewById<RecyclerView>(R.id.cryptocurrency_list)
//        cryptocurrencyList.layoutManager = LinearLayoutManager(context)
//
//        observeCryptoCurrency()
//        return root
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dependency_injecton_hilt)

        cryptocurrencyList = findViewById<RecyclerView>(R.id.cryptocurrency_list)
        cryptocurrencyList.layoutManager = LinearLayoutManager(this)

        observeCryptoCurrency()
    }

    // Observing the live data
    private fun observeCryptoCurrency() {
        viewModel.cryptoCurrency.observe(this) {
            cryptocurrencyList.adapter = CryptocurrencyAdapter(it)
        }
    }
}