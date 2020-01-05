
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemViewHolder(itemView: View) : ViewHolder(itemView) {
    @JvmField
    var itemContent: TextView

    init {
        itemContent = itemView.findViewById<View>(R.id.item_content) as TextView
    }
}