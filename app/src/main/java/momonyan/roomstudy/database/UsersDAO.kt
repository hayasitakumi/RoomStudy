package momonyan.roomstudy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDAO {
    //DAO(Data Access Object)を作り、どのようなデータを取得するか指定する
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: Users)

    @Query("SELECT * FROM Users")
    fun findAll(): LiveData<List<Users>>

    //f:Man t:Woman
    @Query("SELECT * FROM Users WHERE gender == :gender")
    fun findGender(gender: Boolean): LiveData<List<Users>>
}