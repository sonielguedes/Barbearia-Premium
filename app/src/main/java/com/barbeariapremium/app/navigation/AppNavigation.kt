package com.barbeariapremium.app.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.barbeariapremium.app.ui.auth.screens.LoginScreen
import com.barbeariapremium.app.ui.auth.screens.RegisterScreen
import com.barbeariapremium.app.ui.booking.screens.BookingScreen
import com.barbeariapremium.app.ui.home.screens.HomeScreen
import com.barbeariapremium.app.ui.ai.AiScreen
import com.barbeariapremium.app.ui.admin.screens.AdminDashboardScreen
import com.barbeariapremium.app.ui.admin.screens.PromotionManagementScreen
import com.barbeariapremium.app.ui.admin.screens.AdminLoginScreen
import com.barbeariapremium.app.ui.admin.screens.AdminScheduleScreen
import com.barbeariapremium.app.ui.admin.screens.UserManagementScreen
import com.barbeariapremium.app.ui.admin.screens.BarberManagementScreen
import com.barbeariapremium.app.ui.loyalty.LoyaltyScreen
import com.barbeariapremium.app.ui.viewmodel.AuthViewModel
import com.barbeariapremium.app.ui.viewmodel.BookingViewModel
import com.barbeariapremium.app.ui.viewmodel.HomeViewModel
import com.barbeariapremium.app.ui.viewmodel.AdminViewModel
import com.barbeariapremium.app.ui.viewmodel.MembershipViewModel

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Booking : Screen("booking")
    object Profile : Screen("profile")
    object Admin : Screen("admin")
    object AdminLogin : Screen("admin_login")
    object AdminSchedule : Screen("admin_schedule")
    object Loyalty : Screen("loyalty")
    object Membership : Screen("membership")
    object UserManagement : Screen("user_management")
    object BarberManagement : Screen("barber_management")
    object PromotionManagement : Screen("promotion_management")
    object AiAssistant : Screen("ai_assistant")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            com.barbeariapremium.app.ui.splash.SplashScreen(
                onNext = {
                    val destination = if (authViewModel.isUserLoggedIn()) Screen.Home.route else Screen.Login.route
                    navController.navigate(destination) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Login.route) {
            LoginScreen(
                viewModel = authViewModel,
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.Register.route)
                },
                onNavigateToAdmin = {
                    navController.navigate(Screen.AdminLogin.route)
                }
            )
        }

        composable(Screen.AdminLogin.route) {
            AdminLoginScreen(
                viewModel = authViewModel,
                onAdminLoginSuccess = {
                    navController.navigate(Screen.Admin.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Register.route) {
            RegisterScreen(
                viewModel = authViewModel,
                onRegisterSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Register.route) { inclusive = true }
                    }
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                viewModel = homeViewModel,
                onNavigateToBooking = { navController.navigate(Screen.Booking.route) },
                onNavigateToProfile = { navController.navigate(Screen.Profile.route) },
                onNavigateToAdmin = { navController.navigate(Screen.Admin.route) },
                onNavigateToAi = { navController.navigate(Screen.AiAssistant.route) },
                onNavigateToLoyalty = { navController.navigate(Screen.Loyalty.route) },
                onNavigateToMembership = { navController.navigate(Screen.Membership.route) }
            )
        }

        composable(Screen.Booking.route) {
            val bookingViewModel: BookingViewModel = hiltViewModel()
            BookingScreen(
                viewModel = bookingViewModel,
                onBookingComplete = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Booking.route) { inclusive = true }
                    }
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Admin.route) {
            val adminViewModel: AdminViewModel = hiltViewModel()
            AdminDashboardScreen(
                viewModel = adminViewModel,
                onNavigateBack = { navController.popBackStack() },
                onManagePromotions = { navController.navigate(Screen.PromotionManagement.route) },
                onManageSchedule = { navController.navigate(Screen.AdminSchedule.route) },
                onManageMemberships = { navController.navigate(Screen.UserManagement.route) },
                onManageBarbers = { navController.navigate(Screen.BarberManagement.route) }
            )
        }

        composable(Screen.UserManagement.route) {
            val adminViewModel: AdminViewModel = hiltViewModel()
            UserManagementScreen(
                viewModel = adminViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.BarberManagement.route) {
            val adminViewModel: AdminViewModel = hiltViewModel()
            BarberManagementScreen(
                viewModel = adminViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.AdminSchedule.route) {
            AdminScheduleScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.PromotionManagement.route) {
            val adminViewModel: AdminViewModel = hiltViewModel()
            PromotionManagementScreen(
                viewModel = adminViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Loyalty.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            LoyaltyScreen(
                viewModel = homeViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Membership.route) {
            val membershipViewModel: MembershipViewModel = hiltViewModel()
            com.barbeariapremium.app.ui.membership.MembershipScreen(
                viewModel = membershipViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.AiAssistant.route) {
            AiScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(Screen.Profile.route) {
            com.barbeariapremium.app.ui.profile.screens.ProfileScreen(
                viewModel = authViewModel,
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
