package ayds.winchester1.wikipedia

import ayds.winchester1.wikipedia.artistinfo.*
import ayds.winchester1.wikipedia.artistinfo.JsonToArtistInfoResolver
import ayds.winchester1.wikipedia.artistinfo.WikipediaArtistServiceImpl
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object WikipediaInjector {
    private const val WIKIPEDIA_API_BASE_URL = "https://en.wikipedia.org/w/"
    private val wikipediaAPIRetrofit = Retrofit.Builder()
        .baseUrl(WIKIPEDIA_API_BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val wikipediaArtistInfoAPI = wikipediaAPIRetrofit.create(WikipediaArtistInfoAPI::class.java)
    private val wikipediaToArtistInfoResolver: WikipediaToArtistInfoResolver = JsonToArtistInfoResolver()
    val wikipediaService: WikipediaService = WikipediaArtistServiceImpl(
        wikipediaArtistInfoAPI,
        wikipediaToArtistInfoResolver
    )
}