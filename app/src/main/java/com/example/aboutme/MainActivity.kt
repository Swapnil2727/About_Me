package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("Saumil Patel")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


     //   setContentView(R.layout.activity_main)  //Not in use when using data binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName
//        findViewById<Button>(R.id.done_btn).setOnClickListener(View.OnClickListener {
//
//            addNickName(it)
//
//        })

        binding.doneBtn.setOnClickListener(View.OnClickListener {

            addNickName(it)
        })


    }

    private fun addNickName(view: View) //view is the which on the function is called
    {
//        val nickname_edittext =    findViewById<EditText>(R.id.nickname_edittext)
//
//        val nickname_textview=     findViewById<TextView>(R.id.nickname_textview)



//        nickname_textview.text = nickname_edittext.text
//        nickname_edittext.visibility = View.GONE
//        view.visibility = View.GONE //set visibility of view Which is button in this context because BUTTON called this function
//
//        nickname_textview.visibility = View.VISIBLE


        //Binding.apply applies to all
          binding.apply {

//            nicknameTextview.text = binding.nicknameEdittext.text

              myName?.nickname = nicknameEdittext.text.toString()
              invalidateAll()
              doneBtn.visibility = View.GONE
              nicknameEdittext.visibility = View.GONE
              nicknameTextview.visibility = View.VISIBLE

          }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)



    }
}
