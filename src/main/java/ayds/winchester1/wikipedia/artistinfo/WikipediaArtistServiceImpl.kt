package ayds.winchester1.wikipedia.artistinfo

import ayds.winchester1.wikipedia.WikipediaArtistInfo
import ayds.winchester1.wikipedia.WikipediaService
import retrofit2.Response

internal class WikipediaArtistServiceImpl (
    private val wikipediaArtistInfoAPI: WikipediaArtistInfoAPI,
    private val wikipediaToArtistInfoResolver: WikipediaToArtistInfoResolver,
    ) : WikipediaService {

        override fun getArtistInfo(artistName: String?): WikipediaArtistInfo? {
            val callResponse = getArtistInfoFromService(artistName)
            return wikipediaToArtistInfoResolver.getArtistInfoFromExternalData(callResponse.body())
        }

        private fun getArtistInfoFromService(query: String?): Response<String> {
            return wikipediaArtistInfoAPI.getArtistInfo(query)
                .execute()
        }
}