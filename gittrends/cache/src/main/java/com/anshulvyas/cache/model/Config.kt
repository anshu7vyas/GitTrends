package com.anshulvyas.cache.model

import android.arch.persistence.room.Entity
import com.anshulvyas.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
class Config (val lastTimeCache: Long)