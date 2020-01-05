import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.livingnlight.knowyourpersonality.PersonalityActivity.Companion.bCount

class RecyclerViewAdapter(private val itemObjects: List<ItemObject>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == TYPE_HEADER) {
            val layoutView = LayoutInflater.from(parent.context)
                .inflate(R.layout.header_layout, parent, false)
            return HeaderViewHolder(layoutView)
        } else if (viewType == TYPE_ITEM) {
            val layoutView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
            return ItemViewHolder(layoutView)
        }
        throw RuntimeException("No match for $viewType.")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mObject = itemObjects[position]
        if (holder is HeaderViewHolder) {
            holder.headerTitle.text = mObject.title
            holder.headerImage.setImageResource(mObject.iconN!!)
            holder.expandButton.setOnClickListener {
                mObject.expanded = !mObject.expanded
                Log.i("Expanded: ", mObject.expanded.toString())
                notifyDataSetChanged()
            }
        } else if (holder is ItemViewHolder) {
                holder.itemContent.text = mObject.sectionData[position - 1]
        }
    }

    private fun getItem(position: Int): ItemObject {
        return itemObjects[position]
    }

    override fun getItemCount(): Int {
        return itemObjects.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (isPositionHeader(position)) TYPE_HEADER else TYPE_ITEM
    }

    private fun isPositionHeader(position: Int): Boolean {
        return position == 0 || (1+bCount+position)%2 == 0
    }

    companion object {
        private val TAG = RecyclerViewAdapter::class.java.simpleName
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

}