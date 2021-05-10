package com.dicoding.ldwa

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.dicoding.ldwa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportActionBar?.hide()

        mainViewModel.restaurant.observe(this, { restaurant ->
            activityMainBinding.tvTitle.text = restaurant.name
            activityMainBinding.tvDescription.text = restaurant.description
            Glide.with(this)
                .load("https://restaurant-api.dicoding.dev/images/large/${restaurant.pictureId}")
                .into(activityMainBinding.ivPicture)
        })

        mainViewModel.listReview.observe(this, { customerReviews ->
            val listReview = customerReviews.map {
                "${it.review}\n- ${it.name}"
            }
            activityMainBinding.lvReview.adapter =
                ArrayAdapter(this, R.layout.item_review, listReview)
            activityMainBinding.edReview.setText("")
        })

        mainViewModel.isLoading.observe(this, { loading ->
            activityMainBinding.progressBar.visibility =
                if (loading) View.VISIBLE else View.GONE
        })

        activityMainBinding.btnSend.setOnClickListener { view ->
            mainViewModel.postReview(activityMainBinding.edReview.text.toString())
            hideKeyboard(view)
        }

    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}