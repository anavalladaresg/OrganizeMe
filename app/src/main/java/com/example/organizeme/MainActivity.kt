package com.example.organizeme.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.organizeme.R
import com.example.organizeme.ui.dashboard.DashboardFragment
import com.example.organizeme.ui.home.HomeFragment
import com.example.organizeme.ui.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar layout principal con BottomNavigationView programáticamente
        val rootLayout = FrameLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        val navHostFragment = FrameLayout(this).apply {
            id = View.generateViewId() // Genera un ID único para el FrameLayout
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        val bottomNav = BottomNavigationView(this).apply {
            id = View.generateViewId()
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = android.view.Gravity.BOTTOM
            }

            // Menú de navegación
            menu.apply {
                add(0, R.id.navigation_home, 0, "Inicio").setIcon(android.R.drawable.ic_menu_view)
                add(0, R.id.navigation_dashboard, 1, "Dashboard").setIcon(android.R.drawable.ic_menu_manage)
                add(0, R.id.navigation_notifications, 2, "Notificaciones").setIcon(android.R.drawable.ic_menu_info_details)
            }
        }

        // Añadir vistas al rootLayout
        rootLayout.addView(navHostFragment)
        rootLayout.addView(bottomNav)
        setContentView(rootLayout)

        // Configurar la navegación entre fragmentos
        bottomNav.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> loadFragment(HomeFragment())
                R.id.navigation_dashboard -> loadFragment(DashboardFragment())
                R.id.navigation_notifications -> loadFragment(NotificationsFragment())
                else -> false
            }
        })

        // Cargar el fragmento inicial
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.navigation_home
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, fragment)
            .commit()
        return true
    }
}
