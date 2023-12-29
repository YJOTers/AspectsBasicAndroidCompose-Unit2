package com.example.diceroller.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.diceroller.R
import com.example.diceroller.navigation.AppRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavController) {
    Scaffold(topBar = {
            TopAppBar(
            title = {Text(stringResource(id = R.string.pageTitle2))},
            navigationIcon = {Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.clickable { navController.popBackStack() })},
            actions = {Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                modifier = Modifier.clickable { navController.navigate(AppRoutes.Screen3.route)})}
        )}) {
        BodyContent1(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(it)
        )
    }
}

@Composable
private fun BodyContent1(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var randomPush = (2..4).random()
    var countPush = 0
    val changeImageAndText = when(result){
        1 -> arrayOf(
            R.drawable.lemon_tree,
            R.string.page2Description1,
            R.string.page2Content1)
        2 -> arrayOf(
            R.drawable.lemon_squeeze,
            R.string.page2Description2,
            R.string.page2Content2)
        3 -> arrayOf(
            R.drawable.lemon_drink,
            R.string.page2Description3,
            R.string.page2Content3)
        else -> arrayOf(
            R.drawable.lemon_restart,
            R.string.page2Description4,
            R.string.page2Content4)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = changeImageAndText[0]),
            contentDescription = changeImageAndText[1].toString(),
            modifier = Modifier.clickable {
                if(result == 2) {
                    countPush++
                    if(countPush == randomPush) {
                        result++
                        countPush = 0
                    }
                }else if (result < 4){
                    result++
                }else{
                    result = 1
                    randomPush = (2..4).random()
                }
            })
        Text(stringResource(id = changeImageAndText[2]))
    }
}