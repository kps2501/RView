
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.livingnlight.knowyourpersonality.MainActivity.Companion.personality
import kotlinx.android.synthetic.main.activity_personality.*

class SomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personality)

        recyclerView = findViewById(R.id.recyclerView)
        var layout: LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)
        var adapter: RecyclerViewAdapter = RecyclerViewAdapter(getDataSource())

        bCount = data.count()
        recyclerView.adapter = adapter

        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun getDataSource(): List<ItemObject> {
        val data: MutableList<ItemObject> = ArrayList()
        data.add(ItemObject("Test", listOf(""), R.drawable.ic_box, true))
        data.add(ItemObject(null, listOf("Lorem ipsum dolor... Aliquam nec arcu quam."), null, false))
        return data
    }

    companion object {
        var bCount = 0
    }

}
