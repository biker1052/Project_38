package kg.tutorialapp.project_38

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),FragmentAListener,FragmentBListener{
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawer_layout: DrawerLayout
    lateinit var navigation_viev: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawer_layout=findViewById(R.id.drawerLayout)
        navigation_viev=findViewById(R.id.nav_viev)
        toggle= ActionBarDrawerToggle(this,drawer_layout,R.string.open,R.string.close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viev.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> Toast.makeText(applicationContext,"Item 1 Cliced", Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(applicationContext,"Item 2 Cliced", Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(applicationContext,"Item 3 Cliced", Toast.LENGTH_SHORT).show()

            }
            true
        }

        setup()
    }

    private fun setup() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container,Fragment_A.new_instance("Hello!!!"),Fragment_A.TAG)
            .add(R.id.container2,Fragment_B(),Fragment_B.TAG)
            .commit()
    }

    override fun setTextToFragmentB(text: String) {
        (supportFragmentManager.findFragmentByTag(Fragment_B.TAG) as Fragment_B).setNewText(text)
    }
    override fun setTextToFragmentA(text: String) {
        (supportFragmentManager.findFragmentByTag(Fragment_A.TAG) as Fragment_A).setNewText(text)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }
}