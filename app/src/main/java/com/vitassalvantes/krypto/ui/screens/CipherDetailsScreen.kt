package com.vitassalvantes.krypto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitassalvantes.krypto.ciphers.CiphersInfo.listOfAllCiphers
import com.vitassalvantes.krypto.ciphers.KryptoCipher

/**
 * Screen with a description of the selected cipher.
 */
@Composable
fun CipherDetailsScreen(cipherIndex: Int) {
    val currentCipher = listOfAllCiphers[cipherIndex]

    CipherDetailsScreenContent(currentCipher = currentCipher)
}

/**
 * UI content of the [CreatingNewCorrespondenceScreen].
 *
 * @param currentCipher selected on [CiphersScreen] cipher.
 */
@Composable
fun CipherDetailsScreenContent(currentCipher: KryptoCipher) {
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = currentCipher.name),
            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = currentCipher.description),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(
    name = "CipherDetailsScreen",
    showSystemUi = true
)
@Composable
fun PreviewCipherDetailsScreen() {
    CipherDetailsScreen(cipherIndex = 0)
}