package com.turingalan.pokemon.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class Destination(val route: String) {
    @Serializable
    object List: Destination(route = "PokemonScreen")

    @Serializable
    data class Detail(val id: Long): Destination(route = "PokemonDetail[$id]")
}