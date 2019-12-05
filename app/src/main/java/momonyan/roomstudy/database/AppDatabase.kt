package momonyan.roomstudy.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    //DAOを呼びます
    //今回のDAOは一つだけ
    abstract fun usersDAO(): UsersDAO
}