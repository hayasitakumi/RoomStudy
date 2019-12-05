package momonyan.roomstudy.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users constructor(
    //データベースのデータ部分
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "users_id") val usersId: Int = 0,
    val name: String,
    val age: Int,
    val gender: Boolean,
    val hobby: String?
)
