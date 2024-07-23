package com.example.composemvvm.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composemvvm.R
import com.example.composemvvm.viewmodels.CategoryViewModel



    @Composable
    fun CategoryScreen(onCLick:(category:String)->Unit) {
        val categoryViewModel: CategoryViewModel = hiltViewModel()
        val category: State<List<String>> = categoryViewModel.category.collectAsState()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            items(category.value.distinct()) {
                CategoryItem(category = it, onCLick)
            }
        }
    }

    @Composable
    fun CategoryItem(category: String,onCLick:(category:String)->Unit) {
        Box(
            modifier = Modifier
                .padding(4.dp)
                .size(160.dp)
                .clickable { onCLick(category) }
                .paint(
                    painter = painterResource(id = R.drawable.bg),
                    contentScale = ContentScale.Crop
                )
                .clip(RoundedCornerShape(8.dp))
                .border(
                    1.dp,
                    Color(0xFFEEEEEE)
                ),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = category,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(0.dp, 20.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
