package com.example.aadityaassignment_infraveo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aadityaassignment_infraveo.databinding.ActivityChatListBinding
import com.example.zocnutassignment1.ItemViewClick
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatListActivity : AppCompatActivity(), ItemViewClick {
    var BASE_URL="https://verify.infraveo.com/api/"

    lateinit var myAdapter: MyAdapter
    lateinit var binding: ActivityChatListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvContactList.layoutManager= LinearLayoutManager(this)
        getAllData()


    }

    private fun getAllData() {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var retroData =retrofit.getData()
        retroData.enqueue(object : Callback<List<UsersItem>>{
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                var data = response.body()!!
                myAdapter =MyAdapter(baseContext,data)

                binding.rvContactList.adapter= myAdapter
                Log.d("data",data.toString())
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

            }

        })
    }

    override fun viewItems(name: String, type: String, price: Int) {

    }
}

/*
val contatctArray = ArrayList<ContactModal>()

        contatctArray.add(ContactModal(R.drawable.aaditya_pic,"Aaditya Kumar Verma"))
        contatctArray.add(ContactModal(R.drawable.aaditya_pic,"Saurabh Shukla"))
        contatctArray.add(ContactModal(R.drawable.aaditya_pic,"CarryMinati"))
        contatctArray.add(ContactModal(R.drawable.aaditya_pic,"Irfan Khan"))

        val recyclerContactAdapter = RecyclerContactAdapter(this,contatctArray,this)
        binding.rvContactList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvContactList.adapter = recyclerContactAdapter
*/