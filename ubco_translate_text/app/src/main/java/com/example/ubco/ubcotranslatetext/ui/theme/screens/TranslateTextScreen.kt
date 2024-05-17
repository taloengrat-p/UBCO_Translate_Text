package com.example.ubco.ubcotranslatetext.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ubco.ubcotranslatetext.R
import com.example.ubco.ubcotranslatetext.ui.theme.PurpleGrey80
import com.example.ubco.ubcotranslatetext.ui.theme.viewmodels.TranslateTextViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TranslateTextScreen(
    viewModel: TranslateTextViewModel,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        Text(stringResource(id = R.string.english))
                        Box(modifier = modifier.width(16.dp))
                        Icon(Icons.Default.ArrowForward, contentDescription = "Forward")
                        Box(modifier = modifier.width(16.dp))
                        Text(stringResource(id = R.string.ubco))
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.doClear()
                        }) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            TextField(
                maxLines = 10,
                value = viewModel.originalWord,
                onValueChange = {
                    viewModel.doTranslate(it)
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.txf_placeholder),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.Gray
                    )
                },
                label = {
                    Text(
                        stringResource(id = R.string.english_language),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                singleLine = false,
                textStyle = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .border(
                        border = BorderStroke(0.dp, Color.Transparent),
                    )


            )
            Divider(
                color = PurpleGrey80,
                thickness = 10.dp,
                modifier = modifier.border(
                    border = BorderStroke(0.dp, Color.Transparent),
                    shape = RoundedCornerShape(0.dp),
                )
            )
            TextField(
                maxLines = 10,
                value = viewModel.translateResult,
                onValueChange = { },
                readOnly = true,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.txf_placeholder),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                },
                label = {
                    Text(
                        stringResource(id = R.string.ubco_language),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                singleLine = false,
                textStyle = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                ),
                enabled = false,
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)

            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun TranslateTextScreenPreview() {
    com.example.ubco.ubcotranslatetext.ui.theme.UBCOTranslateTextTheme {
        TranslateTextScreen(
            TranslateTextViewModel(),
        )
    }
}