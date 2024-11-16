package me.ivanovpv.testapplication

import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import tech.mappie.api.ObjectMappie

@RunWith(AndroidJUnit4::class)
class MapperTest {

    @Test
    fun testClassic() {
        val person = Person("John", "Doe", 99)
        val dto = PersonToPersonDtoMapper.map(person)
        println("dto = $dto")
    }
}

object PersonToPersonDtoMapper : ObjectMappie<Person, PersonDto>() {
    override fun map(from: Person) = mapping {
        to::name fromValue "${from.name} ${to.name}"
    }
}

data class Person(
    val name: String,
    val surname: String,
    val age: Int,
)

data class PersonDto(
    val name: String,
    val age: Int,
)