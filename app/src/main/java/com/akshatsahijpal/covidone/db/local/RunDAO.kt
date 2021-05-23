package com.akshatsahijpal.covidone.db.local

import androidx.room.*
import com.akshatsahijpal.covidone.data.CovidData

@Dao
interface RunDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(userData: CovidData)

    @Delete
    suspend fun deleteRun(userData: CovidData)

    @Query("SELECT * FROM covid_table")
    fun getAllData(): List<CovidData>

    @Query("SELECT * FROM covid_table WHERE StateCity LIKE :query")
    fun getSearchResult(query:String)


}