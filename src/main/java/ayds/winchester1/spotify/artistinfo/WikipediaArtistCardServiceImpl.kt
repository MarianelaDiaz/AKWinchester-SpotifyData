package ayds.winchester1.spotify.artistinfo

import ayds.winchester1.spotify.WikipediaCard
import ayds.winchester1.spotify.WikipediaCardService
import retrofit2.Response

internal class WikipediaArtistCardServiceImpl (
    private val wikipediaArtistInfoAPI: WikipediaArtistInfoAPI,
    private val wikipediaToArtistInfoResolver: WikipediaToArtistInfoResolver,
    ) : WikipediaCardService {

        override fun getCard(artistName: String?): WikipediaCard? {
            val callResponse = getArtistInfoFromService(artistName)
            return wikipediaToArtistInfoResolver.getCardFromExternalData(callResponse.body())
        }

        private fun getArtistInfoFromService(query: String?): Response<String> {
            return wikipediaArtistInfoAPI.getArtistInfo(query)
                .execute()
        }
}