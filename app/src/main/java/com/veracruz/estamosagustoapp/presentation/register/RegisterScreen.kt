package com.veracruz.estamosagustoapp.presentation.register

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.veracruz.estamosagustoapp.domain.model.CityModel
import com.veracruz.estamosagustoapp.presentation.components.*

@Composable
fun RegisterScreen(
    getCities : suspend () -> List<CityModel>,
    onClick: (String, String, String, String, String, String, String,String, String, String, String, String, CityModel, String, String) -> Unit
) {

    val nameValue = remember { mutableStateOf("") }
    val lastnameValue = remember { mutableStateOf("") }
    val secondLastnameValue = remember { mutableStateOf("") }
    val dateOfBirthValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val mobileValue = remember { mutableStateOf("") }
    val listOfGenders = listOf("Masculino", "Femenino", "No binario", "Prefiero no decirlo")
    val genderValue = remember { mutableStateOf("") }
    val listOfEthnic = listOf("Ninguno","Indígena", "Latino", "Afroamericano", "Asiáticoamericano")
    val ethnicOriginValue = remember { mutableStateOf("") }
    val listOfScholarship = listOf("Primaria", "Secundaria", "Bachillerato", "Licenciatura", "Doctorado")
    val scholarshipValue = remember { mutableStateOf("") }
    val occupationValue = remember { mutableStateOf("") }
    val ineCodeValue = remember { mutableStateOf("") }
    val sectionValue = remember { mutableStateOf("") }
    val cities = remember {  mutableStateOf(emptyList<CityModel>()) }
    LaunchedEffect(key1 = Unit){
        cities.value = getCities.invoke()
        Log.e("GETSIN->", cities.value.toString())
    }
    val cityValue = remember { mutableStateOf(CityModel()) }
    val emailValue = remember { mutableStateOf("") }
    val hobbyValue = remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = { TopBar(text = "Registra a un amigo")}
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ){
            Column {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
                ) {

                    Column(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        DividerText(text = "Información personal")
                        TransparentTextField(
                            textFieldValue = nameValue,
                            textLabel = "Nombre",
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Words,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        TransparentTextField(
                            textFieldValue = lastnameValue,
                            textLabel = "Primer apellido",
                            capitalization = KeyboardCapitalization.Words,
                            keyboardType = KeyboardType.Text,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        TransparentTextField(
                            textFieldValue = secondLastnameValue,
                            textLabel = "Segundo Apellido",
                            capitalization = KeyboardCapitalization.Words,
                            keyboardType = KeyboardType.Text,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        DateInput(
                            textFieldValue = dateOfBirthValue,
                            imeAction = ImeAction.Next
                        )
                        DropdownTextField(listItems = listOfGenders, value = genderValue, textLabel = "Género" )
                        DropdownTextField(listItems = listOfEthnic, value = ethnicOriginValue, textLabel = "Origen étnico" )

                        DividerText(text = "Información de contacto")
                        TransparentTextField(
                            textFieldValue = phoneValue,
                            textLabel = "Teléfono de casa",
                            keyboardType = KeyboardType.Phone,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        TransparentTextField(
                            textFieldValue = mobileValue,
                            textLabel = "Teléfono celular",
                            keyboardType = KeyboardType.Phone,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        TransparentTextField(
                            textFieldValue = emailValue,
                            textLabel = "Correo electrónico",
                            keyboardType = KeyboardType.Email,
                            keyboardActions = KeyboardActions(
                                onNext = { focusManager.moveFocus(FocusDirection.Down) }
                            ),
                            imeAction = ImeAction.Next
                        )

                        DividerText(text = "Información adicional")
                        DropdownTextField(listItems = listOfScholarship, value = scholarshipValue, textLabel = "Escolaridad")
                        TransparentTextField(
                            textFieldValue = occupationValue,
                            textLabel = "Ocupación",
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Words,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        TransparentTextField(
                            textFieldValue = ineCodeValue,
                            textLabel = "Clave de elector",
                            keyboardType = KeyboardType.Number,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        TransparentTextField(
                            textFieldValue = sectionValue,
                            textLabel = "Sección",
                            keyboardType = KeyboardType.Number,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        DropdownCities(listItems = cities.value, value = cityValue, textLabel = "Municipio" )

                        TransparentTextField(
                            textFieldValue = hobbyValue,
                            textLabel = "Pasatiempos",
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Words,
                            keyboardActions = KeyboardActions(
                                onDone = { focusManager.clearFocus() }
                            ),
                            imeAction = ImeAction.Done
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        RoundedButton(
                            text = "Registrar",
                            displayProgressBar = false
                        ) {
                            onClick(
                                nameValue.value,
                                lastnameValue.value,
                                secondLastnameValue.value,
                                dateOfBirthValue.value,
                                phoneValue.value,
                                mobileValue.value,
                                genderValue.value,
                                ethnicOriginValue.value,
                                ineCodeValue.value,
                                occupationValue.value,
                                scholarshipValue.value,
                                sectionValue.value,
                                cityValue.value,
                                emailValue.value,
                                hobbyValue.value
                            )
                        }
                    }
                }
            }
        }
    }
}