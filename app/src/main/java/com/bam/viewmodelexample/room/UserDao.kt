package com.bam.viewmodelexample.room


import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Dao

@Dao
interface UserDao {

    @Query("select * from UserData")
    fun getAll(): LiveData<List<UserData>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: UserData)
}