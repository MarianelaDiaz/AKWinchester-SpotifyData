package ayds.winchester1.wikipedia.artistinfo

import ayds.winchester1.wikipedia.WikipediaArtistInfo
import ayds.winchester1.wikipedia.WikipediaCardService
import retrofit2.Response

internal class WikipediaArtistCardServiceImpl (
    private val wikipediaArtistInfoAPI: WikipediaArtistInfoAPI,
    private val wikipediaToArtistInfoResolver: WikipediaToArtistInfoResolver,
    ) : WikipediaCardService {

        override fun getCard(artistName: String?): WikipediaArtistInfo? {
            val callResponse = getArtistInfoFromService(artistName)
            return wikipediaToArtistInfoResolver.getCardFromExternalData(callResponse.body())
        }

        private fun getArtistInfoFromService(query: String?): Response<String> {
            return wikipediaArtistInfoAPI.getArtistInfo(query)
                .execute()
        }
}