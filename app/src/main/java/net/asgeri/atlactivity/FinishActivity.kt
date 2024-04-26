package net.asgeri.atlactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import net.asgeri.atlactivity.databinding.ActivityFinishBinding

class FinishActivity : AppCompatActivity() {

    lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val durum = intent.getBooleanExtra("durum", false)

        if (durum) {
            binding.imageView.setImageResource(R.drawable.gul)
            binding.textView2.text = "Siz Qalibsiniz"
        } else {
            binding.imageView.setImageResource(R.drawable.agla)
            binding.textView2.text = "Siz meğlubsunuz"
        }
    }
}