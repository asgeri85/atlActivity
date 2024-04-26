package net.asgeri.atlactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import net.asgeri.atlactivity.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val randomReqem = (0..100).random()
        var can = 5

        Toast.makeText(applicationContext,randomReqem.toString(),Toast.LENGTH_SHORT).show()

        binding.textViewHealth.text = can.toString()

        binding.button.setOnClickListener {
            val texmin = binding.editTextText.text.toString().trim()

            if (can==1){
                kecidEle(false)
            }

            if (texmin.isNotEmpty()) {
                if (randomReqem > texmin.toInt()) {
                    binding.textViewHelp.text = "Artırın"
                    can--
                    binding.textViewHealth.text = can.toString()
                } else if (randomReqem < texmin.toInt()) {
                    binding.textViewHelp.text = "Azaldın"
                    can--
                    binding.textViewHealth.text = can.toString()
                } else {
                    kecidEle(true)
                }
            } else {
                Toast.makeText(applicationContext, "Boş Ola bilmez", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun kecidEle(durum:Boolean){
        val intnet = Intent(this@GameActivity, FinishActivity::class.java)
        intnet.putExtra("durum", durum)
        startActivity(intnet)
        finish()
    }
}