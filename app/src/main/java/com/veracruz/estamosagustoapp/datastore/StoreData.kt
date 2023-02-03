package com.veracruz.estamosagustoapp.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreData (private val context : Context) {

    companion object{
        private val Context.dataStoreToken : DataStore<Preferences> by preferencesDataStore("token")
        val TOKEN_KEY = stringPreferencesKey("token")
    }

    val getToken: Flow<String?> = context.dataStoreToken.data
        .map { preferences ->
            preferences[TOKEN_KEY] ?: "FirstLast@gmail.com"
        }

    suspend fun saveToken(name: String) {
        context.dataStoreToken.edit { preferences ->
            preferences[TOKEN_KEY] = name
        }
    }
    suspend fun deleteToken() {
        context.dataStoreToken.edit { preferences ->
            preferences.remove(TOKEN_KEY)
        }
    }

}