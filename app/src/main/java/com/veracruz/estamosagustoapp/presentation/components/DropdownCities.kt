package com.veracruz.estamosagustoapp.presentation.components


import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.veracruz.estamosagustoapp.domain.model.CityModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropdownCities(
    listItems : List<CityModel>,
    value : MutableState<CityModel>,
    textLabel : String
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = value.value.nameCity,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = textLabel) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth(),

            )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            listItems.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(onClick = {
                    value.value = selectedOption
                    expanded = false
                }) {
                    Text(text = selectedOption.nameCity)
                }
            }
        }
    }

}