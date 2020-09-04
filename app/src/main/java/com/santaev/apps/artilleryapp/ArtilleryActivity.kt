package com.santaev.apps.artilleryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.santaev.apps.artilleryapp.databinding.ActivityArtilleryBinding

class ArtilleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityArtilleryBinding>(this, R.layout.activity_artillery)
    }
}
