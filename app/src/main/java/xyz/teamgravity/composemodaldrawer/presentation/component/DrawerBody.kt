package xyz.teamgravity.composemodaldrawer.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import xyz.teamgravity.composemodaldrawer.data.model.MenuModel

@Composable
fun DrawerBody(
    menus: List<MenuModel>,
    selectedMenu: MenuModel,
    onMenuClick: (menu: MenuModel) -> Unit,
) {
    LazyColumn {
        items(menus) { menu ->
            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = menu.icon,
                        contentDescription = stringResource(id = menu.contentDescription)
                    )
                },
                label = {
                    Text(text = stringResource(id = menu.title))
                },
                selected = menu == selectedMenu,
                onClick = {
                    onMenuClick(menu)
                },
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}