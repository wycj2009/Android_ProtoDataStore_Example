package com.example.android_protodatastore_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.android_protodatastore_example.databinding.ActivityMainBinding
import com.example.test.copy
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                prefStore.data.collect {
                    binding.text.text = "${it.clickCount.button1} / ${it.clickCount.button2} / ${it.clickCount.button3}"
                }
            }
        }

        binding.button1.setOnClickListener {
            runBlocking {
                prefStore.updateData {
                    it.copy {
                        clickCount = clickCount.copy {
                            button1 += 1L
                        }
                    }
                }
            }
        }
        binding.button2.setOnClickListener {
            runBlocking {
                prefStore.updateData {
                    it.copy {
                        clickCount = clickCount.copy {
                            button2 += 1L
                        }
                    }
                }
            }
        }
        binding.button3.setOnClickListener {
            runBlocking {
                prefStore.updateData {
                    it.copy {
                        clickCount = clickCount.copy {
                            button3 += 1L
                        }
                    }
                }
            }
        }
    }
}
