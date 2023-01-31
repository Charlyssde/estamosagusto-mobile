package com.veracruz.estamosagustoapp.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.veracruz.estamosagustoapp.domain.model.UserModel
import com.veracruz.estamosagustoapp.presentation.components.DateInput
import com.veracruz.estamosagustoapp.presentation.components.DropdownTextField
import com.veracruz.estamosagustoapp.presentation.components.RoundedButton
import com.veracruz.estamosagustoapp.presentation.components.TransparentTextField
import kotlin.reflect.KFunction0

@Composable
fun RegisterScreen(
    state: UserModel,
    onClick: (String, String, String, String, String, String, String,String, String, String, String, String, String, String, String) -> Unit
) {

    val nameValue = remember { mutableStateOf("") }
    val lastnameValue = remember { mutableStateOf("") }
    val secondLastnameValue = remember { mutableStateOf("") }
    val dateOfBirthValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val mobileValue = remember { mutableStateOf("") }
    val listOfGenders = listOf<String>("Masculino", "Femenino", "No binario", "Prefiero no decirlo")
    val genderValue = remember { mutableStateOf("") }
    val listOfEthnic = listOf<String>("Ninguno","Indígena", "Latino", "Afroamericano", "Asiáticoamericano")
    val ethnicOriginValue = remember { mutableStateOf("") }
    val listOfScholarship = listOf<String>("Primaria", "Secundaria", "Bachillerato", "Licenciatura", "Doctorado")
    val scholarshipValue = remember { mutableStateOf("") }
    val occupationValue = remember { mutableStateOf("") }
    val ineCodeValue = remember { mutableStateOf("") }
    val sectionValue = remember { mutableStateOf("") }
    val cityValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val hobbyValue = remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier.fillMaxWidth()
    ){
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().background(color = Color.White).padding(10.dp)
            ){
                Text(
                    text = "Registra a un amigo",
                    style = MaterialTheme.typography.h5.copy(
                        color = MaterialTheme.colors.primary
                    )
                )
            }
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
            ) {

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TransparentTextField(
                        textFieldValue = nameValue,
                        textLabel = "Nombre",
                        keyboardType = KeyboardType.Text,
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
                        keyboardType = KeyboardType.Text,
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        ),
                        imeAction = ImeAction.Next
                    )
                    /*TransparentTextField(
                        textFieldValue = dateOfBirthValue,
                        textLabel = "Fecha de nacimiento",
                        keyboardType = KeyboardType.Text,
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        ),
                        imeAction = ImeAction.Next
                    )*/
                    DateInput(
                        textFieldValue = dateOfBirthValue,
                        imeAction = ImeAction.Next
                    )

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
                    DropdownTextField(listItems = listOfGenders, value = genderValue, textLabel = "Género" )
                    DropdownTextField(listItems = listOfScholarship, value = scholarshipValue, textLabel = "Escolaridad")
                    DropdownTextField(listItems = listOfEthnic, value = ethnicOriginValue, textLabel = "Origen étnico" )
                    /*TransparentTextField(
                        textFieldValue = genderValue,
                        textLabel = "Género",
                        keyboardType = KeyboardType.Text,
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        ),
                        imeAction = ImeAction.Next
                    )
                    TransparentTextField(
                        textFieldValue = ethnicOriginValue,
                        textLabel = "Origen étnico",
                        keyboardType = KeyboardType.Text,
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        ),
                        imeAction = ImeAction.Next
                    )
                    TransparentTextField(
                        textFieldValue = scholarshipValue,
                        textLabel = "Escolaridad",
                        keyboardType = KeyboardType.Text,
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        ),
                        imeAction = ImeAction.Next
                    )*/
                    TransparentTextField(
                        textFieldValue = occupationValue,
                        textLabel = "Ocupación",
                        keyboardType = KeyboardType.Text,
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

                    TransparentTextField(
                        textFieldValue = emailValue,
                        textLabel = "Correo electrónico",
                        keyboardType = KeyboardType.Email,
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        imeAction = ImeAction.Next
                    )
                    TransparentTextField(
                        textFieldValue = hobbyValue,
                        textLabel = "Pasatiempos",
                        keyboardType = KeyboardType.Email,
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
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
                            scholarshipValue.value,
                            occupationValue.value,
                            ineCodeValue.value,
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