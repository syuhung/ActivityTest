package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activitytest.databinding.FirstLayoutBinding


class FirstActivity : AppCompatActivity() {
    private lateinit var binding: FirstLayoutBinding

    private var requestDataLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        it -> if (it.resultCode == RESULT_OK) {
            val data = it.data?.getStringExtra("data_return")
            data?.let {
                it -> Log.d("FirstActivity", it)
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.first_layout)

        binding = FirstLayoutBinding.inflate(layoutInflater)
//        binding.button1.setOnClickListener { Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
//        }
        binding.button1.setOnClickListener {
            Toast.makeText(this, "Start Activity 2", Toast.LENGTH_SHORT).show()
            //val intent = Intent(this, SecondActivity::class.java)
            //val intent = Intent("com.example.activitytest.ACTION_START")
            //intent.addCategory("com.example.activitytest.MY_CATEGORY")
            //val intent = Intent(Intent.ACTION_VIEW)
            //intent.data = Uri.parse("https://www.baidu.com")
            //val intent = Intent(Intent.ACTION_DIAL)
            //intent.data = Uri.parse("tel:10086")
            val data = "Hello SecondActivity"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("extra_data", data)
            requestDataLauncher.launch(intent)
        }
        setContentView(binding.root)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        when (item.itemId){
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()

            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}