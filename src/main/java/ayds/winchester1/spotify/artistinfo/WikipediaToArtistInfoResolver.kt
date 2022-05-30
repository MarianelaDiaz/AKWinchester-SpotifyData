package ayds.winchester1.spotify.artistinfo

import com.google.gson.Gson
import com.google.gson.JsonObject
import ayds.winchester1.spotify.WikipediaCard

private const val SNIPPET = "snippet"
private const val SEARCH = "search"
private const val PAGE_ID = "pageid"
private const val QUERY = "query"
private const val SOURCE = "Wikipedia"

interface WikipediaToArtistInfoResolver {
    fun getCardFromExternalData(serviceData: String?): WikipediaCard?
}

internal class JsonToArtistInfoResolver() : WikipediaToArtistInfoResolver {

    override fun getCardFromExternalData(serviceData: String?): WikipediaCard? =
        try {
            serviceData?.getFirstItem()?.let { item ->
                WikipediaCard(
                    item.getInfo(),
                    item.getPageId(),
                    SOURCE,
                    ""
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

    private fun JsonObject.getInfo() : String = this[ayds.winchester1.spotify.artistinfo.SNIPPET].asString.replace("\\n", "\n")

    private fun JsonObject.getPageId() : String = this[ayds.winchester1.spotify.artistinfo.PAGE_ID].asString
}