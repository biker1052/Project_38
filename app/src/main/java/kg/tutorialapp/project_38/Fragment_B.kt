package kg.tutorialapp.project_38

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment_B:Fragment(R.layout.fragment_b){
    lateinit var tv_textB : EditText
    private lateinit var listener :FragmentBListener
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btn2 = view.findViewById<Button>(R.id.button_b)

        btn2.setOnClickListener{
            tv_textB = view.findViewById<EditText>(R.id.EditText_b)
            listener.setTextToFragmentA(tv_textB.text.toString())
        }
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentBListener)listener=context
    }
    fun setNewText(text:String){
        var textView3_b = view?.findViewById<TextView>(R.id.textView3_b)
        textView3_b?.text = text
    }
    companion object{
        const val TAG="Fragment_B"
        fun new_instance(argument: String):Fragment_B {
            val fragmentB = Fragment_B()
            val args = Bundle()
            args.putString("String","Hello!!!")
            fragmentB.arguments = args
            return fragmentB

        }
    }

}