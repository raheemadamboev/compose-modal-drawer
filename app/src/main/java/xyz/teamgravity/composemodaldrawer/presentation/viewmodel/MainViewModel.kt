package xyz.teamgravity.composemodaldrawer.presentation.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import xyz.teamgravity.composemodaldrawer.R
import xyz.teamgravity.composemodaldrawer.data.model.MenuModel

class MainViewModel : ViewModel() {

    companion object {
        private const val HEART_CHECKED_DEFAULT = false
    }

    val menus = listOf(
        MenuModel(
            id = "home",
            title = R.string.home,
            contentDescription = R.string.cd_home_menu,
            icon = Icons.Default.Home
        ),
        MenuModel(
            id = "settings",
            title = R.string.settings,
            contentDescription = R.string.cd_settings_menu,
            icon = Icons.Default.Settings
        ),
        MenuModel(
            id = "help",
            title = R.string.help,
            contentDescription = R.string.cd_help_menu,
            icon = Icons.Default.Info
        )
    )

    var selectedMenu: MenuModel by mutableStateOf(menus[0])
        private set

    var heartChecked: Boolean by mutableStateOf(HEART_CHECKED_DEFAULT)
        private set

    fun onSelectedMenuChange(value: MenuModel) {
        selectedMenu = value
    }

    fun onHeartCheckedChange() {
        heartChecked = !heartChecked
    }
}