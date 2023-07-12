package ir.hfathi.cryptotest

import androidx.navigation.NavHostController
import androidx.navigation.NavGraph.Companion.findStartDestination
import ir.hfathi.cryptotest.navigation.TopLevelDestination

class Action(private val navController: NavHostController) {

    fun navigate(navigationParams: NavigationParams) {
        if (navigationParams.destination is TopLevelDestination) {
            navController.navigate(navigationParams.navigationRoute) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        } else {
            navController.navigate(navigationParams.navigationRoute)
        }
    }

    fun navigateUp() = navController.navigateUp()

    fun popBackStack() = navController.popBackStack()

    fun popBackStack(
        route: String,
        inclusive: Boolean,
        saveState: Boolean = false
    ) = navController.popBackStack(route, inclusive, saveState)
}
