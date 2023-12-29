package com.example.diceroller.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.diceroller.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen4(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(stringResource(R.string.pageTitle4))},
                navigationIcon = {Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.clickable { navController.popBackStack() })})
        }
    ) {
        BodyContent3(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(start = 15.dp, end = 15.dp),
            contentPadding = it
        )
    }
}

@Composable
private fun BodyContent3(modifier: Modifier = Modifier, contentPadding: PaddingValues) {
    var idCountImage by remember { mutableStateOf(1) }
    val idImage = when(idCountImage){
        1 -> arrayOf(
            R.drawable.homenaje_a_tania,
            R.string.artwork_title1,
            R.string.artwork_artist_year1)
        2 -> arrayOf(
            R.drawable.monalisa,
            R.string.artwork_title2,
            R.string.artwork_artist_year2)
        else -> arrayOf(
            R.drawable.judith_beheading_holofernes,
            R.string.artwork_title3,
            R.string.artwork_artist_year3)
    }
    Column(
        modifier = modifier
    ){
        Image(
            painter = painterResource(idImage[0]),
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth())
        ArtworkDescriptor(idImage[1], idImage[2],
            Modifier.padding(bottom = 10.dp))
        ArtworkScreenController(
            text1 = R.string.artwork_previous,
            text2 = R.string.artwork_next,
            onClick1 = {
                if(idCountImage > 1) idCountImage--
            },
            onClick2 = {
                if(idCountImage < 3) idCountImage++
            },
            modifier = Modifier.padding(contentPadding)
        )
    }
}

@Composable
private fun ArtworkDescriptor(
    @StringRes idTitle: Int,
    @StringRes idArtist: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ){
        Text(text = stringResource(idTitle),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        Text(text = stringResource(idArtist),
            textAlign = TextAlign.Center,
            fontSize = 16.sp)
    }
}

@Composable
private fun ArtworkScreenController(
    @StringRes text1: Int,
    @StringRes text2: Int,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    modifier: Modifier = Modifier)
{
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ){
        Button(
            onClick = onClick1,
            modifier = Modifier.weight(1f)
                .padding(end = 10.dp)) {
            Text(stringResource(text1))
        }
        Button(
            onClick = onClick2,
            modifier = Modifier.weight(1f)
                .padding(start = 10.dp)) {
            Text(stringResource(text2))
        }
    }
}