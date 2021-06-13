package kg.tutorialapp.project_38

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment


class Fragment_A:Fragment(R.layout.fragment_a){
    lateinit var tv_text : EditText
    private lateinit var listener :FragmentAListener
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btn1 = view.findViewById<Button>(R.id.button_2)
        val textFromArgs = arguments?.getString("String")
        val textView3 = view.findViewById<TextView>(R.id.textView3)
        textView3.text = textFromArgs
        btn1.setOnClickListener{
            tv_text = view.findViewById<EditText>(R.id.editText1)
            listener.setTextToFragmentB(tv_text.text.toString())
        }
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAListener)listener=context
    }

    fun setNewText(text:String){
        var textView3 = view?.findViewById<TextView>(R.id.textView3)
        textView3?.text = text
    }
      companion object{
        const val TAG="Fragment_A"
          fun new_instance(argument: String):Fragment_A {
              val fragmentA = Fragment_A()
              val args = Bundle()
              args.putString("String","Hello!!!")
              fragmentA.arguments = args
              return fragmentA
    }
      }
}