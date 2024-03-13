package com.project.a7boxlauncher

import AppsAdapter
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var appListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Substitua pelo nome do seu arquivo de layout

        // Obtenha a referência do ListView
        appListView = findViewById(R.id.app_list) // Substitua pelo ID do seu ListView

        // Obtenha a lista de aplicativos e armazene em uma variável
        val apps = installedApps

        // Crie e defina o adaptador para o ListView
        val adapter = AppsAdapter(this, apps)

        // Use o operador safe cast para verificar se appListView não é nulo
        appListView?.adapter = adapter
    }

    private val installedApps: List<ApplicationInfo>
        // Implemente um método para obter a lista de aplicativos instalados (substitua pela sua lógica)
        get() {
            val packageManager = packageManager
            val apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
            // ... sua lógica para filtrate aplicativos (opcional)
            return apps
        }
}
