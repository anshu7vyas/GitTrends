package com.anshulvyas.data.mapper

interface EntityMapper<E, D> {

    // data passed from the data layer to domain layer
    fun mapFromEntity(entity: E): D

    // map from data layer to data layer
    fun mapToEntity(domain: D): E
}