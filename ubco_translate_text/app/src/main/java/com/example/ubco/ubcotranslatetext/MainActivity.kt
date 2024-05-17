package com.example.ubco.ubcotranslatetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ubco.ubcotranslatetext.ui.theme.UBCOTranslateTextTheme
import com.example.ubco.ubcotranslatetext.ui.theme.screens.TranslateTextScreen
import com.example.ubco.ubcotranslatetext.ui.theme.viewmodels.TranslateTextViewModel

class MainActivity : ComponentActivity() {

    private val translateTextViewModel: TranslateTextViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UBCOTranslateTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TranslateTextScreen(
                        translateTextViewModel,
                    )
                }
            }
        }
    }

}
