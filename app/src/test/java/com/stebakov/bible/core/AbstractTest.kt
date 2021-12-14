package com.stebakov.bible.core

import org.junit.Assert.*
import org.junit.Test
import java.lang.Exception

class AbstractTest {

    @Test
    fun test_success() {

    }

    private sealed class TestDataObject : Abstract.Object<DomainObject, DomainToDataMapper>() {
        abstract override fun map(mapper: DomainToDataMapper): DomainObject

        class Success(private val textOne: String, private val textTwo: String) : TestDataObject() {
            override fun map(mapper: DomainToDataMapper): DomainObject {
                return mapper.map(textOne, textTwo)
            }
        }

        class Fail(private val exception: Exception) : TestDataObject() {
            override fun map(mapper: DomainToDataMapper): DomainObject {
                return mapper.map(exception)
            }
        }
    }

    private interface DomainToDataMapper : Abstract.Mapper {

        fun map(textOne: String, textTwo: String): DomainObject

        fun map(exception: Exception): DomainObject
    }

    private sealed class DomainObject : Abstract.Object<UIObject, DomainToUIMapper>() {
        class Success(private val textCombined: String) : DomainObject() {
            override fun map(mapper: DomainToUIMapper): UIObject {
                TODO("Not yet implemented")
            }

        }
    }

    private sealed class UIObject

    private interface DomainToUIMapper : Abstract.Mapper
}