package dotolhee.daramhee.setakfire.global.converter

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import dotolhee.daramhee.setakfire.global.enums.CategoryType
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class JsonStringArrayConverter : AttributeConverter<List<String>?, String?> {
    private val objectMapper = ObjectMapper()

    override fun convertToDatabaseColumn(attribute: List<String>?): String? {
        return attribute?.let { objectMapper.writeValueAsString(it) }
    }

    override fun convertToEntityAttribute(dbData: String?): List<String> {
        return dbData?.let {
            val typeRef = object : TypeReference<List<String>>() {}
            objectMapper.readValue(dbData, typeRef)
        } ?: emptyList()
    }
}

@Converter
class JsonCategoryTypeArrayConverter : AttributeConverter<List<CategoryType>?, String?> {
    private val objectMapper = ObjectMapper()

    override fun convertToDatabaseColumn(attribute: List<CategoryType>?): String? {
        return attribute?.let { objectMapper.writeValueAsString(it) }
    }

    override fun convertToEntityAttribute(dbData: String?): List<CategoryType> {
        return dbData?.let {
            val typeRef = object : TypeReference<List<CategoryType>>() {}
            objectMapper.readValue(dbData, typeRef)
        } ?: emptyList()
    }
}