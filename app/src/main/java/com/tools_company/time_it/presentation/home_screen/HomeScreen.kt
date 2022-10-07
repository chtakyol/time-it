package com.tools_company.time_it.presentation.home_screen

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tools_company.time_it.presentation.common_components.CustomButton
import com.tools_company.time_it.presentation.home_screen.components.EventCard
import com.tools_company.time_it.presentation.home_screen.components.Title
import com.tools_company.time_it.utils.Screen
import com.tools_company.time_it.utils.toHumanReadableDate

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
) {
    val backgroundColor = Color(0xFFFDFDFF)

    val uiState = viewModel.uiState.value

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Green)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(uiState.events) { event ->
                    EventCard(
                        title = event.title,
                        date = event.date.time.toHumanReadableDate(),
                        content = event.content,
                        modifier = Modifier
                            .clickable {
                                navController.navigate(
                                    Screen.AddEventScreen.route +
                                            "?eventId=${event.id}"
                                )
                            }
                    )
                }
            }
            CustomButton(
                modifier = Modifier,
                text = "Add New Event"
            ){
                navController.navigate(Screen.AddEventScreen.route)
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
@Preview
fun PreviewHomeScreen() {
    HomeScreen()
}