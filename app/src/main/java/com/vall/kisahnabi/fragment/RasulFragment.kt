package com.vall.kisahnabi.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vall.kisahnabi.DisconnectedActivity
import com.vall.kisahnabi.adapter.NabiRasulAdapter
import com.vall.kisahnabi.databinding.FragmentRasulBinding
import com.vall.kisahnabi.model.ResponseNabiRasulItem
import com.vall.kisahnabi.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RasulFragment : Fragment() {

    private lateinit var binding: FragmentRasulBinding
    lateinit var adapters: NabiRasulAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRasulBinding.inflate(inflater,container,false)

        adapters = NabiRasulAdapter()
        binding.rvRasul.apply {
            adapter = adapters
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        binding.refreshRasul.setOnRefreshListener {
            getDataRasul()
            binding.refreshRasul.isRefreshing = false
        }

        getDataRasul()

        return binding.root
    }

    private fun getDataRasul() {
        val call = RetrofitService.getService().getDataRasul()

        call.enqueue(object : Callback<List<ResponseNabiRasulItem>> {
            override fun onResponse(
                call: Call<List<ResponseNabiRasulItem>>,
                response: Response<List<ResponseNabiRasulItem>>
            ) {
                if (response.isSuccessful) {
                    val list = response.body()!!
                    list.let { it.let { it1 -> adapters.addData(it1) } }
                    binding.progressBarRasul.visibility = View.INVISIBLE
                } else {
                    binding.progressBarRasul.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<List<ResponseNabiRasulItem>>, t: Throwable) {
                Handler().postDelayed({
                    startActivity(Intent(context, DisconnectedActivity::class.java))
                }, 100)
            }
        })
    }

}