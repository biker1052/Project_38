package kg.tutorialapp.project_38

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    private fun setup() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container,Fragment_A(),Fragment_A.TAG)
            .add(R.id.container2,Fragment_B(),Fragment_B.TAG)
            .commit()
    }
}