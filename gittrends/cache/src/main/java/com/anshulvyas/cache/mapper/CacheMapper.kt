package com.anshulvyas.cache.mapper

/**
 * Maps data between cache modules and data module
 */
interface CacheMapper<C, E> {

    fun mapFromCached(type: C): E

    fun mapToCached(type: E): C
}