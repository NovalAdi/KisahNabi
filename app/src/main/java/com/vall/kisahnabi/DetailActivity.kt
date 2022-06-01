package com.vall.kisahnabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.vall.kisahnabi.databinding.ActivityDetailBinding
import com.vall.kisahnabi.model.ResponseNabiRasulItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val DATA = "s"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<ResponseNabiRasulItem>(DATA)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.tvNamaNabi.text = data?.nama
        binding.tvTpTinggal.text = data?.tempat
        binding.tvTpKelahiran.text = data?.tpKelahiran
        binding.tvUsia.text = data?.usia
        binding.tvDesk.text = data?.deskripsi
        binding.imgNabi.load(data?.avatar)
    }
}