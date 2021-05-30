package marvel.api.auth.config

import java.io.IOException
import java.io.InputStream
import java.util.*

class ConfigFileParser {

    fun getPropertiesFromFile() {
        val properties = Properties()
        try {
            val input: InputStream? = this::class.java.classLoader.getResourceAsStream(PROPERTIES_FILE_NAME)
            input?.let {
                properties.load(it)
                properties.entries.map { pair ->
                    System.setProperty("${pair.key}", "${pair.value}")
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    companion object {
        const val PROPERTIES_FILE_NAME = "config.properties"
    }
}