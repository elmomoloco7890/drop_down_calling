package prime.projects.dropdowncallingapp.model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

class DropDownViewModel: ViewModel() {
     fun makeShortToasts(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}