package ayds.winchester1.wikipedia.artistinfo

import ayds.winchester1.wikipedia.WikipediaArtistInfo
import com.google.gson.Gson
import com.google.gson.JsonObject

private const val SNIPPET = "snippet"
private const val SEARCH = "search"
private const val PAGE_ID = "pageid"
private const val QUERY = "query"

interface WikipediaToArtistInfoResolver {
    fun getCardFromExternalData(serviceData: String?): WikipediaArtistInfo?
}

internal class JsonToArtistInfoResolver() : WikipediaToArtistInfoResolver {

    override fun getCardFromExternalData(serviceData: String?): WikipediaArtistInfo? =
        try {
            serviceData?.getFirstItem()?.let { item ->
                WikipediaArtistInfo(
                    item.getDescription(),
                    item.getInfoUrl()
                )
            }
        } catch (e: Exception) {
            null
        }

    private fun String?.getFirstItem(): JsonObject {
        val jobj = Gson().fromJson(this, JsonObject::class.java)
        val query = jobj[QUERY].asJsonObject
        val items = query[SEARCH].asJsonArray
        return items[0].asJsonObject
    }

    private fun JsonObject.getDescription() : String = this[SNIPPET].asString.replace("\\n", "\n")

    private fun JsonObject.getInfoUrl() : String = this[PAGE_ID].asString
}