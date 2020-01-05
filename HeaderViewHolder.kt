
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.math.exp

class HeaderViewHolder(itemView: View) : ViewHolder(itemView) {
    var headerTitle: TextView
    var headerImage: ImageView
    var expandButton: Button
    init {
        headerTitle = itemView.findViewById<View>(R.id.header_id) as TextView
        headerImage = itemView.findViewById<View>(R.id.header_image) as ImageView
        expandButton = itemView.findViewById<View>(R.id.ebutton) as Button
    }
}