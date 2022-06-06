package xyz.teamgravity.composemodaldrawer.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import xyz.teamgravity.composemodaldrawer.data.model.MenuModel

@Composable
fun DrawerContent(
    menus: List<MenuModel>,
    selectedMenu: MenuModel,
    onMenuClick: (menu: MenuModel) -> Unit,
) {
    Column {
        DrawerHeader()
        DrawerBody(
            menus = menus,
            selectedMenu = selectedMenu,
            onMenuClick = onMenuClick
        )
    }
}