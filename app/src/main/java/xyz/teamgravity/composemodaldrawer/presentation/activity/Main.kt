package xyz.teamgravity.composemodaldrawer.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import xyz.teamgravity.composemodaldrawer.R
import xyz.teamgravity.composemodaldrawer.presentation.component.AppBar
import xyz.teamgravity.composemodaldrawer.presentation.component.DrawerContent
import xyz.teamgravity.composemodaldrawer.presentation.theme.ComposeModalDrawerTheme
import xyz.teamgravity.composemodaldrawer.presentation.viewmodel.MainViewModel

class Main : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeModalDrawerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewmodel = viewModel<MainViewModel>()
                    val drawer = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()

                    ModalNavigationDrawer(
                        drawerState = drawer,
                        drawerContent = {
                            DrawerContent(
                                menus = viewmodel.menus,
                                selectedMenu = viewmodel.selectedMenu,
                                onMenuClick = { menu ->
                                    scope.launch { drawer.close() }
                                    viewmodel.onSelectedMenuChange(menu)
                                }
                            )
                        }
                    ) {
                        Scaffold(
                            topBar = {
                                AppBar(
                                    onNavigationClick = {
                                        scope.launch { if (drawer.isOpen) drawer.close() else drawer.open() }
                                    }
                                )
                            },
                            floatingActionButton = {
                                FloatingActionButton(onClick = viewmodel::onHeartCheckedChange) {
                                    Icon(
                                        imageVector = if (viewmodel.heartChecked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                        contentDescription = stringResource(id = R.string.cd_favorite_button)
                                    )
                                }
                            }
                        ) { padding ->
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(padding)
                            ) {
                                Text(text = stringResource(id = viewmodel.selectedMenu.title))
                            }
                        }
                    }
                }
            }
        }
    }
}