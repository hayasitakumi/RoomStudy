package momonyan.roomstudy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import momonyan.roomstudy.database.AppDatabase
import momonyan.roomstudy.database.Users
import momonyan.roomstudy.recycler_view_content.RecyclerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    private lateinit var data: List<Users>

    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //データベースの初期宣言

        recyclerAdapter = RecyclerAdapter(this)

        //データをデータベースから取り出し、RecyclerViewに適用

        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //　アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner

                when (spinnerParent.selectedItem as String) {
                    "女" -> {
                        //女が選択された時、UsersDaoのfindGenderを使ってデータを適用
                    }
                    "男" -> {
                        //男が選択された時、UsersDaoのfindGenderを使ってデータを適用
                    }
                    else -> {
                        //何も選択されていない時のデータを適用
                    }
                }
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }
}
